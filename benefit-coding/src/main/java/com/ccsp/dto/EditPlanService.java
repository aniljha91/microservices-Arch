package com.ccsp.dto;

public class EditPlanService {
	
	private String planId;
	private String benefitServiceName;
	private String isModified;
	private String[] configurablePhrase;
	private String[] benefitServiceRuleValue;
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getBenefitServiceName() {
		return benefitServiceName;
	}
	public void setBenefitServiceName(String benefitServiceName) {
		this.benefitServiceName = benefitServiceName;
	}
	public String getIsModified() {
		return isModified;
	}
	public void setIsModified(String isModified) {
		this.isModified = isModified;
	}
	public String[] getConfigurablePhrase() {
		return configurablePhrase;
	}
	public void setConfigurablePhrase(String[] configurablePhrase) {
		this.configurablePhrase = configurablePhrase;
	}
	public String[] getBenefitServiceRuleValue() {
		return benefitServiceRuleValue;
	}
	public void setBenefitServiceRuleValue(String[] benefitServiceRuleValue) {
		this.benefitServiceRuleValue = benefitServiceRuleValue;
	}

}
