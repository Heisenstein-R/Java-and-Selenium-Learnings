package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

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
		System.out.println("Title of the Page is: " +driver.getTitle());
	}
	
	@Test(priority = 2, groups = "Logo")
	public void LogoCheck() {
		boolean disp = driver.findElement(By.xpath("//img[@class = 'lnXdpd']")).isDisplayed();
		if(disp) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("logo is not there, so something went wrong: ");
		}
	}
	
	@Test(priority = 3, groups = "display")
	public void GmailLinkDisplay() {
		boolean disp = driver.findElement(By.xpath("//a[@class = 'gb_E' and text() = 'Gmail']")).isDisplayed();
		if(disp) {
			System.out.println("Gmail link is Displayed");
		}else {
			System.out.println("Gmail isn't displayed something went wromg");
		}
	}
	
	@Test(priority = 4, groups = "Tests")
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(priority = 5, groups = "Tests")
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(priority = 6, groups = "Tests")
	public void test3() {
		System.out.println("test3");
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
		System.out.println("Closed the browser");
	}

}
