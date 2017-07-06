package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.ClaimCostShareData;



public interface ClaimCostShareRepository extends JpaRepository<ClaimCostShareData, Integer> {

	
}
