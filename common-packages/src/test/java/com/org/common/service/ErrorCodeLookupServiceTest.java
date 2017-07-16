package com.org.common.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:/common.properties")
@ContextConfiguration(classes={ErrorCodeLookupServiceTest.MyConfig.class})
public class ErrorCodeLookupServiceTest {
	
	@Autowired
	ErrorCodeLookupService service;
	
	@Configuration
	public static class MyConfig {
		@Bean
		public ErrorCodeLookupService applicationTypeService() {
			return new ErrorCodeLookupServiceImpl();
		}
	}
	@Before
	public void before() {
	  initMocks(this);
	}
	
	@Test
	public void testApplicationTypeListSupported() {
		//assertTrue(service.getErrorCode("cloud").equals(other));
	}
	
	@Test
	public void testApplicationTypeListNotSupported() {
		//assertFalse(service.getErrorCode("notSupported"));
	}
	
}
