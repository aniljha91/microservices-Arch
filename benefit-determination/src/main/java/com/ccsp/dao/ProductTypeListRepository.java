package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.BenefitServiceList;
import com.ccsp.entity.MetallicList;
import com.ccsp.entity.ProductTypeList;



public interface ProductTypeListRepository extends JpaRepository<ProductTypeList, Integer> {

	
}
