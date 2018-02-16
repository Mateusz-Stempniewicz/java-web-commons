package com.java.web.commons.dto.validation;

import java.io.Serializable;
import java.util.List;

/**
 * Obiekt DTO zawierający listę błędnych obiektów z walidacji obiektów DTO w
 * {@link ValidationErrorHandler}
 * 
 * @author mateusz.stempniewicz
 */
public class ValidationErrorDto implements Serializable {
	
	private static final long serialVersionUID = -3594547199481039773L;
	
	private List<ObjectErrorDto> errors;
	
	public ValidationErrorDto() {
		super();
	}
	
	public List<ObjectErrorDto> getErrors() {
		return errors;
	}
	
	public void setErrors(List<ObjectErrorDto> errors) {
		this.errors = errors;
	}
}
