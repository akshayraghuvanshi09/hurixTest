package com.hurix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hurix.constant.ErrorMsg;
import com.hurix.entity.User;
import com.hurix.response.BookUserResponse;
import com.hurix.response.PaginationResponse;
import com.hurix.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("static-access")
	@GetMapping("/get")
	public ResponseEntity<?> getBookList(@RequestParam(required = false) Integer pageNo,
			@RequestParam(required = false) Integer pageSize,@RequestParam(required = false) String  sortedBy,@RequestParam(required = false) String sortDirection) {

		PaginationResponse paginationResponse = userService.getBookList(pageNo, pageSize,sortedBy,sortDirection);
		if (paginationResponse.getData() != null) {
			return new ResponseEntity<List<BookUserResponse>>(HttpStatus.OK).ok(paginationResponse);
		} else {
			return ResponseEntity.ok().body(ErrorMsg.REOCRD_NOT_FOUND);
		}

	}

	@PostMapping("/addUser")
	public ResponseEntity<?> saveBook(@RequestBody User user) {
		int saveUser = userService.saveUser(user);
		if (saveUser == 0) {
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		} else {
			return new ResponseEntity(HttpStatus.CREATED).ok(saveUser + " record is save");
		}
	}

}
