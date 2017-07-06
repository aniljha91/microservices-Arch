package com.ccsp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsp.common.Response;
import com.ccsp.dto.ClaimRequest;
import com.ccsp.model.Claim;
import com.ccsp.service.CCSPService;
import com.ccsp.utils.UIConstants;




@RestController
public class CCSPController {

	
  private static Logger log = Logger.getLogger(CCSPController.class);

  @Autowired
  private CCSPService ccspService;
	
    @RequestMapping(value = UIConstants.MEMBER_LIST, method = RequestMethod.GET)
    @ResponseBody
    public Response getMembersList() {
      log.info("enters into getMembersList");
      Response response = new Response();
      response.setResult(ccspService.getMemberList());
      return response;
    	
    }
    
    @RequestMapping(value = UIConstants.PLAN_LIST, method = RequestMethod.GET)
    @ResponseBody
    public Response getPlanList() {
      
      log.info("enters into getPlanList");
      Response response = new Response();
      response.setResult(ccspService.getPlanList());
      return response;
        
    }
    
    @RequestMapping(value = UIConstants.DIAGNOSTIC_CODES, method = RequestMethod.GET)
    @ResponseBody
    public Response getDaignosticCodes() {
      
      log.info("enters into getDaignosticCodes");
       Response response = new Response();
      response.setResult(ccspService.getDaignosticList());
      return response;
        
    }
    
    @RequestMapping(value = UIConstants.GET_CLAIM_RULES, method = RequestMethod.POST)
    @ResponseBody
    public Response getClaimDetails(@RequestBody ClaimRequest claimRequest) {
      
      log.info("enters into getClaimDetails");
       Response response = new Response();
      response.setResult(ccspService.getClaimRules(claimRequest));
      return response;
        
    }
    
    

  
}
