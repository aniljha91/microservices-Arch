package com.org.gateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.gateway.dao.UserDAO;
import com.org.gateway.entity.User;
import com.org.gateway.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserDAO userDAO;

	@Override
	public User findByName(String userName) {
		return userDAO.findByName(userName);
	}

}
