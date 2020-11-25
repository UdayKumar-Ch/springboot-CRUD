package com.example.uday.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.uday.exception.UserAlreadyExistedException;
import com.example.uday.exception.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotExistException(UserNotFoundException unfe) {
		return unfe.getMessage();
	}
	
	@ExceptionHandler(UserAlreadyExistedException.class)
	public String handleIfUserAlreadyExistException(UserAlreadyExistedException uaee) {
		return uaee.getMessage();
	}
	

}