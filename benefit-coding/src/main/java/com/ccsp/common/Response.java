
package com.ccsp.common;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
@JsonInclude(Include.NON_NULL)
public class Response {
	@JsonProperty("status")
	private HttpStatusCode status;
	@JsonProperty("err_code")
	private Object errorCode;
	@JsonProperty("err_msg")
	private String errorMessage;
	@JsonProperty("exception_type")
	private String exceptionType;
	@JsonProperty("result")
	private Object result;


	/**
	 * 
	 */
	public Response() {

	}

	/**
	 * Constructor
	 * 
	 * @param result
	 * @param status
	 */
	public Response(Object result, HttpStatusCode status) {
		this.status = status;
		this.result = result;
	}

	/**
	 * Constructor
	 * 
	 * @param status
	 * @param errorCode
	 * @param errorMessage
	 * @param exceptionType
	 */
	public Response(HttpStatusCode status, int errorCode, String errorMessage,
			String exceptionType) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exceptionType = exceptionType;
	}

	/**
	 * Constructor
	 * 
	 * @param status
	 * @param errorCode
	 * @param errorMessage
	 * @param exceptionType
	 */
	public Response(HttpStatusCode status, int errorCode, String errorMessage) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

	/*
	 * * @return the status
	 */
	public HttpStatusCode getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}

	/**
	 * @return the errorCode
	 */
	public Object getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(Object errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the exceptionType
	 */
	public String getExceptionType() {
		return exceptionType;
	}

	/**
	 * @param exceptionType
	 *            the exceptionType to set
	 */
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}



}




