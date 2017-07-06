package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.OfficeVisitService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationDecisionService;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationDecisionService_Service;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationRequest;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationResponse;
import com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.OfficevisitclaimoperationSoapFault;

@Service("officeVisitService")
public class OfficeVisitServiceImpl implements OfficeVisitService {

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public  com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim getClaim(Claim claim) throws OfficevisitclaimoperationSoapFault{
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "Office Visit");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		claim.setMaximumAllowedAmount(claim.getMaximumAllowedAmount()/100);
		OfficevisitclaimoperationRequest offerVisitRequest = new OfficevisitclaimoperationRequest();
		OfficevisitclaimoperationDecisionService_Service ss = new OfficevisitclaimoperationDecisionService_Service();
		OfficevisitclaimoperationDecisionService service = ss.getOfficevisitclaimdeployOfficevisitclaimoperationPort();
		com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.param.Claim();
		com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.officevisitclaimdeploy.officevisitclaimoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		offerVisitRequest.setClaim(claimParam);
		OfficevisitclaimoperationResponse  response = service.officevisitclaimoperation(offerVisitRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}
}
