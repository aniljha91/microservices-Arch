package com.ccsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsp.entity.Members;


/**
 * Repository : Provider.
 */
public interface MemberRepository extends JpaRepository<Members, Long> {

	
}
