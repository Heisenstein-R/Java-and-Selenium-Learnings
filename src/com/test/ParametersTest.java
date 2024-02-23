package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	
	WebDriver driver;
	@Test
	@Parameters({"URL", "EmailID"})
	public void YahooLoginTest(String URL, String EmailID) {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='login-username']")).clear();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(EmailID);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		
	}
	
	

}
