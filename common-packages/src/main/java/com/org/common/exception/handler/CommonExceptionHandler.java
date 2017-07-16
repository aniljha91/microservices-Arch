package com.org.common.exception.handler;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JsonParseException;
import com.org.common.exception.ConstraintViolationException;
import com.org.common.exception.ErrorCodes;
import com.org.common.exception.MessageType;
import com.org.common.exception.ValidationErrorException;
import com.org.common.exception.dto.ErrorMessage;
import com.org.common.exception.dto.IMessageDTO;
import com.org.common.exception.dto.ValidationErrorMessageDTO;
import com.org.common.service.ErrorCodeLookupService;

/**
 * @author bsakariboina
 *
 */
public abstract class CommonExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@Autowired
	protected ErrorCodeLookupService errorCodeLookupService;
    
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleConstraintViolationsException(ConstraintViolationException ex) {
		Map<String,IMessageDTO> errors = new HashMap<String,IMessageDTO>();
		IMessageDTO message = null;
		String fieldName = null;
		for (ConstraintViolation cv : ex.getConstraintViolations()) {
			fieldName = cv.getPropertyPath().toString();
			message = new ValidationErrorMessageDTO(errorCodeLookupService.getErrorCode(fieldName), MessageType.ERROR, cv.getMessage());
			errors.put(fieldName,message);
		}
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
    	ErrorMessage error;
    	 if(ex.getMostSpecificCause().getClass(). equals(JsonParseException.class)){
    	        error = buildErrorMap(ErrorCodes.PAYLOAD_INVALID, ex.getMostSpecificCause().getMessage(), "error");
    	 }else{
    		 	error = buildErrorMap(ErrorCodes.MESSAGE_NOT_READABLE, ex.getMostSpecificCause().getMessage(), "error");
    	 }
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorMessage error = buildErrorMap(ErrorCodes.METHOD_ARGUMENT_TYPE_MISMATCH, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
    
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
    	logger.warn("Illegal Argument Exception", ex);
    	ErrorMessage errorMessage = buildErrorMap(ErrorCodes.VALIDATION_ERROR_CODE, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationErrorException.class})
	protected ResponseEntity<ErrorMessage> handleValidationErrorException(com.org.common.exception.ValidationErrorException ex) {
		ErrorMessage errorMessage = buildErrorMap(errorCodeLookupService.getErrorCode(ex.getFieldName()), ex.getMessage(), ex.getFieldName());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex) {
    	logger.error("Unexpected Server Error ", ex);
    	ErrorMessage errorMessage = buildErrorMap(ErrorCodes.INTERNAL_SERVICE_ERROR, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
   
    
	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg) {
		return buildErrorMap(errorCode, msg, "error");
	}

	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg, String fieldName) {
		Map<String, IMessageDTO> errors = new HashMap<String, IMessageDTO>();
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.ERROR, msg);
		errors.put(fieldName, message);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return errorMessage;
	}
}
