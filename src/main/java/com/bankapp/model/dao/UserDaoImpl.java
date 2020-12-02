package com.bankapp.model.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	

	private SessionFactory factory;
	
	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("from User").getResultList();
	}

	@Override
	public User addUser(User user) {
		getSession().save(user);
		return user;
	}

	@Override
	public User deleteUser(User user) {
		User userToBeDeleted = getUser(user.getUsername(), user.getPassword());
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public User updateUser(User user) {
		User userToBeUpdated = getUser(user.getUsername(), user.getPassword());
		getSession().update(user);
		return user;
	}

	@Override
	public User getUser(String username, String password) {
		Query query = getSession().createQuery("from User where username=:username1 and password=:password1");
		query.setParameter("username1", username);
		query.setParameter("password1", password);
		User user = (User) query.getSingleResult();
		return user;
	}
}