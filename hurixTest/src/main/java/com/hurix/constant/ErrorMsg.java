package com.hurix.constant;


public enum ErrorMsg {
REOCRD_NOT_FOUND("Data Not Found");
	
	private String msg ;

	private ErrorMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	
}
