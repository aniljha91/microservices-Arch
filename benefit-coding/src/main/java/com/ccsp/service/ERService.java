package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationSoapFault;

@FunctionalInterface
public interface ERService {

	public com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim getClaim(Claim claim) throws ErclaimoperationSoapFault;

}
