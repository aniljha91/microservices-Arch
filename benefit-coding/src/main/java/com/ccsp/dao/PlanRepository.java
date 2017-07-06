package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Plans;



public interface PlanRepository extends JpaRepository<Plans, Integer> {

	
}
