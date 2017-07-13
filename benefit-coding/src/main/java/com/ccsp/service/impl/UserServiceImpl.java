package com.ccsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.UserDAO;
import com.ccsp.entity.User;
import com.ccsp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserDAO userDAO;

	@Override
	public List<User> findById() {
		return userDAO.findById();
	}

}
