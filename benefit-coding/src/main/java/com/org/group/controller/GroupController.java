package com.org.group.controller;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.org.group.domain.Group;
import com.org.group.service.GroupService;

@Component
@RestController
@RefreshScope
@Configuration
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private int port;

	private static final Logger LOG = Logger.getLogger(GroupController.class.getName());
	
	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Group getCurrentGroup(Principal principal) throws Exception {
		return groupService.findByName(principal.getName());
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public String getTestResults(@PathVariable String name) throws Exception {
		LOG.log(Level.INFO, "calling getTestResult");
		Group group = groupService.findByName(name);
		return group.getName();
	}

	/*@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentGroup(Principal principal, @Valid @RequestBody Group account) {
		groupService.saveChanges(principal.getName(), account);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Group createNewGroup(@Valid @RequestBody User user) {
		return groupService.create(user);
	}*/
	
	
	@RequestMapping(path="/value",method = RequestMethod.GET)
	public @ResponseBody String getPortNumber()
	{
		HttpEntity<String> restRequest = new HttpEntity<String>(setAuthenticationInHeader());
		ResponseEntity<String> result = restTemplate.exchange("http://BENEFIT-PLAN/statistics/plan", HttpMethod.GET, restRequest, String.class);
		return  (String) " From BENEFIT-PLAN: " + port + result.getBody();
	}
	
	private HttpHeaders setAuthenticationInHeader(){
		String plainCreds = "user:statistics";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}
	
	
	
}
