package com.ccsp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.PlanServiceEntity;

public interface PlanServiceRepository extends JpaRepository<PlanServiceEntity, Integer> {
	
	
	List<PlanServiceEntity> findByPlanId(String Id);

	PlanServiceEntity findByPlanIdAndServiceName(String planId, String benefitServiceName);
	
}
