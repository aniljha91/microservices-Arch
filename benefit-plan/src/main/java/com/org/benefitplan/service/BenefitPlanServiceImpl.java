package com.org.benefitplan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.benefitplan.domain.BenefitPlan;
import com.org.benefitplan.domain.Contract;

@Service
public class BenefitPlanServiceImpl implements BenefitPlanService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	/*@Autowired
	private BenefitPlanRepository repository;*/
	
	@Override
	@HystrixCommand(fallbackMethod = "fallback")
	public String findByBenefitPlanName(String name) throws Exception {
		//return repository.findByBenefitPlanId(benefitPlanId);
		throw new Exception("TESTING FALLBACK");
	}
	
	public String fallback(String name, Throwable t) {
		return "Inside Fallback method , rootcause :" + t.getMessage();
	}

	@Override
	public void save(String groupName, Contract contract) {

	}

	@Override
	public List<BenefitPlan> findByGroupName(String groupName) {
		return null;
	}


}
