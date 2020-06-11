package com.modal;

public class newsAgentLoginImpl implements newsAgentLoginInterface {
	
	
	public String validateUsername(String username) {
		if(username.length() >=3 && username.length() <=50) { 
			
			return "Correct Username!";
		}
		else {
			return "Please enter correct username!";
		}
	}
	
	
	public String validatePassword(String password) {
		if(password.length() >=8 && password.length() <=20) { 
			return "Correct password!";
		}
		else {
			return "Please enter correct password!";
		}
	}
}
