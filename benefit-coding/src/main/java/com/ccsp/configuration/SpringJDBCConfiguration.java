package com.ccsp.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.UserDAO;
import com.ccsp.dao.impl.PlanDAOImpl;
import com.ccsp.dao.impl.UserDAOImpl;
 
@Configuration
public class SpringJDBCConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://USHYDBSAKARIBO8:1434;databaseName=BCD");
        dataSource.setUsername("bcd");
        dataSource.setPassword("Password#123");
        
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
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
