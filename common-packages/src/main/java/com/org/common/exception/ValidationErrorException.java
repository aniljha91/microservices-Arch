package com.org.common.exception;

public class ValidationErrorException extends BaseException {

	private static final long serialVersionUID = 1L;
	
	private String fieldName;
    public ValidationErrorException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }
    
    public String getFieldName() {
    	return this.fieldName;
    }
}
