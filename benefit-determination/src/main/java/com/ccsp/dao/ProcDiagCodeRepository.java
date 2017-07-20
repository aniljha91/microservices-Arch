package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.ProcCodeDiagCodeList;



public interface ProcDiagCodeRepository extends JpaRepository<ProcCodeDiagCodeList, Integer> {

	
}
