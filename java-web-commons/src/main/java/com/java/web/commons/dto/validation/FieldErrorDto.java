package com.java.web.commons.dto.validation;

import java.io.Serializable;

/**
 * Obiekt reprezentujący błędnego propertiesa w obiekcie DTO.<br />
 * Zawiera nazwę i kod danego propertiesa, wiadomość o błędzie i wartość, która
 * jest błędna.
 * 
 * @see ObjectErrorDto
 * @see ValidationErrorDto
 * @see ValidationErrorHandler
 * 
 * @author mateusz.stempniewicz
 */
public class FieldErrorDto implements Serializable {
	
	private static final long serialVersionUID = -4940451477751206031L;
	
	private String name;
	private String code;
	private String message;
	private Object rejectedValue;
	
	public FieldErrorDto() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getRejectedValue() {
		return rejectedValue;
	}
	
	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}
}
