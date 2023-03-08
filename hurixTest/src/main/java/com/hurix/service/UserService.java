package com.hurix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurix.dao.UserDao;
import com.hurix.entity.Book;
import com.hurix.entity.User;
import com.hurix.response.PaginationResponse;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public PaginationResponse getBookList(Integer pageNo, Integer pageSize,String sortedBy ,String sortDirection) {

		return userDao.getBookList(pageSize, pageNo,sortedBy,sortDirection);
	}
	
	
	public int saveUser(User user) {
		return userDao.addUser(user);
	}
	
}
