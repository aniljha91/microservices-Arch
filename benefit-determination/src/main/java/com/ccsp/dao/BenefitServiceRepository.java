package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;



public interface BenefitServiceRepository extends JpaRepository<BenefitServiceList, Integer> {

	
}
