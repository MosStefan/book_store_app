package com.bookstore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bookstore.app.model.Book;
import com.bookstore.app.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/allBooks")
	public String showAllBooks(Model model) {
		List<Book> listOfBooks = bookService.getAllBooks();
		model.addAttribute("listBooks", listOfBooks);
		return "books";
	}
}
