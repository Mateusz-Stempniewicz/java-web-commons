package com.java.web.commons.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * Obiekt rozszerzający standarowy obiekt {@link ResponseEntity}.
 * 
 * @param <R>
 *          - typ obiektu zwracanego do klienta
 * 
 * @author mateusz.stempniewicz
 */
public class Response<R> extends ResponseEntity<ResponseBody<R>> {
	
	public Response(HttpStatus statusCode) {
		super(statusCode);
	}
	
	public Response(MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(headers, statusCode);
	}
	
	public Response(ResponseBody<R> body, HttpStatus statusCode) {
		super(body, statusCode);
	}
	
	public Response(ResponseBody<R> body, MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(body, headers, statusCode);
	}
	
	public Response(R response, String status) {
		super(new ResponseBody<R>(response, status, null), HttpStatus.OK);
	}
	
	public Response(R response, String status, String message) {
		super(new ResponseBody<R>(response, status, message), HttpStatus.OK);
	}
	
	public Response(R response, String status, HttpStatus statusCode) {
		super(new ResponseBody<R>(response, status, null), statusCode);
	}
	
	public Response(R response, String status, String message, HttpStatus statusCode) {
		super(new ResponseBody<R>(response, status, message), statusCode);
	}
	
	public Response(R response, String status, MultiValueMap<String, String> headers, HttpStatus statusCode) {
		super(new ResponseBody<R>(response, status, null), headers, statusCode);
	}
	
	public Response(R response,
	    String status,
	    String message,
	    MultiValueMap<String, String> headers,
	    HttpStatus statusCode) {
		super(new ResponseBody<R>(response, status, message), headers, statusCode);
	}
}
