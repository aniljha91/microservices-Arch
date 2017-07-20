package com.ccsp.dto;

public class ClaimRequest {
	
	private Integer memberId;
	private double billedAmount;
	private String diagnosticCodeDesc;
	private Integer diagnosticCode;
	private String planName;
	private String procedureCodeDesc;
	private Integer procedureCode;
	
	/**
	 * @return the memberId
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the billedAmount
	 */
	public double getBilledAmount() {
		return billedAmount;
	}
	/**
	 * @param billedAmount the billedAmount to set
	 */
	public void setBilledAmount(double billedAmount) {
		this.billedAmount = billedAmount;
	}
	/**
	 * @return the diagnosticCodeDesc
	 */
	public String getDiagnosticCodeDesc() {
		return diagnosticCodeDesc;
	}
	/**
	 * @param diagnosticCodeDesc the diagnosticCodeDesc to set
	 */
	public void setDiagnosticCodeDesc(String diagnosticCodeDesc) {
		this.diagnosticCodeDesc = diagnosticCodeDesc;
	}
	/**
	 * @return the diagnosticCode
	 */
	public Integer getDiagnosticCode() {
		return diagnosticCode;
	}
	/**
	 * @param diagnosticCode the diagnosticCode to set
	 */
	public void setDiagnosticCode(Integer diagnosticCode) {
		this.diagnosticCode = diagnosticCode;
	}
	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}
	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	/**
	 * @return the procedureCodeDesc
	 */
	public String getProcedureCodeDesc() {
		return procedureCodeDesc;
	}
	/**
	 * @param procedureCodeDesc the procedureCodeDesc to set
	 */
	public void setProcedureCodeDesc(String procedureCodeDesc) {
		this.procedureCodeDesc = procedureCodeDesc;
	}
	/**
	 * @return the procedureCode
	 */
	public Integer getProcedureCode() {
		return procedureCode;
	}
	/**
	 * @param procedureCode the procedureCode to set
	 */
	public void setProcedureCode(Integer procedureCode) {
		this.procedureCode = procedureCode;
	}
	

}
