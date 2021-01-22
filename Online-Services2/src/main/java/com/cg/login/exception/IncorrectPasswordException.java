package com.cg.login.exception;

public class IncorrectPasswordException extends RuntimeException{
	String message;
	private static final long serialVersionUID = 1L;
	 public IncorrectPasswordException(String message)
	 {
		 super(message);
	 }

}
