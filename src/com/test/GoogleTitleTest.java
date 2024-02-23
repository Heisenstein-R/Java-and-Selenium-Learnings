package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void OpenChromeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		System.out.println("Opened the browser");
	}
	
	@Test(priority = 1, groups = "Title")
	public void GetTitle() {
		String title = driver.getTitle();
		System.out.println("Title of the Page is: " +driver.getTitle());
		Assert.assertEquals(title, "Google", "Title is not matched.");
	}
	
	@Test(priority = 2, groups = "Logo")
	public void LogoCheck() {
		boolean disp = driver.findElement(By.xpath("//img[@class = 'lnXdpd']")).isDisplayed();
		Assert.assertTrue(disp);
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
		System.out.println("Closed the browser");
	}

}
