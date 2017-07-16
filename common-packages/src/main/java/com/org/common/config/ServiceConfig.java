package com.org.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import com.org.common.converter.ErrorMessageToTextHTTPConverter;
import com.org.common.service.ErrorCodeLookupService;
import com.org.common.service.ErrorCodeLookupServiceImpl;

@Configuration
@PropertySource("classpath:common.properties")
public class ServiceConfig {

	@Bean
	public ErrorCodeLookupService errorCodeLookupService() {
		return new ErrorCodeLookupServiceImpl();
	}

	
    @Bean
    public HttpMessageConverters messageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

        messageConverters.add(new ByteArrayHttpMessageConverter());
        ErrorMessageToTextHTTPConverter customHttpMessageConverter = new ErrorMessageToTextHTTPConverter();
        messageConverters.add(customHttpMessageConverter);
        return new HttpMessageConverters(messageConverters);
    }
}
