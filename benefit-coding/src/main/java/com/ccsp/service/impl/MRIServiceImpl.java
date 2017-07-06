package com.ccsp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.RuleDAO;
import com.ccsp.model.Claim;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.MRIService;
import com.ccsp.utils.RuleServiceUtil;
import com.ccsp.utils.SerialUtils;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationDecisionService;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationDecisionService_Service;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationRequest;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationResponse;
import com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.MriclaimoperationSoapFault;

@Service("mriService")
public class MRIServiceImpl implements MRIService {

	@Autowired
    RuleDAO ruleDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	public  com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim getClaim(Claim claim) throws MriclaimoperationSoapFault{
		RuleServiceUtil ruleServiceUtil = new RuleServiceUtil();
		PlanServiceEntity ruleEntity = ruleDAO.getServiceRule(claim.getPlanId(), "MRI");
		double amount = ruleDAO.getTotalDeductableAmount(claim.getMemberId(), claim.getPlanId());
		ruleServiceUtil.prepareClaim(claim, ruleEntity,amount);
		MriclaimoperationRequest mriClaimRequest = new MriclaimoperationRequest();
		MriclaimoperationDecisionService_Service ss = new MriclaimoperationDecisionService_Service();
		com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim serviceClaim = new com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim();
		com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.param.Claim claimParam = new com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.param.Claim();
		MriclaimoperationDecisionService service = ss.getMriclaimdeployMriclaimoperationPort();
		String claimstring = SerialUtils.serializeObject(claim);
		serviceClaim = (com.ibm.rules.decisionservice.mriclaimdeploy.mriclaimoperation.Claim)SerialUtils.unserializeObject(claimstring, serviceClaim);
		claimParam.setClaim(serviceClaim);
		mriClaimRequest.setClaim(claimParam);
		MriclaimoperationResponse response = service.mriclaimoperation(mriClaimRequest);
		planDAO.updateTotalDeductableAmount(response.getClaim().getClaim().getTotalDeductableAmount(),claim.getPlanId(),claim.getMemberId());
		return response.getClaim().getClaim();
	}

}
