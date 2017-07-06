
package com.ccsp.common;


public enum HttpStatusCode {

  Success(200), ValidationError(400), ServerError(500), FORBIDDEN(403), REDIRECTION(302), Unauthorized(401);

  private HttpStatusCode(final int code) {
    statusCode = code;
  }

  private int statusCode;

  public int getCode() {
    return statusCode;
  }


}
