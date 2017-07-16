package com.org.common.exception;

public class ErrorCodeException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private ErrorCodes errorCode;

	public ErrorCodeException(String message, ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}
	
}
