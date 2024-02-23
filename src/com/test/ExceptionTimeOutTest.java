package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	@Test(invocationTimeOut = 1, expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void infiniteLoop() {
		int i = 1;
		while(i == 1) {
			System.out.println(i);
		}
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void numberFormatExcept() {
		String a = "100adk";
		Integer.parseInt(a);
	}
	

}
