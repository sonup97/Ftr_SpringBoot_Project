package com.infy.ftr.dto;

import javax.validation.constraints.NotNull;

public class LoginDTO {

	@NotNull(message = "{user.userId.must}")
	int userId;
	
	@NotNull(message = "{user.password.must}")
	String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassowrd(String passowrd) {
		this.password = passowrd;
	}
	
	
}
