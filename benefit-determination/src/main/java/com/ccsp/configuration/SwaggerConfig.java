package com.ccsp.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.ccsp.common.AbstractSwaggerConfig;
import com.ccsp.common.ProfileConstants;
import com.org.BenefitPlanApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2; 


@Configuration
@EnableSwagger2
@Profile("!"+ProfileConstants.SPRING_PROFILE_PRODUCTION) 
public class SwaggerConfig  extends AbstractSwaggerConfig{  
	
	@Override
	public String getBasePackageName() {
		return BenefitPlanApplication.class.getPackage().getName();
	}
}
