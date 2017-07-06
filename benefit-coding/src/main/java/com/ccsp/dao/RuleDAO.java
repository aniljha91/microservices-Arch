package com.ccsp.dao;

import com.ccsp.entity.PlanServiceEntity;

public interface RuleDAO {
	
	PlanServiceEntity getServiceRule(String planId, String serviceName);

	Double getTotalDeductableAmount(int memberId, String planId);
}
