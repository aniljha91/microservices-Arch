package com.org.auth.controller;

import java.security.InvalidKeyException;
import java.security.SignatureException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.auth.domain.UserDetails;
import com.org.auth.service.security.JwtTokenUtil;
import com.org.auth.service.security.MongoUserDetailsService;

import io.jsonwebtoken.Claims;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private MongoUserDetailsService userDetailsService;
    
    @Value("${jwt.header}")
    private String tokenHeader;

	@RequestMapping(value = "/generateToken", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody String createJsonWebToken(@RequestBody UserDetails user) throws SignatureException {
		UserDetails userDetails = this.userDetailsService.loadUserByUser(user.getUsername());
		if(userDetails!=null && userDetails.getUsername().equals(user.getUsername()) 
				&& userDetails.isAccountNonExpired() && userDetails.isAccountNonLocked()){
		return jwtTokenUtil.generateToken(user.getUsername());
		}
		return null;
	}

	@RequestMapping(value = "/verifyToken", method = RequestMethod.GET, consumes="text/plain")
	public @ResponseBody Boolean validateToken(@RequestBody HttpServletRequest request) throws InvalidKeyException {
		return jwtTokenUtil.validateToken(extractTokenFromRequestHeader(request));
	}
	
	@RequestMapping(value = "/refreshToken", method = RequestMethod.GET, consumes="text/plain")
	public @ResponseBody String refreshToken(@RequestBody HttpServletRequest request) throws Exception {
		return jwtTokenUtil.refreshToken(extractTokenFromRequestHeader(request));
	}
	
	@RequestMapping(value = "/returnTokenClaims", method = RequestMethod.GET, produces="application/json", consumes="text/plain")
	public @ResponseBody Claims returnTokenClaims(@RequestBody HttpServletRequest request) throws InvalidKeyException {
		return jwtTokenUtil.getClaimsFromToken(extractTokenFromRequestHeader(request));
	}
	
	private String extractTokenFromRequestHeader(HttpServletRequest request){
		String header = request.getHeader(this.tokenHeader);
		return header;
	}
}
