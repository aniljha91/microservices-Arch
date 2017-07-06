package com.ccsp.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsp.dao.PlanDAO;
import com.ccsp.dao.PlanServiceRepository;
import com.ccsp.dao.ServiceRulesRepository;
import com.ccsp.dto.EditPlanService;
import com.ccsp.entity.ServiceRules;
import com.ccsp.model.PlanServiceEntity;
import com.ccsp.service.PlanService;

@Service("planService")
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanServiceRepository planServiceRepository;

	@Autowired
	private ServiceRulesRepository serviceRuleRepository;

	@Autowired
	PlanDAO planDAO;

	@Override
	public List<PlanServiceEntity> getPlanServices(String planId,String networkType) {
		return planServiceRepository.findByPlanId(planId);
	}

	@Override
	public String getServiceRules(String planId) {
		return serviceRuleRepository.findByPlanId(planId).getValue();
	}

	@Override
	public void updateRules(String value, String planId) {
		ServiceRules serviceRule=serviceRuleRepository.findByPlanId(planId);
		serviceRule.setValue(value);
		serviceRuleRepository.save(serviceRule);
	}

	@Override
	public void updateRulesForPlan(List<EditPlanService> planServiceList) {

		for(EditPlanService planService : planServiceList){

			PlanServiceEntity planServiceDetails=null;
			if(planService.getIsModified().equals("Y")){
				planServiceDetails=planServiceRepository.findByPlanIdAndServiceName(planService.getPlanId(),planService.getBenefitServiceName());
				List<String> configurablePhraseList = Arrays.asList(planService.getConfigurablePhrase());
				List<String> values=Arrays.asList(planService.getBenefitServiceRuleValue());

				int i=0;
				for(String configurablePhrase : configurablePhraseList) {
					String keyName=configurablePhrase;
					String value=values.get(i);
					if(keyName.equals("Allowed Amount")){
						planServiceDetails.setMaximumAllowedAmount(Double.valueOf(value));
					}

					if(keyName.equals("Subject to Copay")){
						planServiceDetails.setCoPayAllowed(value);
					}

					if(keyName.equals("Copay  Amount")){
						planServiceDetails.setCoPayAmount(Double.valueOf(value));
					}

					if(keyName.equals("Subject to CoInsurance")){
						planServiceDetails.setCoInsuranceAllowed(value);
					}

					if(keyName.equals("CoInsurance  Amount")){
						planServiceDetails.setCoInsuranceAmount(Double.valueOf(value));
					}

					if(keyName.equals("Subject to Deductible")){
						planServiceDetails.setDeductableAllowed(value);
					}
					
					if(keyName.equals("IN Ignore Cost Share")){
						planServiceDetails.setCostShareAllowed(value);
					}

					i++;

				}
				planServiceRepository.save(planServiceDetails);


			}


		}

	}
}	
