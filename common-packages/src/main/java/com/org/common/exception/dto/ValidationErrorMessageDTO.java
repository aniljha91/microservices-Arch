package com.org.common.exception.dto;

import com.org.common.exception.ErrorCodes;
import com.org.common.exception.MessageType;
import com.org.common.exception.dto.IMessageDTO;

public class ValidationErrorMessageDTO implements IMessageDTO{
  private ErrorCodes errorCode;
  private String message;
  private MessageType type;
  public ValidationErrorMessageDTO() {
  }
  
  public ValidationErrorMessageDTO(ErrorCodes errorCode, MessageType type, String message) {
    this.errorCode=errorCode;
    this.message = message;
    this.type = type;
  }

  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public MessageType getType() {
    return type;
  }
  
  public void setType(MessageType type) {
    this.type = type;
  }

public ErrorCodes getErrorCode() {
	return errorCode;
}

public void setErrorCode(ErrorCodes errorCode) {
	this.errorCode = errorCode;
}

@Override
public String toString() {
	return "ValidationError [errorCode=" + errorCode + ", message=" + message + ", type=" + type + "]";
}

  
  
  
}
