package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.CorporateBenefitServiceList;



public interface CorporateBenefitServiceRepository extends JpaRepository<CorporateBenefitServiceList, Integer> {

	
}
