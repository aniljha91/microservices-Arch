package com.ccsp.group.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ccsp.group.domain.Group;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GroupServiceImpl implements GroupService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	@HystrixCommand(fallbackMethod = "fallbackFindByName")
	public Group findByName(String groupName) throws Exception {
		throw new Exception("TESTING FALLBACK");
	}
	
	public Group fallbackFindByName(String groupName, Throwable t) {
		log.info("Inside Fallback method , rootcause :" + t.getMessage());
		Group group = new Group();
		group.setName("Fallback");
		return group;
	}
}
