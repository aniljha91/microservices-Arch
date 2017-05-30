package com.org.benefitplan.controller;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.domain.Contract;
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
	
	@RequestMapping(value = "/{groupName}", method = RequestMethod.PUT)
	public void saveAccountStatistics(@PathVariable String groupName, @Valid @RequestBody Contract contract) {
		benefitplanService.save(groupName, contract);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "testFallbackId")
	public String testHystrixById(@PathVariable int id) throws Exception {
		LOG.log(Level.INFO, "calling testHystrixById");
		throw new Exception("Exception thrown inside testHystrixById");
	}

	public String testFallbackId(int id, Throwable t) {
		return "Inside Fallback method of controller, rootcause :" + t.getMessage();
	}
}
