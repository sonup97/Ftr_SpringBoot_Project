package com.infy.ftr.exception;

public class FTRException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public FTRException() {
		super();
	}

	public FTRException(String errors) {
		super(errors);
		
	}
}
