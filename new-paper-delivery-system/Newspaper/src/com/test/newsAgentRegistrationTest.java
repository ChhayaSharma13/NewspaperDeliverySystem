package com.test;

import junit.framework.TestCase;
import com.modal.newsAgentRegistrationValidateImpl;

public class newsAgentRegistrationTest extends TestCase {
	
	newsAgentRegistrationValidateImpl newsAgent = new newsAgentRegistrationValidateImpl();
	
	/*
	Test Number:	1
	Test Objective:	Valid Email
	Test Type:	jUnit
	Input(s):	abc@gmail.com
	Expected Output: Correct email
	 */
	
	public void testValidEmail() {
		assertEquals("Correct email", newsAgent.validateEmail("abc@gmail.com"));
	}
	
	/*
	Test Number:	2
	Test Objective:	Invalid Email
	Test Type:	jUnit
	Input(s):	abcgmail.com
	Expected Output: Invalid email format!
	 */
	public void testInvalidEmail() {
		assertEquals("Invalid email format!", newsAgent.validateEmail("abcgmail.com"));
	}
	
	
	/*
	Test Number: 3
	Test Objective: Valid Phone No
	Test Type: jUnit
	Input (s): 9876543210
	Expected Output: Correct Phone
	*/
	public void testValidPhone() {
		assertEquals("Correct phone", newsAgent.validatePhone(987654321));
	}
	
	/*
	Test Number: 4
	Test Objective: Invalid Phone No 
	Test Type: jUnit
	Input (s): 764564667
	Expected Output: Invalid phone no
	*/
	public void testInvalidPhone() {
		assertEquals("Invalid phone no", newsAgent.validatePhone(76456667));
	}
	
	/*
	Test Number	5
	Test Objective	Valid username (length >=3)
	Test Type	jUnit
	Input (s)	UN = abcd
	Expected Output	Correct Username
	*/
	public void testValidUsername() {
		assertEquals("Correct username", newsAgent.validateUsername("abcd"));
	}
	
	/*
	Test Number	6
	Test Objective	Valid username (length <=50)
	Test Type	jUnit
	Input (s)	UN = thisisname
	Expected Output	Correct Username
	*/
	public void testValidUsername2() {
		assertEquals("Correct username", newsAgent.validateUsername("thisisname"));
	}
	
	
	/*
	Test Number	7
	Test Objective	Invalid username (length <= 2)
	Test Type	jUnit
	Input (s)	UN = ab
	Expected Output	Please enter a valid username
	*/
	public void testInvalidUsername() {
		assertEquals("Please enter a valid username", newsAgent.validateUsername("ab"));
	}
	
	/*
	Test Number	8
	Test Objective	Invalid username (length > 50)
	Test Type	jUnit
	Input (s)	UN = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	Expected Output	Please enter a valid username
	*/
	public void testInvalidUsername2() {
		assertEquals("Please enter a valid username", newsAgent.validateUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	/*
	Test Number: 9
	Test Objective: Valid Password (length >=8)
	Test Type: jUnit
	Input (s): Abc@12345
	Expected Output: Correct Password
	*/
	public void testValidPassword() {
		assertEquals("Correct password", newsAgent.validatePassword("Abc@12345"));
	}
	
	/*
	Test Number: 10
	Test Objective: Valid Password (length <=20)
	Test Type: jUnit
	Input (s): Abc@12345
	Expected Output: Correct Password
	*/
	public void testValidPassword2() {
		assertEquals("Correct password", newsAgent.validatePassword("Abc@12345xxyz"));
	}
	
	
	/*
	Test Number: 11
	Test Objective: Valid Password (length<8)
	Test Type: jUnit
	Input (s): ab123
	Expected Output: Please enter valid a password
	*/
	public void testInvalidPassword() {
		assertEquals("Please enter a strong password", newsAgent.validatePassword("ab123"));
	}
	
	
	/*
	Test Number: 12
	Test Objective: Valid Password (length>20)
	Test Type: jUnit
	Input (s): ab123aaaaaaaaaaavvvvvvvvvvvvv
	Expected Output: Please enter valid a password
	*/
	public void testInvalidPassword2() {
		assertEquals("Please enter a strong password", newsAgent.validatePassword("ab123aaaaaaaaaaavvvvvvvvvvvvv"));
	}
}
