package com.hurix.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.hurix.entity.Book;
@Repository
public class BookDao {
	
	@Autowired
	private JdbcTemplate template;

public int addBook(Book book) {
		
		String saveBookQuery ="insert into user.book (title,author) values (?,?)";
		System.out.println(book.getAuthor()+" "+book.getTitle());
		
		Object[] arg ={book.getTitle(),book.getAuthor()};
		
		int noOfRowInserted = template.update(saveBookQuery, arg);
		System.out.println("No of Row Inserted Is "+noOfRowInserted);
		return noOfRowInserted;
	}

}
