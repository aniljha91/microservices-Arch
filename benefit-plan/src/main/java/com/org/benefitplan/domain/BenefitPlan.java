package com.org.benefitplan.domain;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "benefitplans")
@JsonIgnoreProperties
public class BenefitPlan {

	@Id
	private int benefitPlanId;

	public int getBenefitPlanId() {
		return benefitPlanId;
	}

	public void setBenefitPlanId(int benefitPlanId) {
		this.benefitPlanId = benefitPlanId;
	}

	public String getBenefitPlanName() {
		return benefitPlanName;
	}

	public void setBenefitPlanName(String benefitPlanName) {
		this.benefitPlanName = benefitPlanName;
	}

	@NotNull
	private String benefitPlanName;

}
