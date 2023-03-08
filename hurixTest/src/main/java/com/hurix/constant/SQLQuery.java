package com.hurix.constant;

public class SQLQuery {
 public static final String bookListWithoutLimit = "select b.title, b.author, u.name from book b join user_book ub on ub.book_id = b.id join user u on ub.user_id = u.id ";
// public static final String bookListWithLimit ="select b.title, b.author, u.name from book b join user_book ub on ub.book_id = b.id join user u on ub.user_id = u.id LIMIT ?, ?";
 public static final String bookListWithLimitWithSortin ="select b.title, b.author, u.name from book b "
 						+ "join user_book ub on ub.book_id = b.id join user u on ub.user_id = u.id order by ?,? LIMIT ?, ? ";
 public static final String CountOfBookUser="SELECT count(id) from user_book";
}

