package com.ccsp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.UserDAO;
import com.ccsp.dao.impl.PlanDAOImpl;
import com.ccsp.dao.impl.UserDAOImpl;
 
@Configuration
@Component
public class SpringJDBCConfiguration {
	
	@Autowired
	public DataSource dataSource;
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
 
    @Bean
    public UserDAO userDAO(){
        UserDAOImpl userDao = new UserDAOImpl();
        userDao.setJdbcTemplate(jdbcTemplate());
        return userDao;
    }
    
    @Bean
    public PlanDAO planDAO(){
    	PlanDAOImpl planDao = new PlanDAOImpl();
    	planDao.setJdbcTemplate(jdbcTemplate());
        return planDao;
    }
    
}
