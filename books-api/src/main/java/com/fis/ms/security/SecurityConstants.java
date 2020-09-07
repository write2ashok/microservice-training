package com.fis.ms.security;

public class SecurityConstants {
	
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/login";
	public static final String HEADER_CUSTOM_HEADER = "Access-Control-Expose-Headers";
	public static final String HEADER_CUSTOM_HEADER_VALUES = "Origin, X-Requested-With, Content-Type, Accept, Authorization, X-Custom-header";
}