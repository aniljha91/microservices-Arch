package com.ccsp.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ccsp.dao.UserDAO;
import com.ccsp.dao.UserMapper;
import com.ccsp.model.User;
import com.ccsp.utils.QueryConstant;

@Repository
public class UserDAOImpl  implements UserDAO {
	
	final Logger logger = Logger.getLogger(UserDAOImpl.class);

	private JdbcTemplate jdbcTemplate;
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
    public User findById(String userName) {
		User user = null;
		StringBuilder query = new StringBuilder(QueryConstant.USERQUERY.query()).append(" WHERE userName = '").append(userName).append("'");
		try{
			user = jdbcTemplate.queryForObject(query.toString(), new UserMapper());
		}catch(Exception exception){
			user = null;
			logger.error(exception.getMessage(),exception);
		}
        return user;
    }

}
