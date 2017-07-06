package com.org.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.org.BenefitCodingApplication;
import com.org.common.AbstractSwaggerConfig;
import com.org.common.ProfileConstants;

import springfox.documentation.swagger2.annotations.EnableSwagger2; 


@Configuration
@EnableSwagger2
@Profile("!"+ProfileConstants.SPRING_PROFILE_PRODUCTION) 
public class SwaggerConfig  extends AbstractSwaggerConfig{  
	
	@Override
	public String getBasePackageName() {
		return BenefitCodingApplication.class.getPackage().getName();
	}
}
