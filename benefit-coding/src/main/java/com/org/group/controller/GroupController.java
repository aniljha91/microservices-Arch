package com.org.group.controller;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.group.domain.Group;
import com.org.group.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	private GroupService groupService;

	private static final Logger LOG = Logger.getLogger(GroupController.class.getName());
	
	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Group getCurrentGroup(Principal principal) throws Exception {
		return groupService.findByName(principal.getName());
	}

	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Group getTestResults(@PathVariable String name) throws Exception {
		LOG.log(Level.INFO, "calling getTestResult");
		return groupService.findByName(name);
	}

	/*@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentGroup(Principal principal, @Valid @RequestBody Group account) {
		groupService.saveChanges(principal.getName(), account);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Group createNewGroup(@Valid @RequestBody User user) {
		return groupService.create(user);
	}*/
}
