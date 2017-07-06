package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.ERService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationDecisionService;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationDecisionService_Service;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationRequest;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationResponse;
import com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.ErclaimoperationSoapFault;

@Service("erService")
public class ERServiceImpl implements ERService {

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public  com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim getClaim(Claim claim) throws ErclaimoperationSoapFault{
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "ER");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		ErclaimoperationRequest erclaimoperationRequest = new ErclaimoperationRequest();
		ErclaimoperationDecisionService_Service ss = new ErclaimoperationDecisionService_Service();
		ErclaimoperationDecisionService service = ss.getErclaimdeployErclaimoperationPort();
		com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.param.Claim();
		com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.erclaimdeploy.erclaimoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		erclaimoperationRequest.setClaim(claimParam);
		ErclaimoperationResponse response = service.erclaimoperation(erclaimoperationRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
