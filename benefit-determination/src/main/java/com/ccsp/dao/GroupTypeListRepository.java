package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.GroupTypeList;



public interface GroupTypeListRepository extends JpaRepository<GroupTypeList, Integer> {

	
}
