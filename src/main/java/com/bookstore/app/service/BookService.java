package com.bookstore.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.app.model.Book;

@Service
public interface BookService {
	
	public List<Book> getAllBooks();

}
