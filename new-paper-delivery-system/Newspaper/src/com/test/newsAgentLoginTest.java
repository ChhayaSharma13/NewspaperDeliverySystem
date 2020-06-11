package com.test;

import com.modal.newsAgentLoginImpl;

import junit.framework.TestCase;

public class newsAgentLoginTest extends TestCase {
	newsAgentLoginImpl newsAgentL = new newsAgentLoginImpl();
	/*
		Test Number	1
		Test Objective	Valid username (length >=3)
		Test Type	jUnit
		Input (s)	UN = abc 
		Expected Output	Correct Username
	 */
	public void testValidUsername() {
		assertEquals("Correct Username!", newsAgentL.validateUsername("abcd"));
	}
	/*
	 Test Number:  2
	Test Objective: Valid username (length <=50)
	Test Type:	jUnit
	Input (s):	UN = abcdefghijklmn
	Expected Output:	Correct Username

	 */
	public void testValidUsername2() {
		assertEquals("Correct Username!", newsAgentL.validateUsername("abcdefghijklmn"));
	}
	/*
	 Test Number: 3
	Test Objective: InValid username (length <3)
	Test Type	jUnit
	Input (s)	UN = ab
	Expected Output	Incorrect Username

	 */
	public void testInValidUsername() {
		assertEquals("Please enter correct username!", newsAgentL.validateUsername("ab"));
	}
	/*
	 Test Number 4
	Test Objective InValid username (length >50)
	Test Type	jUnit
	Input (s)	UN = ab
	Expected Output	Incorrect Username

	 */
	public void testInValidUsername2() {
		assertEquals("Please enter correct username!", newsAgentL.validateUsername("aqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm"));
	}
	
	/*
	 Test Number	5
	Test Objective	Valid Password (length >=8)
	Test Type	jUnit
	Input (s)	Pswd = abc@12345
	Expected Output	Correct Password
	 */
	public void testValidPassword() {
		assertEquals("Correct password!", newsAgentL.validatePassword("abc@12345"));
	}
	/*
	 Test Number	6
	Test Objective	Valid Password (length <=20)
	Test Type	jUnit
	Input (s)	Pswd = qwertyuiopasdfghjkl
	Expected Output	Correct Password
	 */
	public void testValidPassword2() {
		assertEquals("Correct password!", newsAgentL.validatePassword("qwertyuiopasdfghjkl"));
	}
	/*
	 Test Number	7
	Test Objective	InValid Password (length <8)
	Test Type	jUnit
	Input (s)	Pswd = abc@12
	Expected Output	Incorrect Password
	 */
	public void testInValidPassword() {
		assertEquals("Please enter correct password!", newsAgentL.validatePassword("abcdef"));
	}
	/*
	 Test Number	8
	Test Objective	InValid Password (length >20)
	Test Type	jUnit
	Input (s)	Pswd = abc@12
	Expected Output	Incorrect Password
	 */
	public void testInValidPassword2() {
		assertEquals("Please enter correct password!", newsAgentL.validatePassword("qwertyuiopasdfghjklzxcv"));
	}
	
}
