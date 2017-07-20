package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationSoapFault;

@FunctionalInterface
public interface MRIService {

	public com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim getClaim(Claim claim) throws  MriclaimoperationSoapFault;

}
