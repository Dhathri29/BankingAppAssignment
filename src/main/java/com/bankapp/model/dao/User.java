package com.bankapp.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer uid;
	 
	 
	 private String username;
	 
	 
	 private String password;
	 
	 @Enumerated(EnumType.STRING)
	 private UserType userType;
	 
	 @Column(nullable = false)
	 private String address;
	 
	 @Column(unique = true, nullable = false)
	 private String phone;
	 
	 @Column(unique = true, nullable = false)
	 private String  email;
	 
	public User() {
	}

	public User(String username, String password, UserType userType, String address, String phone, String email) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.phone = phone;
		this.email = email;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}

	
}