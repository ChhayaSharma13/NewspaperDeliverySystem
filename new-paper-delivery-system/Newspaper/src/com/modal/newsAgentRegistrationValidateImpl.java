package com.modal;

public class newsAgentRegistrationValidateImpl implements newAgentRegistrationValidateInterface {

	@Override
	public String validateUsername(String username) {
		if(username.length() > 2 && username.length() <= 50) {
			return "Correct username";
		}
		return "Please enter a valid username";
	}

	@Override
	public String validateEmail(String email) {
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i) == '@') {
				return "Correct email";
			}
		}
		return "Invalid email format!";
	}

	@Override
	public String validatePhone(long no) {
		int count=0;
		while(no!=0) {
			count++;
			no = no/10;
		}
		
		if(count>=9) {
			return "Correct phone";
		}
		return "Invalid phone no";
	}

	@Override
	public String validatePassword(String password) {
		String res = "[0-9a-zA-Z]{6,16}";
		if(password.trim().matches(res)) {
			return "Correct password";
		}
		
		if(password.length() <= 20 && password.length() >= 8) {
			return "Correct password";
		}
		
		if(password.length() > 20 || password.length() < 8) {
			return "Please enter a strong password";
		}
		return "Please enter a strong password";
	}


}
