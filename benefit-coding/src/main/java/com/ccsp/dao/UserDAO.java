package com.ccsp.dao;

import java.util.List;

import com.ccsp.entity.User;

public interface UserDAO {

	List<User> findById();

}
