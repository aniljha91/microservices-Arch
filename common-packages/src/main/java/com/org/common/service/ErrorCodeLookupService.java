package com.org.common.service;

import com.org.common.exception.ErrorCodes;

public interface ErrorCodeLookupService {

	public ErrorCodes getErrorCode(String fieldName);
}
