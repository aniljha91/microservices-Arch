package com.ccsp.service.contract;

import com.ccsp.group.domain.Contract;

public interface ContractService {

	Contract findByName(String ContractName) throws Exception;

	/*Contract create(User user);

	void saveChanges(String name, Contract contract);*/
}
