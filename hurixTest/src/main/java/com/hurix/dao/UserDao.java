package com.hurix.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.hurix.constant.SQLQuery;
import com.hurix.entity.Book;
import com.hurix.entity.User;
import com.hurix.response.BookUserResponse;
import com.hurix.response.PaginationResponse;

@Repository
public class UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	JdbcTemplate template;

	public PaginationResponse getBookList(Integer pageSize, Integer pageNo,String sortedBy,String sortDirection) {
		log.info("inside getBookList");
		
		System.out.println(pageSize+" "+pageNo+" "+sortedBy+" "+sortDirection);
//////////////////
		Integer totalRecords = template.queryForObject(SQLQuery.CountOfBookUser, Integer.class);
		int totalpage = 0;

		if (pageSize == null) {
			totalpage = 1;
		} else {
			totalpage = (int) Math.ceil((double) totalRecords / pageSize);
		}
/////////////////
		String query;

		if (pageSize == null || pageNo == null || sortedBy == null || sortDirection ==null) {
			log.info("inside null condition");
			query = SQLQuery.bookListWithoutLimit;
		} else {

			query = SQLQuery.bookListWithLimitWithSortin;
		}
		List<BookUserResponse> result = template.query(query, ps -> {
			if (!(pageSize == null || pageNo == null)) {
				ps.setInt(4, pageSize);
				ps.setInt(3, pageNo * pageSize);
				ps.setString(1, sortedBy);
				ps.setString(2, sortDirection);
			}
		}, new ResultSetExtractor<List<BookUserResponse>>() {

			@Override
			public List<BookUserResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<BookUserResponse> list = new ArrayList<BookUserResponse>();
				while (rs.next()) {
					BookUserResponse dbResponse = new BookUserResponse();
					dbResponse.setTitle(rs.getString("title"));
					dbResponse.setAuthor(rs.getString("author"));
					dbResponse.setName(rs.getString("name"));
					list.add(dbResponse);
				}
				return list;
			};
		});
//		return result;
		System.out.println(result);

		return new PaginationResponse(result, totalpage, totalRecords, pageNo, pageSize);

	}

	public int addUser(User user) {

		String adddUser = "insert into user.users (user,userName,password,city) value (?,?,?,?)";

		Object[] arg = { user.getUser(), user.getUser(), user.getPassword(), user.getPassword() };
		int noOfRowInserted = template.update(adddUser, arg);
		return noOfRowInserted;
	}
	

}
