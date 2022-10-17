package com.tm1.customExceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}

	public ServiceException(String error) {
		super(error);
	}
	
	
}
