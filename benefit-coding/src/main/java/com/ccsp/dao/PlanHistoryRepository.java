package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.PlanObjectHistory;
import com.ccsp.entity.Plans;



public interface PlanHistoryRepository extends JpaRepository<PlanObjectHistory, Integer> {

	
}
