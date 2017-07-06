package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.SpecialistVisitRuleService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationDecisionService;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationDecisionService_Service;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationRequest;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationResponse;
import com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.SpecialistvisitclaimoperationSoapFault;

@Service("specialistVisitRuleService")
public class SpecialistVisitRuleServiceImpl implements SpecialistVisitRuleService{

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim getClaim(com.ccsp.model.Claim claim) throws  SpecialistvisitclaimoperationSoapFault {
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "Special Visit");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		claim.setMaximumAllowedAmount(claim.getMaximumAllowedAmount()/100);
		SpecialistvisitclaimoperationRequest specialVisitRequest = new SpecialistvisitclaimoperationRequest();
		SpecialistvisitclaimoperationDecisionService_Service ss = new SpecialistvisitclaimoperationDecisionService_Service();
		SpecialistvisitclaimoperationDecisionService service = ss.getSpecialistvisitclaimdeploySpecialistvisitclaimoperationPort();
		com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.param.Claim();
		com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.specialistvisitclaimdeploy.specialistvisitclaimoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		specialVisitRequest.setClaim(claimParam);
		SpecialistvisitclaimoperationResponse response = service.specialistvisitclaimoperation(specialVisitRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
