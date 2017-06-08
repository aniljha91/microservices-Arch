package com.org.group.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.group.domain.Group;

@Service
public class GroupServiceImpl implements GroupService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	/*@Autowired
	private BenefitPlanServiceClient statisticsClient;

	@Autowired
	private AuthServiceClient authClient;*/

	/*@Autowired
	private GroupRepository repository;*/

	/**
	 * {@inheritDoc}
	 * @throws Exception 
	 */
	@Override
	@HystrixCommand(fallbackMethod = "fallbackFindByName")
	public Group findByName(String groupName) throws Exception {
		//Assert.hasLength(groupName);
		//return repository.findByName(groupName);
		throw new Exception("TESTING FALLBACK");
		/*Group group = new Group();
		group.setName("Success");
		return group;*/
	}
	
	public Group fallbackFindByName(String groupName, Throwable t) {
		log.info("Inside Fallback method , rootcause :" + t.getMessage());
		Group group = new Group();
		group.setName("Fallback");
		return group;
	}

	/**
	 * {@inheritDoc}
	 */
	/*@Override
	public Group create(User user) {

		Group existing = repository.findByName(user.getUsername());
		Assert.isNull(existing, "group already exists: " + user.getUsername());

		//authClient.createUser(user);

		Contract saving = new Contract();

		Group account = new Group();
		account.setName(user.getUsername());
		account.setCreationDate(new Date());


		repository.save(account);

		log.info("new group has been created: " + account.getName());

		return account;
	}

	*//**
	 * {@inheritDoc}
	 *//*
	@Override
	public void saveChanges(String name, Group update) {

		Group group = repository.findByName(name);
		Assert.notNull(group, "can't find group with name " + name);

		group.setIncomes(update.getIncomes());
		group.setExpenses(update.getExpenses());
		group.setCreationDate(new Date());
		repository.save(group);

		log.debug("group {} changes has been saved", name);
	}*/
}
