package com.org.common.filter;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ControllerRoleInterceptor extends HandlerInterceptorAdapter {
	
	private String secret;
	private String headerName;
	
	public ControllerRoleInterceptor(String secret,String headerName){
		this.secret = secret;
		this.headerName = headerName;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getHeader(headerName) != null) {
			Claims claims = getClaimsFromToken(request.getHeader(headerName));
			if (claims != null && claims.size() > 0) {
				SecurityContext securityContext = SecurityContextHolder.getContext();
				Authentication auth = new UsernamePasswordAuthenticationToken(claims.get("username"), null, returnAuthorities(claims));
				securityContext.setAuthentication(auth);
				HttpSession session = request.getSession(true);
			    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
			    
				/*if (handler instanceof HandlerMethod) {
					HandlerMethod handlerMethod = (HandlerMethod) handler;
					SomeAnnotation annotation = handlerMethod.getMethodAnnotation(SomeAnnotation.class);
					if (annotation != null) {
						// do stuff
					}
				}*/
			    
				return true;
			}else{
				response.sendError(401, "Invalid User, Please send a valid token!!");
				return false;
			}
		}else{
			response.sendError(401, "Invalid User, Please send a valid token!!");
			return false;
		}
	}

	private Collection<GrantedAuthority> returnAuthorities(Claims claims) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+((String)claims.get("role")).toUpperCase());
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
}
