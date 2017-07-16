package com.org.common.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import com.google.common.collect.Maps;
import com.org.common.exception.ErrorCodes;

public class ErrorCodeLookupServiceImpl implements ErrorCodeLookupService {

private final static Map<String, ErrorCodes> fieldErrorCodeMap = Maps.newHashMap();
	
	@PostConstruct
	private void init() {
		fieldErrorCodeMap.put("IPayloadWrapper",  ErrorCodes.PAYLOAD_INVALID);
		fieldErrorCodeMap.put("IPayloadWrapper.user",  ErrorCodes.PAYLOAD_USER_INVALID);
		fieldErrorCodeMap.put("IPayloadWrapper.sourceSystem",  ErrorCodes.PAYLOAD_SOURCE_INVALID);
	}
	
	@Override
	public ErrorCodes getErrorCode(String fieldName) {
		ErrorCodes errorCode = fieldErrorCodeMap.get(fieldName);
		return errorCode != null ? errorCode : ErrorCodes.VALIDATION_ERROR_CODE;
	}

}
