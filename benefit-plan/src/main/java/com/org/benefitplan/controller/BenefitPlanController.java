package com.org.benefitplan.controller;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.service.BenefitPlanService;

@Component
@RestController
public class BenefitPlanController {

	@Autowired
	private BenefitPlanService benefitplanService;

	private static final Logger LOG = Logger.getLogger(BenefitPlanService.class.getName());
	
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public List<BenefitPlan> getCurrentAccountStatistics(Principal principal) {
		return benefitplanService.findByGroupName(principal.getName());
	}

	@RequestMapping(value = "/{groupName}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "testFallback")
	public String getBenefitPlansByGroupName(@PathVariable String groupName) throws Exception {
		LOG.log(Level.INFO, "calling getBenefitPlansByGroupName");
		return benefitplanService.findByBenefitPlanName(groupName);
	}

	public String testFallback(String name, Throwable t) {
		return "Inside Fallback method of controller, rootcause :" + t.getMessage();
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "testFallbackId")
	public String testHystrixById(@PathVariable int id) throws Exception {
		LOG.log(Level.INFO, "calling benefit coding");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> restRequest = new HttpEntity<String>(setAuthenticationInHeader());
		ResponseEntity<String> result = restTemplate.exchange("http://localhost:6000/groups/groupName", HttpMethod.GET, restRequest, String.class);
		if (result.getBody()!=null) {
			return result.getBody();
		}
		return null;
	}
	
	private HttpHeaders setAuthenticationInHeader(){
		String plainCreds = "user:groups";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}

	public String testFallbackId(int id, Throwable t) {
		return "Inside Fallback method of controller, rootcause :" + t.getMessage();
	}
}
