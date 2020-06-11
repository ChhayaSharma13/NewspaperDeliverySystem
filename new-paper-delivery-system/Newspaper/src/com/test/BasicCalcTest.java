package com.test;
import com.controller.BasicCalc;
import junit.framework.TestCase;

public class BasicCalcTest extends TestCase{
    BasicCalc calc = new BasicCalc();
    // Test 1: Verify if addition function is giving correct output
    // Input(s): 20 and 50
    // Expected output: 70
    public void testCheckOutput1(){
        assertEquals(70, calc.add(20,50));
    }


    // Test 2: Verify if substraction function is giving correct output
    // Input(s): 50 and 20
    // Expected output: 30
    public void testCheckOutput2(){
        assertEquals(30, calc.sub(50,20));
    }


    // Test 3: Verify if multiplication function is giving correct output
    // Input(s): 50 and 2
    // Expected output: 100
    public void testCheckOutput3(){
        assertEquals(100, calc.mul(50,2));
    }

    // Test 4: Verify if division function is giving correct output
    // Input(s): 50 and 2
    // Expected output: 25
    public void testCheckOutput4(){
        assertEquals(25, calc.div(50,2));
    }
}