package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.ClaimData;

import javassist.bytecode.ByteArray;



public interface ClaimDataRepository extends JpaRepository<ClaimData, byte[]> {

	
}
