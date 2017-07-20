package com.org.gateway.service;

import java.util.List;

import com.org.gateway.entity.User;

public interface UserService {
	
	User findByName(String userName);
	List<User> listOfUsers();
	
}
