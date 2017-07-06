package com.ccsp.service;

import com.ccsp.model.Claim;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationSoapFault;

@FunctionalInterface
public interface MajorService {

	public com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim getClaim(Claim claim) throws MajorsurgeryoperationSoapFault;

}
