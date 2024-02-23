package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	
	@BeforeSuite
	public void StartSuiteTest() {
		System.out.println("BeforeSuite: Suite testing has been started ");
	}
	 
	@BeforeTest
	public void SystemSetproperty() {
		System.out.println("BeforeTest: System set property and WebDriver instantiated ");
	}
	
	@BeforeClass
	public void OpenBrowser() {
		System.out.println("BeforeClass: Opened the Chrome Browser");
	}
	
	@BeforeMethod
	public void OpenTheURL() {
		System.out.println("BeforeMethod: Opened the URL:");
	}
	
	
	@Test
	public void GoogleTitleTest() {
		System.out.println("Test: Google title is GOOGLE from GoogleTitleTest:");
	}
	
	@Test
	public void GoogleSearch() {
		System.out.println("Test: Google search completed:");
	}
	
	@AfterMethod
	public void DeleteAllCookies() {
		System.out.println("AfterMethod: Deleted all the cookies");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("AfterClass: logout from the Google");
	}
	
	@AfterTest
	public void CloseBrowser() {
		System.out.println("AfterTest: Browser has been closed:");
	}
	
	@AfterSuite
	public void GenerateReports() {
		System.out.println("AfterSuite: Reports has been created:");
	}
	
	
	
}
