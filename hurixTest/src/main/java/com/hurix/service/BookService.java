package com.hurix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurix.dao.BookDao;
import com.hurix.entity.Book;

@Service
public class BookService {

	@Autowired 
	private BookDao bookDao;
	
	public int saveBook(Book book) {
		return bookDao.addBook(book);
	}

}
