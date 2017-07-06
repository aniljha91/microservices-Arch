package com.ccsp.dao;

import com.ccsp.model.User;

@FunctionalInterface
public interface UserDAO {

	User findById(String userName);

}
