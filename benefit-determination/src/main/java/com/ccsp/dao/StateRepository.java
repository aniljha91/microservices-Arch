package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Diagnostics;
import com.ccsp.entity.StateList;



public interface StateRepository extends JpaRepository<StateList, Integer> {

	
}
