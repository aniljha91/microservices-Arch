package com.ccsp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ccsp.dao.UserDAO;
import com.ccsp.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findById() {
		Query query = entityManager.createNativeQuery("SELECT * FROM users", User.class);
		return (List<User>) query.getResultList();
	}

}
