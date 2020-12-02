package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserBean {

	private Integer uid;

	@NotEmpty(message = "Username can not be left blank")
	private String username;

	@NotEmpty(message = "Password can not be left blank")
	private String password;

	@NotEmpty(message = "User Role can not be left blank")
	private String userType;

	@NotEmpty(message = "Address can not be left blank")
	private String address;

	@NotEmpty(message = "Phone number can not be left blank")
	private String phone;

	@NotEmpty(message = "Email can not be left blank")
	private String email;
	
	@NotEmpty(message = "Aadhar Card can not be left blank")
	private String aadharCard;
	
	@NotEmpty(message = "Pan Number can not be left blank")
	private String panNumber;

	public UserBean() {
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
}