package com.test;

import com.modal.addSubscriptionImpl;

import junit.framework.TestCase;

public class addSubscriptionTest extends TestCase {
	
	addSubscriptionImpl addSubVal = new addSubscriptionImpl();
	
	/*
	Test Number: 1
	Test Objective:	Valid Subscription Type
	Test Type:	jUnit
	Input(s):	Monthly
	Expected Output: true
	 */
	public void testValidType1() {
		assertEquals(true, addSubVal.validSubType("Monthly"));
	}
	
	/*
	Test Number: 2
	Test Objective:	Valid Subscription Type
	Test Type:	jUnit
	Input(s):	Weekly
	Expected Output: true
	 */
	public void testValidType2() {
		assertEquals(true, addSubVal.validSubType("Weekly"));
	}
	
	/*
	Test Number: 3
	Test Objective:	Valid Subscription Type
	Test Type:	jUnit
	Input(s):	Daily
	Expected Output: true
	 */
	public void testValidType3() {
		assertEquals(true, addSubVal.validSubType("Daily"));
	}
	
	/*
	Test Number: 4
	Test Objective:	Invalid Subscription Type
	Test Type:	jUnit
	Input(s):	Yearly
	Expected Output: false
	 */
	public void testInValidType1() {
		assertEquals(false, addSubVal.validSubType("Yearly"));
	}
	
	/*
	Test Number: 5
	Test Objective:	Valid start date and end date
	Test Type:	jUnit
	Input(s):	"29/02/2020","12/03/2020"
	Expected Output: true
	 */
	public void testValidDates() {
		assertEquals(true, addSubVal.validDates("29/02/2020","12/03/2020"));
	}
	
	/*
	Test Number: 6
	Test Objective:	Invalid start date and end date
	Test Type:	jUnit
	Input(s):	"29/02/2020", "20/02/2020"
	Expected Output: false
	 */
	public void testInValidDates() {
		assertEquals(false, addSubVal.validDates("29/02/2020", "20/02/2020"));
	}
}
