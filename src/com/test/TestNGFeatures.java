package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void loginPage() {
		System.out.println("logged in: ");
//		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginPage")
	public void HomepageTest() {
		System.out.println("Home Page tested: ");
	}

	@Test(dependsOnMethods = "loginPage")
	public void SearchPage() {
		System.out.println("Search Page tested: ");
	}
	
	@Test(dependsOnMethods = "loginPage")
	public void RegPage() {
		System.out.println("Reg Page tested: ");
	}
	
}
