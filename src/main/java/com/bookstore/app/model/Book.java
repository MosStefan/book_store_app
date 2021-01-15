package com.bookstore.app.model;

import java.util.List;

public class Book {
	     
	    private Long id;
	    
	    private String isbn;
	     	
	    private String nameOfBook;
	     
	    private String printingHouse;
	    
	    private String author;
	    
	    private Integer yearOfPublication;
	     
	    private String shortDescription;
	    	    
	    private Double price;
	    
	    private Integer numberPages;
	    
	    private String bookCover;
	    
	    private String letter;
	    
	    private String language;
	    
	    private Double averageMarkBook;
	    
	    private Integer numberOfExample;
	    private List<Genre> genres;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getNameOfBook() {
			return nameOfBook;
		}

		public void setNameOfBook(String nameOfBook) {
			this.nameOfBook = nameOfBook;
		}

		public String getPrintingHouse() {
			return printingHouse;
		}

		public void setPrintingHouse(String printingHouse) {
			this.printingHouse = printingHouse;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Integer getYearOfPublication() {
			return yearOfPublication;
		}

		public void setYearOfPublication(Integer yearOfPublication) {
			this.yearOfPublication = yearOfPublication;
		}

		public String getShortDescription() {
			return shortDescription;
		}

		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getNumberPages() {
			return numberPages;
		}

		public void setNumberPages(Integer numberPages) {
			this.numberPages = numberPages;
		}

		public String getBookCover() {
			return bookCover;
		}

		public void setBookCover(String bookCover) {
			this.bookCover = bookCover;
		}

		public String getLetter() {
			return letter;
		}

		public void setLetter(String letter) {
			this.letter = letter;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public Double getAverageMarkBook() {
			return averageMarkBook;
		}

		public void setAverageMarkBook(Double averageMarkBook) {
			this.averageMarkBook = averageMarkBook;
		}

		public Integer getNumberOfExample() {
			return numberOfExample;
		}

		public void setNumberOfExample(Integer numberOfExample) {
			this.numberOfExample = numberOfExample;
		}

		public List<Genre> getGenres() {
			return genres;
		}

		public void setGenres(List<Genre> genres) {
			this.genres = genres;
		}
		
		

		
	    
}
