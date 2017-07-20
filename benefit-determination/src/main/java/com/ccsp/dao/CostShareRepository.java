package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.CostShareList;



public interface CostShareRepository extends JpaRepository<CostShareList, Integer> {

	
}
