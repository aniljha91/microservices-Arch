package com.org.common.exception.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.common.exception.ErrorCodes;
import com.org.common.exception.MessageType;
import com.org.common.exception.dto.ErrorMessage;
import com.org.common.exception.dto.IMessageDTO;
import com.org.common.exception.dto.ValidationErrorMessageDTO;

/**
 * @author bsakariboina
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
		Map<String,IMessageDTO> errors = new HashMap<String,IMessageDTO>();
		IMessageDTO message = null;
		for (FieldError fieldError : fieldErrors) {
			message = new ValidationErrorMessageDTO(ErrorCodes.VALIDATION_ERROR_CODE,MessageType.ERROR,fieldError.getDefaultMessage());
			errors.put(fieldError.getField(),message);
		}
		for (ObjectError objectError : globalErrors) {
			message = new ValidationErrorMessageDTO(ErrorCodes.VALIDATION_ERROR_CODE,MessageType.ERROR,objectError.getDefaultMessage());
			errors.put(objectError.getObjectName(),message);
		}
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return new ResponseEntity<Object>(errorMessage, headers, status);
	}

	@ResponseStatus(code=HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = buildErrorMap(ErrorCodes.MEDIA_TYPE_NOT_SUPPORTED, ex.getContentType().toString(), "error");
		return new ResponseEntity<Object>(errorMessage, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Throwable mostSpecificCause = ex.getMostSpecificCause();
		ErrorMessage errorMessage = buildErrorMap(ErrorCodes.MESSAGE_NOT_READABLE, mostSpecificCause.getMessage(), mostSpecificCause.getClass().getName());
		return new ResponseEntity<Object>(errorMessage, headers, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = buildErrorMap(ErrorCodes.SERVLET_BINDING_EXCEPTION, ex.getMessage(), "error");
		return new ResponseEntity<Object>(errorMessage, headers, status);
	}

	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = buildErrorMap(ErrorCodes.INTERNAL_SERVICE_ERROR, ex.getMessage(), "error");
		return new ResponseEntity<Object>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg, String fieldName) {
		Map<String, IMessageDTO> errors = new HashMap<String, IMessageDTO>();
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.ERROR, msg);
		errors.put(fieldName, message);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return errorMessage;
	}
}
