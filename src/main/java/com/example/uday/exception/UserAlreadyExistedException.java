package com.example.uday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserAlreadyExistedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistedException(String message) {
		super(message);
	}

	public UserAlreadyExistedException(String message, Throwable cause) {
		super (message, cause);
	}

}
