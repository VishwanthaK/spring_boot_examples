package com.vacker.example.multiple_db.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import com.vacker.example.multiple_db.domain.ExceptionResponse;


@RestControllerAdvice
public class GlobalRuntimeExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalRuntimeExceptionHandler.class);
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ExceptionResponse handleIndexOutOfBoundsException(HttpServletRequest request, Exception ex) {
		LOGGER.error("IndexOutOfBoundsException Occured :: URL = "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage("Internal server error : Index out of bound exception!!");
		return exceptionResponse;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(IOException.class)
	public ExceptionResponse handleIOException(HttpServletRequest request, Exception ex){
		LOGGER.error("IOException Occured :: URL :: "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage("Internal server error : IO exception!!");
		return exceptionResponse;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public ExceptionResponse handleNullpointerException(HttpServletRequest request, Exception ex){
		LOGGER.error("NullPointerException Occured :: URL :: "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage("Internal server error : null pointer exception!!");
		return exceptionResponse;
	}
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ExceptionResponse handleJpaRepoException(HttpServletRequest request, Exception ex){
		LOGGER.error("NullPointerException Occured :: URL :: "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage("Internal server error : null pointer exception!!");
		return exceptionResponse;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse handleUncaughtExceptions(HttpServletRequest request, Exception ex) {
		LOGGER.error("Un-caught Exceptions Occured :: URL = "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		return exceptionResponse;
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MultipartException.class)
    public ExceptionResponse handleMultipartException(MultipartException ex, HttpServletRequest request) {
		LOGGER.error("Un-caught Exceptions Occured :: URL = "+request.getRequestURL());
		LOGGER.error("Exception :: "+ex);
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		return exceptionResponse;

	}

}
