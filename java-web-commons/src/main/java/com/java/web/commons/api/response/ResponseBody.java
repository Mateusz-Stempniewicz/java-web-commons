package com.java.web.commons.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Główna zawartość obiektu {@link Response}, zawiera zwracany do klienta
 * obiekt, status i wiadomość.
 * 
 * @param <R>
 *          - typ zwracanego obiektu do klienta
 * 
 * @author mateusz.stempniewicz
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody<R> {
	
	private R response;
	private String status;
	private String message;
	
	public ResponseBody() {
		super();
	}
	
	public ResponseBody(R response, String status, String message) {
		super();
		this.response = response;
		this.status = status;
		this.message = message;
	}
	
	public R getResponse() {
		return response;
	}
	
	public void setResponse(R response) {
		this.response = response;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
