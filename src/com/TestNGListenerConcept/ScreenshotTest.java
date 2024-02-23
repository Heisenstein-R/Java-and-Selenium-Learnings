package com.TestNGListenerConcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersClass.class)

public class ScreenshotTest extends Base{
	
	@BeforeMethod
	public void setUp() {
		
		Initialization();
	}

	@AfterMethod
	public void CLoseBrowser() {
		driver.quit();
		
	}
	
	@Test
	public void takeScreenShot() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void Test1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void Test2() {
		Assert.assertEquals(true, false);
	}
	
	
}
