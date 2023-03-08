package com.hurix.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse  {

	private Object data;
	private Integer totalPage;
	private Integer totalRecord;
	private Integer pageNoStartWith;
	private Integer recordPerPage;
}
