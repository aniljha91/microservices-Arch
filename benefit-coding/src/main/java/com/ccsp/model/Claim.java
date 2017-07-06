package com.ccsp.model;

public class Claim {
	
	private int memberId;
	private String planName;
	private String planId;
	private int diagnosticCode;
	private String diagnosticCodeDesc;
	private String procedureCodeDesc;
	private int procedureCode;
	private int serviceCode;
	private String serviceName;
	private int age;
	
	private double billedAmount;
	private String isIgnoreCostShare;
	private String isCoInsuranceAllowed;
	private String isCoPayAllowed;
	private String isDeductableAllowed;
	private String isNetwork;
	private String isServiceAllowed;
	
	private double paidByCompanyInsuranceAmount;
	private double patientCoPayAmount;
	private double patientCoInsuranceAmount;
	private double patientDeductableAmount;
	
	private double totalDeductableAmount;
	private double maxDeductableAmountAllowed;
	private double deductableAmountLeft;
	
	private double accumulatorINDeductAmount;
	private double accumulatorONDeductAmount;
	private double accumulatorINOpexAmount;
	private double accumulatorONOpexAmount;
	
	private double maximumAllowedAmount;
	private double coInsuranceAmount;
	private double coPayAmount;
	
	public Claim(){
		
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getDiagnosticCode() {
		return diagnosticCode;
	}

	public void setDiagnosticCode(int diagnosticCode) {
		this.diagnosticCode = diagnosticCode;
	}

	public int getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(int procedureCode) {
		this.procedureCode = procedureCode;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}

	public double getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(double billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getIsIgnoreCostShare() {
		return isIgnoreCostShare;
	}

	public void setIsIgnoreCostShare(String isIgnoreCostShare) {
		this.isIgnoreCostShare = isIgnoreCostShare;
	}

	public String getIsCoInsuranceAllowed() {
		return isCoInsuranceAllowed;
	}

	public void setIsCoInsuranceAllowed(String isCoInsuranceAllowed) {
		this.isCoInsuranceAllowed = isCoInsuranceAllowed;
	}

	public String getIsCoPayAllowed() {
		return isCoPayAllowed;
	}

	public void setIsCoPayAllowed(String isCoPayAllowed) {
		this.isCoPayAllowed = isCoPayAllowed;
	}

	public String getIsDeductableAllowed() {
		return isDeductableAllowed;
	}

	public void setIsDeductableAllowed(String isDeductableAllowed) {
		this.isDeductableAllowed = isDeductableAllowed;
	}

	public String getIsNetwork() {
		return isNetwork;
	}

	public void setIsNetwork(String isNetwork) {
		this.isNetwork = isNetwork;
	}

	public double getPaidByCompanyInsuranceAmount() {
		return paidByCompanyInsuranceAmount;
	}

	public void setPaidByCompanyInsuranceAmount(double paidByCompanyInsuranceAmount) {
		this.paidByCompanyInsuranceAmount = paidByCompanyInsuranceAmount;
	}

	public double getPatientCoPayAmount() {
		return patientCoPayAmount;
	}

	public void setPatientCoPayAmount(double patientCoPayAmount) {
		this.patientCoPayAmount = patientCoPayAmount;
	}

	public double getPatientCoInsuranceAmount() {
		return patientCoInsuranceAmount;
	}

	public void setPatientCoInsuranceAmount(double patientCoInsuranceAmount) {
		this.patientCoInsuranceAmount = patientCoInsuranceAmount;
	}

	public double getPatientDeductableAmount() {
		return patientDeductableAmount;
	}

	public void setPatientDeductableAmount(double patientDeductableAmount) {
		this.patientDeductableAmount = patientDeductableAmount;
	}

	public double getAccumulatorINDeductAmount() {
		return accumulatorINDeductAmount;
	}

	public void setAccumulatorINDeductAmount(double accumulatorINDeductAmount) {
		this.accumulatorINDeductAmount = accumulatorINDeductAmount;
	}

	public double getAccumulatorONDeductAmount() {
		return accumulatorONDeductAmount;
	}

	public void setAccumulatorONDeductAmount(double accumulatorONDeductAmount) {
		this.accumulatorONDeductAmount = accumulatorONDeductAmount;
	}

	public double getAccumulatorINOpexAmount() {
		return accumulatorINOpexAmount;
	}

	public void setAccumulatorINOpexAmount(double accumulatorINOpexAmount) {
		this.accumulatorINOpexAmount = accumulatorINOpexAmount;
	}

	public double getAccumulatorONOpexAmount() {
		return accumulatorONOpexAmount;
	}

	public void setAccumulatorONOpexAmount(double accumulatorONOpexAmount) {
		this.accumulatorONOpexAmount = accumulatorONOpexAmount;
	}

	public String getIsServiceAllowed() {
		return isServiceAllowed;
	}

	public void setIsServiceAllowed(String isServiceAllowed) {
		this.isServiceAllowed = isServiceAllowed;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTotalDeductableAmount() {
		return totalDeductableAmount;
	}

	public void setTotalDeductableAmount(double totalDeductableAmount) {
		this.totalDeductableAmount = totalDeductableAmount;
	}

	public double getMaxDeductableAmountAllowed() {
		return maxDeductableAmountAllowed;
	}

	public void setMaxDeductableAmountAllowed(double maxDeductableAmountAllowed) {
		this.maxDeductableAmountAllowed = maxDeductableAmountAllowed;
	}

	public double getDeductableAmountLeft() {
		return deductableAmountLeft;
	}

	public void setDeductableAmountLeft(double deductableAmountLeft) {
		this.deductableAmountLeft = deductableAmountLeft;
	}

	public double getMaximumAllowedAmount() {
		return maximumAllowedAmount;
	}

	public void setMaximumAllowedAmount(double maximumAllowedAmount) {
		this.maximumAllowedAmount = maximumAllowedAmount;
	}

	public double getCoInsuranceAmount() {
		return coInsuranceAmount;
	}

	public void setCoInsuranceAmount(double coInsuranceAmount) {
		this.coInsuranceAmount = coInsuranceAmount;
	}

	public double getCoPayAmount() {
		return coPayAmount;
	}

	public void setCoPayAmount(double coPayAmount) {
		this.coPayAmount = coPayAmount;
	}
	
	public String getDiagnosticCodeDesc() {
		return diagnosticCodeDesc;
	}

	public void setDiagnosticCodeDesc(String diagnosticCodeDesc) {
		this.diagnosticCodeDesc = diagnosticCodeDesc;
	}

	public String getProcedureCodeDesc() {
		return procedureCodeDesc;
	}

	public void setProcedureCodeDesc(String procedureCodeDesc) {
		this.procedureCodeDesc = procedureCodeDesc;
	}
	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
}
