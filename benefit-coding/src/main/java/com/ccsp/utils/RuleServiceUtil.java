package com.ccsp.utils;

import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;

public class RuleServiceUtil {
	
	public Claim prepareClaim(Claim claim, PlanServiceEntity ruleEntity, double amount) {
		claim.setTotalDeductableAmount(amount);
		claim.setIsServiceAllowed(ruleEntity.getServiceAllowed());
		claim.setIsIgnoreCostShare(ruleEntity.getCostShareAllowed());
		claim.setIsCoPayAllowed(ruleEntity.getCoPayAllowed());
		claim.setIsCoInsuranceAllowed(ruleEntity.getCoInsuranceAllowed());
		claim.setIsDeductableAllowed(ruleEntity.getDeductableAllowed());
		claim.setIsNetwork(ruleEntity.getNetworkType());
		claim.setCoPayAmount(ruleEntity.getCoPayAmount());
		claim.setCoInsuranceAmount(ruleEntity.getCoInsuranceAmount());
		claim.setMaximumAllowedAmount(ruleEntity.getMaximumAllowedAmount());
		claim.setMaxDeductableAmountAllowed(ruleEntity.getMaximumDeductableAmount());
		return claim;
	}

}
