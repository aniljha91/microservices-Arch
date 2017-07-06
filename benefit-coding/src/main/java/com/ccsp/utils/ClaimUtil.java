package com.ccsp.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccsp.model.Claim;
import com.ccsp.service.ERService;
import com.ccsp.service.MRIService;
import com.ccsp.service.MajorService;
import com.ccsp.service.MinorService;
import com.ccsp.service.OfficeVisitService;
import com.ccsp.service.RuleService;
import com.ccsp.service.SpecialistVisitRuleService;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationSoapFault;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationSoapFault;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationSoapFault;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationSoapFault;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationSoapFault;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationSoapFault;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationSoapFault;

public class ClaimUtil {
	
	@Autowired
	public RuleService ruleService;
	@Autowired
	public SpecialistVisitRuleService specialistVisitRuleService;
	@Autowired
	public MRIService mriService;
	@Autowired
	public OfficeVisitService officeVisitService;
	@Autowired
	public ERService erService;
	@Autowired
	public MajorService majorService;
	@Autowired
	public MinorService minorService;

	/**
	 * @param accumulatorINDeductAmount
	 * @param accumulatorINOpexAmount
	 * @param claim
	 */
	public void setAccumulators(double accumulatorINDeductAmount, double accumulatorINOpexAmount, Object claim) {
		if(claim instanceof com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim){
			com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim  preventiveClaim = (com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim)claim;
			preventiveClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			preventiveClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim){
			com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim  specialistVisitClaim = (com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim)claim;
			specialistVisitClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			specialistVisitClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim){
			com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim  mriClaim = (com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim)claim;
			mriClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			mriClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim){
			com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim  officeVisitClaim = (com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim)claim;
			officeVisitClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			officeVisitClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim){
			com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim  erClaim = (com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim)claim;
			erClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			erClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim){
			com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim  minorClaim = (com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim)claim;
			minorClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			minorClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}else if(claim instanceof com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim){
			com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim  majorClaim = (com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim)claim;
			majorClaim.setAccumulatorINDeductAmount(accumulatorINDeductAmount);
			majorClaim.setAccumulatorINOpexAmount(accumulatorINOpexAmount);
		}
	}
	
}