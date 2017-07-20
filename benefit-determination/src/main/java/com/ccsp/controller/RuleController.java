package com.ccsp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.dto.EditPlanService;
import com.ccsp.model.Claim;
import com.ccsp.service.ERService;
import com.ccsp.service.MRIService;
import com.ccsp.service.MajorService;
import com.ccsp.service.MinorService;
import com.ccsp.service.OfficeVisitService;
import com.ccsp.service.PlanService;
import com.ccsp.service.RuleService;
import com.ccsp.service.SpecialistVisitRuleService;
import com.ccsp.utils.CCSPConstant;
import com.ccsp.utils.ClaimUtil;
import com.ccsp.utils.JsonEncryptor;
import com.ccsp.utils.Response;
import com.ccsp.utils.SerialUtils;
import com.google.gson.Gson;

@RestController
@RequestMapping("/rule")
public class RuleController {
	final Logger logger = Logger.getLogger(RuleController.class);
	
	@Autowired
	RuleService ruleService;
	
	@Autowired
	PlanService planService;
	
	@Autowired
	SpecialistVisitRuleService specialistVisitRuleService;
	
	@Autowired
	MRIService mriService;
	
	@Autowired
	OfficeVisitService officeVisitService;
	
	@Autowired
	ERService erService;
	
	@Autowired
	MajorService majorService;
	
	@Autowired
	MinorService minorService;
	
	@RequestMapping(value = "/processClaim", method = RequestMethod.POST)
	@ResponseBody
	public String processClaim(@RequestBody List<Claim> claims) {
		Object claimResponse = null;
		ClaimUtil claimUtil = new ClaimUtil();
		List<Object> listClaimResponse = new ArrayList<>();
		try {
			for(Claim claim:claims){
				claim.setTotalDeductableAmount(CCSPConstant.TOTALDEDUCTABLEAMOUNT.getAmount());
				if(929 == claim.getDiagnosticCode() && 88155 == claim.getProcedureCode()){ //i.e. Preventive Rule
					claimResponse = ruleService.getClaim(claim); 
				}
				if(463 == claim.getDiagnosticCode() && 99213 == claim.getProcedureCode()){
					claimResponse = specialistVisitRuleService.getClaim(claim);
				}
				if(464 == claim.getDiagnosticCode() && 99213 == claim.getProcedureCode()){
					claimResponse = mriService.getClaim(claim);
				}
				if(462 == claim.getDiagnosticCode() && 99213 == claim.getProcedureCode()){
					claimResponse = officeVisitService.getClaim(claim);
				}
				if(464 == claim.getDiagnosticCode() && 99811  == claim.getProcedureCode()){
					claimResponse = erService.getClaim(claim);
				}
				if(111 == claim.getDiagnosticCode() && 11111 == claim.getProcedureCode()){
					claimResponse = minorService.getClaim(claim);
				}
				if(112 == claim.getDiagnosticCode() && 11111 == claim.getProcedureCode()){
					claimResponse = majorService.getClaim(claim);
				}
				listClaimResponse.add(claimResponse);
			}
			CCSPConstant.TOTALDEDUCTABLEAMOUNT.setAmount(1200);
			accumulator(listClaimResponse,claimUtil);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return Response.getResponse(listClaimResponse);

	}

	
	private void accumulator(List<Object> listClaims, ClaimUtil claimUtil){
		double accumulatorINDeductAmount = 0;
		double accumulatorINOpexAmount = 0;
		if(CollectionUtils.isNotEmpty(listClaims)){
			for(Object claim : listClaims){
				Claim originalClaim = new Claim();
				String claimstring = SerialUtils.serializeObject(claim);
				originalClaim = (Claim)SerialUtils.unserializeObject(claimstring, originalClaim);
				accumulatorINDeductAmount = accumulatorINDeductAmount + originalClaim.getPatientDeductableAmount();
				accumulatorINOpexAmount = accumulatorINOpexAmount + originalClaim.getPatientCoPayAmount() + originalClaim.getPatientDeductableAmount() + originalClaim.getPatientCoInsuranceAmount();
				claimUtil.setAccumulators(accumulatorINDeductAmount,accumulatorINOpexAmount, claim);
			}
		}
	}
	
	@RequestMapping(value = "/getPlanServices/{planId}/{networkType}", method = RequestMethod.GET)
	@ResponseBody
	public String getMemberDetails(@PathVariable("planId") String planId,@PathVariable("networkType") String networkType) {
		return Response.getResponse(planService.getPlanServices(planId,networkType));
	}

	@RequestMapping(value = "/getServiceRules/{planId}", method = RequestMethod.GET)
	@ResponseBody
	public String getServiceRules(@PathVariable("planId") String planId) {
		JsonEncryptor encryptor;
		String decrypted = null;
		try {
			encryptor = new JsonEncryptor();
			decrypted = encryptor.decrypt(planService.getServiceRules(planId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decrypted;
	}

	@RequestMapping(value = "/updateRules", method = RequestMethod.POST)
	@ResponseBody
	public void updateRules(@RequestBody String value) {
		JsonEncryptor encryptor;
		String encrypted = null;
		List<EditPlanService> planServiceList=null;
		String planId=null;
		try {
			Gson gson= new Gson();
			EditPlanService[] planDetails = gson.fromJson(value, EditPlanService[].class);
			planServiceList=Arrays.asList(planDetails);
			planId=planServiceList.get(0).getPlanId();
			encryptor = new JsonEncryptor();
			encrypted = encryptor.encrypt(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		planService.updateRulesForPlan(planServiceList);

		planService.updateRules(encrypted,planId);
	}

}
