/*package com.ccsp.group.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ccsp.group.domain.Contract;
import com.ccsp.group.domain.Group;
import com.ccsp.group.domain.GroupType;
import com.ccsp.group.domain.Item;
import com.ccsp.group.domain.TimePeriod;
import com.ccsp.group.domain.User;
import com.ccsp.group.repository.ContractRepository;

public class GroupServiceTest {

	@InjectMocks
	private GroupServiceImpl accountService;

	@Mock
	private BenefitPlanServiceClient statisticsClient;

	@Mock
	private AuthServiceClient authClient;

	@Mock
	private ContractRepository repository;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldFindByName() throws Exception {

		final Group account = new Group();
		account.setName("test");

		when(accountService.findByName(account.getName())).thenReturn(account);
		Group found = accountService.findByName(account.getName());

		assertEquals(account, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNameIsEmpty() throws Exception {
		accountService.findByName("");
	}

	@Test
	public void shouldCreateAccountWithGivenUser() {

		User user = new User();
		user.setUsername("test");

		Group account = accountService.create(user);

		assertEquals(user.getUsername(), account.getName());
		assertEquals(0, account.getSaving().getAmount().intValue());
		assertEquals(GroupType.getDefault(), account.getSaving().getCurrency());
		assertEquals(0, account.getSaving().getInterest().intValue());
		assertEquals(false, account.getSaving().getDeposit());
		assertEquals(false, account.getSaving().getCapitalization());
		assertNotNull(account.getLastSeen());

		verify(authClient, times(1)).createUser(user);
		verify(repository, times(1)).save(account);
	}

	@Test
	public void shouldSaveChangesWhenUpdatedAccountGiven() {

		Item benefitPlan = new Item();
		benefitPlan.setTitle("Grocery");
		benefitPlan.setAmount(new BigDecimal(10));
		benefitPlan.setCurrency(GroupType.CORPORATE);
		benefitPlan.setPeriod(TimePeriod.DAY);
		benefitPlan.setIcon("meal");



		Group update = new Group();
		update.setName("test");
		update.setGroupType(GroupType.CORPORATE);
		update.setExpenses(Arrays.asList(benefitPlan));

		
		final Contract contract = new Contract();
		contract.setGroup(update);
		contract.setNote("test note");
		contract.setNote("test contract Name");




		final Contract contract = new Contract();

		when(accountService.findByName("test")).thenReturn(contract);
		accountService.saveChanges("test", update);

		assertEquals(update.getNote(), contract.getNote());
		assertNotNull(contract.getLastSeen());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNoAccountsExistedWithGivenName() throws Exception {
		final Group group = new Group();

		when(accountService.findByName("test")).thenReturn(null);
		accountService.saveChanges("test", group);
	}
}
*/