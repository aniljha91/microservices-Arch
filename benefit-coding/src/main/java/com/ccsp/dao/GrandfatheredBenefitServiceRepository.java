package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.CorporateBenefitServiceList;
import com.ccsp.entity.GrandfatheredBenefitServiceList;



public interface GrandfatheredBenefitServiceRepository extends JpaRepository<GrandfatheredBenefitServiceList, Integer> {

	
}
