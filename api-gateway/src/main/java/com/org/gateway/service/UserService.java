package com.org.gateway.service;

import com.org.gateway.entity.User;

public interface UserService {
	
	User findByName(String userName);
	
}
