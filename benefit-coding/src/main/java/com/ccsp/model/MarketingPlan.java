package com.ccsp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketingPlan implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeId;
	private Short nodeLevel;
	private int mktPlanId;
	private Integer adminPlanId;
	private String mktPlanName;
	private String mktPlanCoverage;
	private Date mktPlanEffectiveDate;
	private Date mktPlanExpirationDate;
	private String mktPlanType;
	private String mktPlanLevelOfCoverage;
	private String mktPlanNetworkName;
	private String mktPlanFormulary;
	private String mktPlanCurrentOrProposed;
	private String mktPlanStateName;
	private String mktPlanHsaeligible;

	public MarketingPlan() {
	}
	
	@JsonProperty("Node ID")
	public String getNodeId() {
		return nodeId;
	}

	@JsonProperty("Node ID")
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	@JsonProperty("Node Level")
	public Short getNodeLevel() {
		return nodeLevel;
	}
	
	@JsonProperty("Node Level")
	public void setNodeLevel(Short nodeLevel) {
		this.nodeLevel = nodeLevel;
	}

	@JsonProperty("MktPlanID")
	public int getMktPlanId() {
		return mktPlanId;
	}

	@JsonProperty("MktPlanID")
	public void setMktPlanId(int mktPlanId) {
		this.mktPlanId = mktPlanId;
	}
	
	@JsonProperty("AdminPlanId")
	public Integer getAdminPlanId() {
		return adminPlanId;
	}
	
	@JsonProperty("AdminPlanId")
	public void setAdminPlanId(Integer adminPlanId) {
		this.adminPlanId = adminPlanId;
	}
	
	@JsonProperty("MktPlanName")
	public String getMktPlanName() {
		return mktPlanName;
	}

	@JsonProperty("MktPlanName")
	public void setMktPlanName(String mktPlanName) {
		this.mktPlanName = mktPlanName;
	}
	
	@JsonProperty("MktPlanCoverage")
	public String getMktPlanCoverage() {
		return mktPlanCoverage;
	}
	
	@JsonProperty("MktPlanCoverage")
	public void setMktPlanCoverage(String mktPlanCoverage) {
		this.mktPlanCoverage = mktPlanCoverage;
	}

	@JsonProperty("MktPlanEffectiveDate")
	public Date getMktPlanEffectiveDate() {
		return mktPlanEffectiveDate;
	}
	
	@JsonProperty("MktPlanEffectiveDate")
	public void setMktPlanEffectiveDate(Date mktPlanEffectiveDate) {
		this.mktPlanEffectiveDate = mktPlanEffectiveDate;
	}

	@JsonProperty("MktPlanExpirationDate")
	public Date getMktPlanExpirationDate() {
		return mktPlanExpirationDate;
	}

	@JsonProperty("MktPlanExpirationDate")
	public void setMktPlanExpirationDate(Date mktPlanExpirationDate) {
		this.mktPlanExpirationDate = mktPlanExpirationDate;
	}
	
	@JsonProperty("MktPlanType")
	public String getMktPlanType() {
		return mktPlanType;
	}

	@JsonProperty("MktPlanType")
	public void setMktPlanType(String mktPlanType) {
		this.mktPlanType = mktPlanType;
	}

	@JsonProperty("MktPlanLevelCoverage")
	public String getMktPlanLevelOfCoverage() {
		return mktPlanLevelOfCoverage;
	}
	@JsonProperty("MktPlanLevelCoverage")
	public void setMktPlanLevelOfCoverage(String mktPlanLevelOfCoverage) {
		this.mktPlanLevelOfCoverage = mktPlanLevelOfCoverage;
	}
	@JsonProperty("MktPlanNetworkName")
	public String getMktPlanNetworkName() {
		return mktPlanNetworkName;
	}
	@JsonProperty("MktPlanNetworkName")
	public void setMktPlanNetworkName(String mktPlanNetworkName) {
		this.mktPlanNetworkName = mktPlanNetworkName;
	}
	@JsonProperty("MktPlanFormulary")
	public String getMktPlanFormulary() {
		return mktPlanFormulary;
	}
	@JsonProperty("MktPlanFormulary")
	public void setMktPlanFormulary(String mktPlanFormulary) {
		this.mktPlanFormulary = mktPlanFormulary;
	}
	@JsonProperty("MktPlanCurrentOrProposed")
	public String getMktPlanCurrentOrProposed() {
		return mktPlanCurrentOrProposed;
	}
	@JsonProperty("MktPlanCurrentOrProposed")
	public void setMktPlanCurrentOrProposed(String mktPlanCurrentOrProposed) {
		this.mktPlanCurrentOrProposed = mktPlanCurrentOrProposed;
	}
	@JsonProperty("MktPlanStateName")
	public String getMktPlanStateName() {
		return mktPlanStateName;
	}
	@JsonProperty("MktPlanStateName")
	public void setMktPlanStateName(String mktPlanStateName) {
		this.mktPlanStateName = mktPlanStateName;
	}
	@JsonProperty("MktPlanHsaeligible")
	public String getMktPlanHsaeligible() {
		return mktPlanHsaeligible;
	}
	@JsonProperty("MktPlanHsaeligible")
	public void setMktPlanHsaeligible(String mktPlanHsaeligible) {
		this.mktPlanHsaeligible = mktPlanHsaeligible;
	}


}
