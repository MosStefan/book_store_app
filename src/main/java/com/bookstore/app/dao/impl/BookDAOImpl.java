package com.bookstore.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.app.dao.BookDAO;
import com.bookstore.app.dao.GenreDAO;
import com.bookstore.app.model.Book;
import com.bookstore.app.model.Genre;
import com.bookstore.app.service.BookService;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GenreDAO genreDAO; 

	private class BookZanrRowCallBackHandler implements RowCallbackHandler {

		private Map<Long, Book> books = new LinkedHashMap<>();
		
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			int index = 1;
			Long bookId = rs.getLong(index++);
			Book book = books.get(bookId);
			if(book == null) {
				book = new Book();
				book.setIsbn(rs.getString(index++));
				book.setNameOfBook(rs.getString(index++));
				book.setYearOfPublication(rs.getInt(index++));
				book.setShortDescription(rs.getString(index++));
				book.setPrice(rs.getDouble(index++));
				book.setPrintingHouse(rs.getString(index++));
				book.setAuthor(rs.getString(index++));
				book.setNumberPages(rs.getInt(index++));
				book.setBookCover(rs.getString(index++));
				book.setLetter(rs.getString(index++));
				book.setLanguage(rs.getString(index++));
				book.setAverageMarkBook(rs.getDouble(index++));

				book.setNumberOfExample(rs.getInt(index++));
				books.put(bookId, book);
			}
			/*
			String isbn = resultSet.getString(index++);
			String namebook = resultSet.getString(index++);
			Integer yearPublication = resultSet.getInt(index++);
			String shortDescription = resultSet.getString(index++);
			Double price = resultSet.getDouble(index++);
			String printingHouse = resultSet.getString(index++);
			String author = resultSet.getString(index++);
			String namebook = resultSet.getString(index++);

			String namebook = resultSet.getString(index++);
*/
			

		

			Long genreId = rs.getLong(index++);
			String genreName = rs.getString(index++);
			String genreDescription = rs.getString(index++);
			Genre genre = new Genre();
			genre.setId(genreId);
			genre.setName(genreName);
			genre.setDescription(genreDescription);
			book.getGenres().add(genre);
		}
	
	
	/*
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setNameOfBook(rs.getString("name_of_book"));
		book.setAuthor(rs.getString("author"));
		book.setNumberOfExample(rs.getInt("number_of_example"));
		book.setNumberPages(rs.getInt("number_pages"));
		book.setPrice(rs.getDouble("price"));
		book.setYearOfPublication(rs.getInt("year_of_publication"));
		book.setPrintingHouse(rs.getString("printing_house"));
		book.setLanguage(rs.getString("language"));
		book.setShortDescription(rs.getString("short_description"));
		book.setLetter(rs.getString("letter"));
		book.setBookCover(rs.getString("book_cover"));
		book.setAverageMarkBook(rs.getDouble("average_mark_book"));
		
		return book;
	}
	*/



		public List<Book> getAllBooks() {
			return new ArrayList<>(books.values());
		}
	

	
	}

	@Override
	public List<Book> getBooks() {
		String sql = 
				"SELECT b.*, g.* FROM book b " + 
				"LEFT JOIN bookgenre bg ON bg.bookid = b.id " + 
				"LEFT JOIN genre g ON bg.genreid = g.id " + 
				"ORDER BY b.id";

		BookZanrRowCallBackHandler rowCallbackHandler = new BookZanrRowCallBackHandler();
		jdbcTemplate.query(sql, rowCallbackHandler);

		return rowCallbackHandler.getAllBooks();
	} 
}
