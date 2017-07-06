package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.UserDAO;
import com.ccsp.model.User;
import com.ccsp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserDAO userDAO;

	@Override
	public User findById(String userName) {
		return userDAO.findById(userName);
	}

}
