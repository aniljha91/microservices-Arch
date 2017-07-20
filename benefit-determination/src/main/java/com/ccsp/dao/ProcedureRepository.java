package com.ccsp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Procedures;



public interface ProcedureRepository extends JpaRepository<Procedures, Integer> {

  List<Procedures> findByDiagCode(int id);

	
}
