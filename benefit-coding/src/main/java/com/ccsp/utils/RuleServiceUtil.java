package com.ccsp.utils;

import com.ccsp.entity.PlanServiceEntity;
import com.ccsp.model.Claim;

public class RuleServiceUtil {
	
	public Claim prepareClaim(Claim claim, PlanServiceEntity ruleEntity, double amount) {
		claim.setTotalDeductableAmount(amount);
		claim.setAccumulatorINDeductAmount(Double.valueOf(claim.getAccumulatorINDeductAmount())==0 ? 1000: claim.getAccumulatorINDeductAmount());
		claim.setAccumulatorINOpexAmount(Double.valueOf(claim.getAccumulatorINOpexAmount())==0 ? 1000: claim.getAccumulatorINOpexAmount());
		claim.setAccumulatorONDeductAmount(Double.valueOf(claim.getAccumulatorONDeductAmount())==0 ? 1000: claim.getAccumulatorONDeductAmount());
		claim.setAccumulatorONOpexAmount(Double.valueOf(claim.getAccumulatorONOpexAmount())==0 ? 1000: claim.getAccumulatorONOpexAmount());
		claim.setPaidByCompanyInsuranceAmount(Double.valueOf(claim.getPaidByCompanyInsuranceAmount())==0 ? 500: claim.getPaidByCompanyInsuranceAmount());
		claim.setPatientDeductableAmount(Double.valueOf(claim.getPatientDeductableAmount())==0 ? 400: claim.getPatientDeductableAmount());
		claim.setPatientCoInsuranceAmount(Double.valueOf(claim.getPatientCoInsuranceAmount())==0 ? 300: claim.getPatientCoInsuranceAmount());
		claim.setPatientCoPayAmount(Double.valueOf(claim.getPatientCoPayAmount())==0 ? 500: claim.getPatientCoPayAmount());
		claim.setAge(ruleEntity.getAge());
		claim.setIsServiceAllowed(ruleEntity.getServiceAllowed());
		claim.setIsIgnoreCostShare(ruleEntity.getCostShareAllowed());
		claim.setIsCoPayAllowed(ruleEntity.getCoPayAllowed());
		claim.setIsCoInsuranceAllowed(ruleEntity.getCoInsuranceAllowed());
		claim.setIsDeductableAllowed(ruleEntity.getDeductableAllowed());
		claim.setIsNetwork(ruleEntity.getNetworkType());
		claim.setCoPayAmount(ruleEntity.getCoPayAmount() == 0 ? 1000 : ruleEntity.getCoPayAmount());
		claim.setCoInsuranceAmount(ruleEntity.getCoInsuranceAmount() == 0 ? 500 : ruleEntity.getCoInsuranceAmount());
		claim.setMaximumAllowedAmount(ruleEntity.getMaximumAllowedAmount() == 0 ? 500 : ruleEntity.getMaximumAllowedAmount());
		claim.setMaxDeductableAmountAllowed(ruleEntity.getMaximumDeductableAmount() == 0 ? 1000 : ruleEntity.getMaximumDeductableAmount());
		return claim;
	}

}
