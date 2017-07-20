package com.ccsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plan_rule_service")
public class PlanServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "age")
	private int age;
	@Column(name = "amount_type")
	private String amountType;
	@Column(name = "coinsurance_allowed")
	private String coInsuranceAllowed;
	@Column(name = "service_allowed")
	private String serviceAllowed;
	@Column(name = "cost_share_allowed")
	private String costShareAllowed;
	@Column(name = "copay_allowed")
	private String coPayAllowed;
	@Column(name = "deductable_allowed")
	private String deductableAllowed;
	@Column(name = "copay_amount")
	private double coPayAmount;
	@Column(name = "coinsurance_amount")
	private double coInsuranceAmount;
	@Column(name = "max_allowed_amount")
	private double maximumAllowedAmount;
	@Column(name = "max_deductable_amount")
	private double maximumDeductableAmount;
	@Column(name = "network_type")
	private String networkType;
	@Column(name = "plan_id")
	private String planId;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "service_name")
	private String serviceName;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public String getCoInsuranceAllowed() {
		return coInsuranceAllowed;
	}

	public void setCoInsuranceAllowed(String coInsuranceAllowed) {
		this.coInsuranceAllowed = coInsuranceAllowed;
	}

	public String getServiceAllowed() {
		return serviceAllowed;
	}

	public void setServiceAllowed(String serviceAllowed) {
		this.serviceAllowed = serviceAllowed;
	}

	public String getCostShareAllowed() {
		return costShareAllowed;
	}

	public void setCostShareAllowed(String costShareAllowed) {
		this.costShareAllowed = costShareAllowed;
	}

	public String getCoPayAllowed() {
		return coPayAllowed;
	}

	public void setCoPayAllowed(String coPayAllowed) {
		this.coPayAllowed = coPayAllowed;
	}

	public String getDeductableAllowed() {
		return deductableAllowed;
	}

	public void setDeductableAllowed(String deductableAllowed) {
		this.deductableAllowed = deductableAllowed;
	}

	public double getCoPayAmount() {
		return coPayAmount;
	}

	public void setCoPayAmount(double coPayAmount) {
		this.coPayAmount = coPayAmount;
	}

	public double getCoInsuranceAmount() {
		return coInsuranceAmount;
	}

	public void setCoInsuranceAmount(double coInsuranceAmount) {
		this.coInsuranceAmount = coInsuranceAmount;
	}

	public double getMaximumAllowedAmount() {
		return maximumAllowedAmount;
	}

	public void setMaximumAllowedAmount(double maximumAllowedAmount) {
		this.maximumAllowedAmount = maximumAllowedAmount;
	}

	public double getMaximumDeductableAmount() {
		return maximumDeductableAmount;
	}

	public void setMaximumDeductableAmount(double maximumDeductableAmount) {
		this.maximumDeductableAmount = maximumDeductableAmount;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
