package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.GrandfatheredList;



public interface GrandfatheredListRepository extends JpaRepository<GrandfatheredList, Integer> {

	
}
