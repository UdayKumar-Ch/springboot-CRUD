package com.example.uday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnknownUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnknownUserException(String message) {
		super(message);
	}
	
	public UnknownUserException(String message, Throwable cause) {
		super (message, cause);
	}
	
}
