package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationSoapFault;

@FunctionalInterface
public interface OfficeVisitService {

	public com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim getClaim(Claim claim) throws OfficevisitclaimoperationSoapFault;

}
