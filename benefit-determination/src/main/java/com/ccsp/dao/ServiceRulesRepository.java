package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Members;
import com.ccsp.entity.ServiceRules;


/**
 * Repository : Provider.
 */
public interface ServiceRulesRepository extends JpaRepository<ServiceRules, Long> {

	ServiceRules findByPlanId(String planId);

	
}
