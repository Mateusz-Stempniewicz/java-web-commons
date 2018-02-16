package com.java.web.commons.dto.validation;

import java.io.Serializable;
import java.util.List;

/**
 * Obiekt zawierający listę błędnych pól z danego obiektu DTO
 * 
 * @see ValidationErrorDto
 * @see ValidationErrorHandler
 * 
 * @author mateusz.stempniewicz
 */
public class ObjectErrorDto implements Serializable {
	
	private static final long serialVersionUID = -4127247200274400307L;
	
	private String object;
	private List<FieldErrorDto> fields;
	
	public ObjectErrorDto() {
		super();
	}
	
	public String getObject() {
		return object;
	}
	
	public void setObject(String object) {
		this.object = object;
	}
	
	public List<FieldErrorDto> getFields() {
		return fields;
	}
	
	public void setFields(List<FieldErrorDto> fields) {
		this.fields = fields;
	}
}
