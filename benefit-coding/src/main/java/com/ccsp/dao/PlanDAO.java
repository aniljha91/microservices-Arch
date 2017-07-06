package com.ccsp.dao;

public interface PlanDAO {
	
	String getServiceRules();

	void updateRules(String value);

	void updateTotalDeductableAmount(double amount, String planId, int memberId);
	
}
