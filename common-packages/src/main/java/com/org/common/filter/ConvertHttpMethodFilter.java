package com.org.common.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 * This Filter changes the HTTP Method of an incoming request 
 * from the Method type fromMethod
 * to the Method type toMethod
 */
public final class ConvertHttpMethodFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(ConvertHttpMethodFilter.class);
	
	private String fromMethod;
	private String toMethod;

	public ConvertHttpMethodFilter(HttpMethod fromMethod, HttpMethod toMethod) {
		this.fromMethod = fromMethod.name();
		this.toMethod = toMethod.name();
	}

	static class FilteredRequest extends HttpServletRequestWrapper {

		private String toMethod;

		public FilteredRequest(ServletRequest request, String toMethod) {
			super((HttpServletRequest) request);
			this.toMethod = toMethod;
		}

		@Override
		public String getContentType() {
			return MediaType.APPLICATION_JSON_VALUE;
		}

		@Override
		public String getHeader(String name) {
			return super.getHeader(name);
		}

		@Override
		public String getMethod() {
			return toMethod;
		}

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if ((httpServletRequest).getMethod().equals(fromMethod)) {
			logger.info(String.format("converting request %s method from %s to %s ", httpServletRequest.getPathInfo(), fromMethod, toMethod));
			chain.doFilter(new FilteredRequest(request, toMethod), response);
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		// DO NOTHING
	}

	public void init(FilterConfig filterConfig) {
		// DO NOTHING
	}
}