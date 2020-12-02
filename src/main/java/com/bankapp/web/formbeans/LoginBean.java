package com.bankapp.web.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {

	@NotEmpty(message = "User Role can not be left blank")
	private String username;

	@NotEmpty(message = "Password can not be left blank")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}