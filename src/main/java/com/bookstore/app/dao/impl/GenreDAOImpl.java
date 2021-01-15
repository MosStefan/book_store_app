package com.bookstore.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.app.dao.GenreDAO;
import com.bookstore.app.model.Genre;

@Repository
public class GenreDAOImpl implements GenreDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class GenreRowMapper implements RowMapper<Genre> {

		@Override
		public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
			int index = 1;
			Long id = rs.getLong(index++);
			String name = rs.getString(index++);
			String description = rs.getString(index++);
			Genre genre = new Genre();
			genre.setId(id);
			genre.setName(name);
			genre.setDescription(description);
			return genre;
		}

	}
	
	

	@Override
	public List<Genre> getGenres() {
		String sql = "SELECT id, name, description FROM genre";
		return jdbcTemplate.query(sql, new GenreRowMapper());
	}

}
