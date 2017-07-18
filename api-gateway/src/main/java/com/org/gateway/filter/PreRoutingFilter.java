package com.org.gateway.filter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.org.gateway.common.AuthConstants;
import com.org.gateway.security.JwtTokenUtil;
import com.org.gateway.util.ErrorHandler;

@Component
public class PreRoutingFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreRoutingFilter.class);
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Value("${jwt.header}")
	private String headerName;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run(){
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (ctx!=null && request != null && request.getHeader(headerName)!=null) {
			log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
			ctx.addZuulRequestHeader(headerName, request.getHeader(headerName));
			/*if(jwtTokenUtil.validateToken(request.getHeader(AuthConstants.REQUEST_TOKEN_HEADER_NAME))){
				ctx.addZuulRequestHeader(AuthConstants.REQUEST_TOKEN_HEADER_NAME, request.getHeader(AuthConstants.REQUEST_TOKEN_HEADER_NAME));
			}*/
		}else{
			new ErrorHandler().processValidationError(new AuthenticationException("invalid user, Please enter valid credentials"));
		}
		return null;
	}

}