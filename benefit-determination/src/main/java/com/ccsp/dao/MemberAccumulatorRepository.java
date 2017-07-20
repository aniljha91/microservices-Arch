package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.AdministrativePlanCostShareOverrides;
import com.ccsp.entity.MemberAccumulatorData;



public interface MemberAccumulatorRepository extends JpaRepository<MemberAccumulatorData, byte[]> {

	
}
