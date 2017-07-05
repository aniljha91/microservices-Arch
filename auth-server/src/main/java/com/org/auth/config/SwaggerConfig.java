package com.org.auth.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.org.auth.common.ProfileConstants;
import com.org.auth.controller.AuthController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!"+ProfileConstants.SPRING_PROFILE_PRODUCTION) 
public class SwaggerConfig  implements EnvironmentAware  {  
	public static final String DEFAULT_INCLUDE_PATTERN = "/.*"; 

	private RelaxedPropertyResolver propertyResolver; 
	
	@Override 
    public void setEnvironment(Environment environment) { 
        this.propertyResolver = new RelaxedPropertyResolver(environment, "swagger."); 
    }
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()         
          //.apis("com.org.auth.controller")
          //.paths(PathSelectors.any())
          .apis(RequestHandlerSelectors.basePackage(getBasePackageName()))   
          .paths(regex(DEFAULT_INCLUDE_PATTERN))
          .build();                                           
    }
    
    
	public String getBasePackageName() {
		return AuthController.class.getPackage().getName();
	}

    /**
     * API Info as it appears on the swagger-ui page. 
     */ 
    private ApiInfo apiInfo() { 
    	
    	return new ApiInfo( 
            propertyResolver.getProperty("title"), 
            propertyResolver.getProperty("description"), 
            "v1", 
            propertyResolver.getProperty("termsOfServiceUrl"), 
            new Contact(propertyResolver.getProperty("contact.name"), 
            		propertyResolver.getProperty("contact.url"),
            		propertyResolver.getProperty("contact.email")), 	
            propertyResolver.getProperty("license"), 
            propertyResolver.getProperty("licenseUrl") ); 
    } 
}

