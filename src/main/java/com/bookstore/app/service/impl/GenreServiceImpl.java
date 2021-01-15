package com.bookstore.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.dao.GenreDAO;
import com.bookstore.app.model.Genre;
import com.bookstore.app.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDAO genreDAO;
	@Override
	public List<Genre> getAllGenres() {
		return genreDAO.getGenres();
	}

}
