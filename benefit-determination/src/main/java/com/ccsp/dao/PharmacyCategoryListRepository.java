package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.PharmacyCategoryList;



public interface PharmacyCategoryListRepository extends JpaRepository<PharmacyCategoryList, Integer> {

	
}
