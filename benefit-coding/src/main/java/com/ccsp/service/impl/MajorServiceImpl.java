package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.MajorService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationDecisionService;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationDecisionService_Service;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationRequest;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationResponse;
import com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.MajorsurgeryoperationSoapFault;

@Service("majorService")
public class MajorServiceImpl implements MajorService {

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public  com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim getClaim(Claim claim) throws MajorsurgeryoperationSoapFault{
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "Major Surgery");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		MajorsurgeryoperationRequest majorRequest = new MajorsurgeryoperationRequest();
		MajorsurgeryoperationDecisionService_Service ss = new MajorsurgeryoperationDecisionService_Service();
		MajorsurgeryoperationDecisionService service = ss.getMajorsurgeryclaimdeployMajorsurgeryoperationPort();
		com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.param.Claim();
		com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.majorsurgeryclaimdeploy.majorsurgeryoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		majorRequest.setClaim(claimParam);
		MajorsurgeryoperationResponse  response = service.majorsurgeryoperation(majorRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
