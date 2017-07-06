package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationSoapFault;

@FunctionalInterface
public interface RuleService {

	public  com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim getClaim(Claim claim) throws ClaimoperationSoapFault;

}
