package com.hurix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hurix.entity.Book;
import com.hurix.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		System.out.println(book.getAuthor()+""+book.getTitle());
		int saveBook = bookService.saveBook(book);
		if (saveBook == 0) {
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}else {
			return new ResponseEntity(HttpStatus.CREATED).ok(saveBook+" record is save");
		}
	}
}
