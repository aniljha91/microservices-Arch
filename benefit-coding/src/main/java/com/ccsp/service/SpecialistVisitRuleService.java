package com.ccsp.service;

import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationSoapFault;

@FunctionalInterface
public interface SpecialistVisitRuleService {

	public Claim getClaim(com.ccsp.model.Claim claim) throws SpecialistvisitclaimoperationSoapFault;

}
