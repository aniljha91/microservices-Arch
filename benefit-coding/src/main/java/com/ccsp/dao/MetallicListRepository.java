package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.MetallicList;



public interface MetallicListRepository extends JpaRepository<MetallicList, Integer> {

	
}
