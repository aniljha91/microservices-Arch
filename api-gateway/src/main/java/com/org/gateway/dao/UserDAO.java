package com.org.gateway.dao;

import com.org.gateway.entity.User;

public interface UserDAO {

	public User findByName(String userName);

}
