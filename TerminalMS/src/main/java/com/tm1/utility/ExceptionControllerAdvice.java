package com.tm1.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exception.TerminalMSException;



@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	Environment environment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TerminalMSException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(TerminalMSException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
	}

}