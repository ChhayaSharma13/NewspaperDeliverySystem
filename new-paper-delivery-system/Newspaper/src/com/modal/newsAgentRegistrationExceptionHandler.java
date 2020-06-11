package com.modal;

public class newsAgentRegistrationExceptionHandler extends Exception {
	String message;
	
	public newsAgentRegistrationExceptionHandler(String errMessage) {
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}
