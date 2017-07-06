package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.MinorService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationDecisionService;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationDecisionService_Service;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationRequest;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationResponse;
import com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.MinorsurgeryoperationSoapFault;

@Service("minorService")
public class MinorServiceImpl implements MinorService {

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public  com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim getClaim(Claim claim) throws MinorsurgeryoperationSoapFault{
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "Minor Surgery");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		MinorsurgeryoperationRequest minorRequest = new MinorsurgeryoperationRequest();
		MinorsurgeryoperationDecisionService_Service ss = new MinorsurgeryoperationDecisionService_Service();
		MinorsurgeryoperationDecisionService service = ss.getMinorsurgeryclaimdeployMinorsurgeryoperationPort();
		com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.param.Claim();
		com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.minorsurgeryclaimdeploy.minorsurgeryoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		minorRequest.setClaim(claimParam);
		MinorsurgeryoperationResponse response = service.minorsurgeryoperation(minorRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
