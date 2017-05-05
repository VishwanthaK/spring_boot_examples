package com.vacker.example.jwt_sample.exception;

import java.io.Serializable;

public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = 5299096808961968410L;
	
	private int code;
	private String message;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
