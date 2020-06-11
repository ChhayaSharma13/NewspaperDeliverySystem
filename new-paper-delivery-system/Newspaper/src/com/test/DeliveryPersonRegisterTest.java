package com.test;

import com.dao.RegisterMethods;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DeliveryPersonRegisterTest extends TestCase {

	private String name1 = "";
	private String name2 = "tom";
	private String psd1 = "";
	private String psd2 = "1234567";
	private String Email1 = "";
	private String Email2 = "";

	public void testInvaildName() {
		Assert.assertTrue(name1.equals(""));
		System.out.println("usename is invalid");
	}

	public void testVaildName() {
		Assert.assertTrue(!name2.equals(""));
		System.out.println("usename is valid");
	}

	public void testInvaildPassword() {
		Assert.assertTrue(psd1.equals(""));
		System.out.println("Password is invalid");
	}

	public void testVaildPassword() {
		Assert.assertTrue(!psd2.equals(""));
		System.out.println("Password is valid");
	}

	
	public void testConfirmPassword() {
		Assert.assertTrue(psd2.equals("1234567"));
		System.out.println("Password is the same as confirm password");
	}

	
	public void testNotConfirmPassword() {
		Assert.assertTrue(!psd2.equals("1234568"));
		System.out.println("confirm password is different with password");
	}

	
	public void testInvalidEmail() {
		Assert.assertEquals("Invalid email format!", validateEmail("abcgmail.com"));
	}

	
	public void testValidEmail() {
		Assert.assertEquals("Correct email", validateEmail("abc@gmail.com"));
	}
		
	
	public void testValidPhone() {
		Assert.assertEquals("Correct phone",validatePhone(987654321));
	}

	
	public void testInvalidPhone() {
		Assert.assertEquals("Invalid phone no", validatePhone(76456667));
	}
	
	
	public void registRegist() throws Exception {
		Boolean result = RegisterMethods.regist("tom", "tom", "tom@gmail.com", "123456789");
		Assert.assertTrue(result);
	}

	public String validateEmail(String email) {
		for(int i=0;i<email.length();i++) {
			if(email.charAt(i) == '@') {
				return "Correct email";
			}
		}
		return "Invalid email format!";		
	}
	
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
}
