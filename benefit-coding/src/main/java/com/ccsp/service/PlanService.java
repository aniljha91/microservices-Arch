package com.ccsp.service;

import java.util.List;

import com.ccsp.dto.EditPlanService;
import com.ccsp.model.PlanServiceEntity;

public interface PlanService {
	
	List<PlanServiceEntity> getPlanServices(String planId,String networkType);
	String getServiceRules(String palnId);
	void updateRules(String planId,String value);
	void updateRulesForPlan(List<EditPlanService> planServiceList);

}
