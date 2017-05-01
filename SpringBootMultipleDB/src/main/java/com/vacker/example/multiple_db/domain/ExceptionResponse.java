package com.vacker.example.multiple_db.domain;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = 5299096808961968410L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
