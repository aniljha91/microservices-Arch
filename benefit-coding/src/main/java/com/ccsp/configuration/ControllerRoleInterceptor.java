package com.ccsp.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class ControllerRoleInterceptor extends HandlerInterceptorAdapter {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.header}")
	private String headerName;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getHeader(headerName) != null) {
			Claims claims = getClaimsFromToken(request.getHeader(headerName));
			if (claims != null && claims.size() > 0) {
				if (handler instanceof HandlerMethod) {
					HandlerMethod handlerMethod = (HandlerMethod) handler;
					/*SomeAnnotation annotation = handlerMethod.getMethodAnnotation(SomeAnnotation.class);
					if (annotation != null) {
						// do stuff
					}*/
				}
				return true;
			}
			return false;
		}
		return false;
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
