package com.infy.ftr.dto;

public class Message {
	
	private String message;

	public Message(String message) { 
		this.message=message;
	}
	
	public Message() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
