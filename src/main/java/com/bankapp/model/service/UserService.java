package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.User;

public interface UserService {

	public List<User> getAllUsers();
	public User addUser(User user);
	public User deleteUser(User user);
	public User updateUser(User user);
	public User getUser(String username, String password);
	
}