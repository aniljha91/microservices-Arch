package com.ccsp.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ccsp.dao.PlanDAO;
import com.ccsp.utils.QueryConstant;

@Repository
public class PlanDAOImpl  implements PlanDAO {
	
	final Logger logger = Logger.getLogger(UserDAOImpl.class);

	private JdbcTemplate jdbcTemplate;
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String getServiceRules() {
		String result = jdbcTemplate.queryForObject(QueryConstant.RULEQUERY.query(), String.class);
		return result;
	}
	
	@Override
	public void updateRules(String value){
		StringBuilder query = new StringBuilder(QueryConstant.UPDATERULEQUERY.query()).append("\'").append(value).append("\'");
		jdbcTemplate.execute(query.toString());
	}
	
	@Override
	public void updateTotalDeductableAmount(double amount, String planId, int memberId){
		StringBuilder query = new StringBuilder(QueryConstant.UPDATETOTALDEDUCTABLEAMOUNT.query()).append(amount).append(" where plan_id ='").append(planId).append("'").append(" and member_id =").append(memberId);
		jdbcTemplate.execute(query.toString());
	}

}
