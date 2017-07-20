package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Diagnostics;



public interface DiagnosticRepository extends JpaRepository<Diagnostics, Integer> {

	
}
