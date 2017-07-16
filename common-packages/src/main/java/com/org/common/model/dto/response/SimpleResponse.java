package com.org.common.model.dto.response;


import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.org.common.model.dto.IDto;

@AutoProperty
public class SimpleResponse implements IDto {
	private static final long serialVersionUID = 1;

	private final static String SUCCESS = "SUCCESS";
	private final static String FAILURE = "FAILURE";

	private String response;
	
	public SimpleResponse() {
		// no arg constructor
	}
	
	private SimpleResponse(Builder builder) {
		this.response = builder.response;
	}
	
	public String getResponse() {
		return response;
	}

	public static class Builder {

		String response;
		public Builder withResponse(String response) {
			this.response = response;
			return this;
		}
		
		public Builder withSuccess() {
			this.response = SUCCESS;
			return this;
		}
		
		public Builder withFailure() {
			this.response = FAILURE;
			return this;
		}

		public SimpleResponse build() {
			return new SimpleResponse(this);
		}
	}
	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return Pojomatic.equals(this, obj);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}
}
