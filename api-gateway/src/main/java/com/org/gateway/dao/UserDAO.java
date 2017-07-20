package com.org.gateway.dao;

import java.util.List;

import com.org.gateway.entity.User;

public interface UserDAO {

	public User findByName(String userName);
	public List<User> listOfUsers();

}
