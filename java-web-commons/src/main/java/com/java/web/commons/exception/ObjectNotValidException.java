package com.java.web.commons.exception;

import org.springframework.validation.Errors;

/**
 * Wyjątek zwracany przez {@link ValidationErrorHandler} w momencie gdy obiekt
 * DTO nie przejdzie walidacji
 * 
 * @author mateusz.stempniewicz
 */
public class ObjectNotValidException extends RuntimeException {
	
	private static final long serialVersionUID = -7714061055243301370L;
	
	private final Errors errors;
	
	public ObjectNotValidException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}
	
	public ObjectNotValidException(Errors errors) {
		this(null, errors);
	}
	
	public Errors getErrors() {
		return errors;
	}
}
