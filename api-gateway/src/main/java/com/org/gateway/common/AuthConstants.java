package com.org.gateway.common;


public final class AuthConstants {

	private AuthConstants() {
	}

	public static final String CLAIM_KEY_USERNAME = "sub";
	public static final String CLAIM_KEY_AUDIENCE = "audience";
	public static final String CLAIM_KEY_CREATED = "created";
	public static final String CLAIM_KEY_ROLE = "role";
    public static final String AUDIENCE_WEB = "web";
    public static final String AUDIENCE_MOBILE = "mobile";
    public static final String AUDIENCE_TABLET = "tablet";
    
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_READ_WRITE = "writer";
    public static final String ROLE_READ_ONLY = "reader";
    
    public static final String REQUEST_TOKEN_HEADER_NAME = "bearer";
   
}
