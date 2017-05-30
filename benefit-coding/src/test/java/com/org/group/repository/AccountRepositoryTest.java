/*package com.org.group.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.BenefitCodingApplication;
import com.org.group.domain.Contract;
import com.org.group.domain.Group;
import com.org.group.domain.GroupType;
import com.org.group.domain.Item;
import com.org.group.domain.TimePeriod;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BenefitCodingApplication.class)
public class AccountRepositoryTest {

	@Autowired
	private ContractRepository repository;

	@Test
	public void shouldFindAccountByName() {

		Contract stub = getStubContract();
		repository.save(stub);

		Contract found = repository.findByName(stub.getName());
		assertEquals(stub.getContractDate(), found.getContractDate());
		assertEquals(stub.getNote(), found.getNote());
		assertEquals(stub.getName(), found.getName());

//		assertEquals(stub.getIncomes().size(), found.getIncomes().size());
//		assertEquals(stub.getExpenses().size(), found.getExpenses().size());
	}

	private Contract getStubContract() {

		Contract contract = new Contract();
		contract.setNote("test note");
		contract.setName("test contact name");

		Item vacation = new Item();
		vacation.setTitle("Vacation");
		vacation.setAmount(new BigDecimal(3400));
		vacation.setCurrency(GroupType.INDIVIDUAL);
		vacation.setPeriod(TimePeriod.YEAR);
		vacation.setIcon("tourism");

		Item grocery = new Item();
		grocery.setTitle("Grocery");
		grocery.setAmount(new BigDecimal(10));
		grocery.setCurrency(GroupType.CORPORATE);
		grocery.setPeriod(TimePeriod.DAY);
		grocery.setIcon("meal");

		Item salary = new Item();
		salary.setTitle("Salary");
		salary.setAmount(new BigDecimal(9100));
		salary.setCurrency(GroupType.CORPORATE);
		salary.setPeriod(TimePeriod.MONTH);
		salary.setIcon("wallet");

		Group account = new Group();
		account.setName("test");
		account.setGroupType(GroupType.CORPORATE);
		account.setCreationDate(new Date());
		account.setExpenses(Arrays.asList(grocery, vacation));
		account.setIncomes(Arrays.asList(salary));

		return contract;
	}
}
*/