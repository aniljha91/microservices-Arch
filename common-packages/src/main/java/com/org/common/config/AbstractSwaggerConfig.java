package com.org.common.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 


@Configuration
@EnableSwagger2
//@Profile("!"+ProfileConstants.SPRING_PROFILE_PRODUCTION) 
public abstract class AbstractSwaggerConfig implements EnvironmentAware  {  
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
          .apis(RequestHandlerSelectors.basePackage(getBasePackageName()))   
          .paths(regex(DEFAULT_INCLUDE_PATTERN))
          .build();                                           
    }
    
    public abstract String getBasePackageName();
    
    //public 
    
    /**
     * API Info as it appears on the swagger-ui page. 
     */ 
    private ApiInfo apiInfo() { 
        return new ApiInfo( 
            propertyResolver.getProperty("title"), 
            propertyResolver.getProperty("description"), 
            propertyResolver.getProperty("version"), 
            propertyResolver.getProperty("termsOfServiceUrl"), 
            new Contact(propertyResolver.getProperty("contact.name"), 
            		propertyResolver.getProperty("contact.url"),
            		propertyResolver.getProperty("contact.email")), 
            propertyResolver.getProperty("license"), 
            propertyResolver.getProperty("licenseUrl")); 
    } 
}
