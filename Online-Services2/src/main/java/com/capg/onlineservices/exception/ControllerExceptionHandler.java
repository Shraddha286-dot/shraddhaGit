package com.capg.onlineservices.exception;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

		@ResponseBody
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler
		ErrorMessage exceptionHandler(ValidationException e) {
			return new ErrorMessage("400",e.getMessage());
		}
}