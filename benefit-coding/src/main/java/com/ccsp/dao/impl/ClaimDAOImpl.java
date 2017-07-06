package com.ccsp.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ccsp.dao.ClaimDAO;
import com.ccsp.dao.UserDAO;
import com.ccsp.dao.UserMapper;
import com.ccsp.dto.ClaimRequest;
import com.ccsp.model.Claim;
import com.ccsp.model.User;
import com.ccsp.utils.QueryConstant;

@Repository
public class ClaimDAOImpl  implements ClaimDAO {
	
	final Logger logger = Logger.getLogger(ClaimDAOImpl.class);

	private JdbcTemplate jdbcTemplate;
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	



	@Override
	public Claim getRuleSet(ClaimRequest claimRequest) {
		Claim claim = new Claim();
		claim.setMemberId(claimRequest.getMemberId());
		claim.setBilledAmount(claimRequest.getBilledAmount());
		claim.setDiagnosticCode(claimRequest.getDiagnosticCode());
		claim.setPlanName(claimRequest.getPlanName());
		claim.setProcedureCode(claimRequest.getProcedureCode());
		
		int serviceCode=0;
		StringBuilder query = new StringBuilder("select serviceCode FROM ProcDiagDetails WHERE procCode = '").append(claimRequest.getProcedureCode()).append("AND diagCode=").append(claimRequest.getDiagnosticCode()).append("'");
		try{
			serviceCode = jdbcTemplate.queryForObject(query.toString(), Integer.class);
			logger.info("service code is:"+ serviceCode);
		}catch(Exception exception){
			serviceCode = 0;
			logger.error(exception.getMessage(),exception);
		}
        return claim;
	}

}
