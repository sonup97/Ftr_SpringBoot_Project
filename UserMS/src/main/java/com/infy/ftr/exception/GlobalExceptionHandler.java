package com.infy.ftr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorMessage> HandleException(UserException e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setMsg(e.getMessage());
		
		return new ResponseEntity<ErrorMessage>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> HandleException(Exception e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setMsg(e.getMessage());
		
		return new ResponseEntity<ErrorMessage>(err, HttpStatus.BAD_REQUEST);
	}


}