package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.AdministrativePlanCostShareOverrides;
import com.ccsp.entity.MarketingPlan;



public interface MarketingPlanRepository extends JpaRepository<MarketingPlan, byte[]> {

	
}
