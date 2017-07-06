package com.ccsp.service;

import com.ccsp.model.User;


@FunctionalInterface
public interface UserService {
	
	User findById(String userName);
	
}
