/*package com.org.gateway.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import com.org.gateway.domain.UserDetails;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String header = request.getHeader(this.tokenHeader);
		if (null == header) {
			logger.info("New User.");
			RestTemplate restTemplate = new RestTemplate();
			UserDetails user = new UserDetails();
			user.setUsername("testUser");
			user.setPassword("testPassword");
			HttpHeaders headers = setAuthenticationInHeader();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<UserDetails> restRequest = new HttpEntity<UserDetails>(user, headers);
			ResponseEntity<String> result = restTemplate.exchange("http://localhost:5000/uaa/generateToken", HttpMethod.POST, restRequest, String.class);
			if (result.getBody()!=null) {
				SecurityContextHolder.getContext().setAuthentication(result.getBody());
			}
			logger.info("New JWT token generated for User.");
		} else {
			logger.info("Existing User");
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = setAuthenticationInHeader();
			headers.setContentType(MediaType.TEXT_PLAIN);
			headers.add("Bearer", header);
			HttpEntity<String> restRequest = new HttpEntity<String>(headers);
			ResponseEntity<Boolean> result = restTemplate.exchange("http://localhost:5000/uaa/verifyToken", HttpMethod.GET, restRequest, Boolean.class);
			if (result.getBody()) {
				logger.info("Existing User verified successfully");
			} else {
				logger.info("Unauthorized User");
			}
		}

		chain.doFilter(request, response);
	}
	
	private HttpHeaders setAuthenticationInHeader(){
		String plainCreds = "user:auth";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}
}*/