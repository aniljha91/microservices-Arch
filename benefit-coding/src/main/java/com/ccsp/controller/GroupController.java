package com.ccsp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RefreshScope
@Configuration
public class GroupController {

	
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOG = Logger.getLogger(GroupController.class.getName());
	
	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public String getCurrentUser() throws Exception {
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public String getName(@PathVariable String name) throws Exception {
		LOG.log(Level.INFO, "calling getName");
		return name;
	}
	
	
	@PreAuthorize ("hasRole('ROLE_READER')")
	@RequestMapping(path="/loadBalancerDemo",method = RequestMethod.GET)
	@ApiOperation(value="loadBalancerDemo", nickname="generic", response=String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 415, message = "Unsupported Media Type"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public @ResponseBody String getLoadBalancerDemo() throws UnknownHostException
	{
		LOG.log(Level.INFO, "Inside Benefit-coding loadBalancerDemo");
		String result = restTemplate.getForObject("http://BENEFIT-DETERMINATION/determine/plan", String.class);
		StringBuilder finalResponse = new StringBuilder();
		finalResponse.append("Inside Benefit coding service");
		finalResponse.append("    ::   ");
		finalResponse.append("Instance used of BENEFIT-CODING is running on host :"+ InetAddress.getLocalHost().getHostName());
		finalResponse.append("    ::   ");
		finalResponse.append("And Internally called BENEFIT-DETERMINATION Service, "+result);
		LOG.log(Level.INFO, finalResponse.toString());
		return finalResponse.toString();
	}
	
}
