package com.cg.login.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capg.onlineservices.models.LoginErrorMessage;

@RestControllerAdvice
public class IncorrectPasswordExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<LoginErrorMessage> toResponse(IncorrectPasswordException e)
	{
		LoginErrorMessage error = new LoginErrorMessage(400, e.getMessage());
		return new ResponseEntity<LoginErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
}
