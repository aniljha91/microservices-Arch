package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationSoapFault;

@FunctionalInterface
public interface MinorService {

	public com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim getClaim(Claim claim) throws MinorsurgeryoperationSoapFault;

}
