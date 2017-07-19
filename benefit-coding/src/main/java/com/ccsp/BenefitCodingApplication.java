package com.ccsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@RefreshScope
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class})
public class BenefitCodingApplication{

	public static void main(String[] args) {
		SpringApplication.run(BenefitCodingApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
