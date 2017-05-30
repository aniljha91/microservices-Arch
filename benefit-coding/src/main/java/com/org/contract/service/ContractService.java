package com.org.contract.service;

import com.org.group.domain.Contract;
import com.org.group.domain.User;

public interface ContractService {

	Contract findByName(String ContractName) throws Exception;

	Contract create(User user);

	void saveChanges(String name, Contract contract);
}
