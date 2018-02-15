package com.java.web.commons.response;

/**
 * Statusy HTTP zwracene do klienta w {@link Response}
 * 
 * @author mateusz.stempniewicz
 */
public class ResponseStatus {
	
	public static final String OK = "OK";
	public static final String FAILURE = "FAILURE";
	public static final String NOT_EXIST = "NOT_EXIST";
	public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
	
	public static final String USER_ALREADY_EXISTS = "USER_ALREADY_EXISTS";
	public static final String USER_NOT_EXISTS = "USER_NOT_EXISTS";
	public static final String USER_AUTHENTICATED = "USER_AUTHENTICATED";
	
	public static final String PASSWORD_NOT_CORRECT = "PASSWORD_NOT_CORRECT";
	
	private ResponseStatus() {
		super();
	}
}
