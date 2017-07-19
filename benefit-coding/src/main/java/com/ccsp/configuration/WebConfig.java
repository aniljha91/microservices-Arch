package com.ccsp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.header}")
	private String headerName;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ControllerRoleInterceptor(secret,headerName));
	}
}
