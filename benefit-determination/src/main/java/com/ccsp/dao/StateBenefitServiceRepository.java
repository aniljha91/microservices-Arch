package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Diagnostics;
import com.ccsp.entity.StateBenefitServiceList;



public interface StateBenefitServiceRepository extends JpaRepository<StateBenefitServiceList, Integer> {

	
}
