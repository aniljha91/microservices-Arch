package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.NetworkNameList;



public interface NetworkNameListRepository extends JpaRepository<NetworkNameList, Integer> {

	
}
