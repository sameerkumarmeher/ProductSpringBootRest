package com.globallogic.exceptions;

public class ProductNotFoundException extends RuntimeException{

	String msg;

	public ProductNotFoundException(String msg) {
		super();
		this.msg = msg;
	}


	public String getMsg() {
		return msg;
	}
	
}
