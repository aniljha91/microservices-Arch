package com.ccsp.dao;

import com.ccsp.model.PlanServiceEntity;

public interface RuleDAO {
	
	PlanServiceEntity getServiceRule(String planId, String serviceName);

	Double getTotalDeductableAmount(int memberId, String planId);
}
