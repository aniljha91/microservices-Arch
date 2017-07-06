package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.RuleService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationDecisionService;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationDecisionService_Service;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationRequest;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationResponse;
import com.ibm.rules.decisionservice.ccspdeployment.claimoperation.ClaimoperationSoapFault;

@Service("ruleService")
public class RuleServiceImpl implements RuleService{
	
	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;

	@Override
	public  com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim getClaim(Claim claim) throws  ClaimoperationSoapFault {
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "Preventive Care");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		ClaimoperationRequest claimoperationRequest = new ClaimoperationRequest(); 
		ClaimoperationDecisionService_Service ss = new ClaimoperationDecisionService_Service();
		ClaimoperationDecisionService service = ss.getCcspdeploymentClaimoperationPort();
		com.ibm.rules.decisionservice.ccspdeployment.claimoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.ccspdeployment.claimoperation.param.Claim();
		com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.ccspdeployment.claimoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		claimoperationRequest.setClaim(claimParam);
		ClaimoperationResponse response = service.claimoperation(claimoperationRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
