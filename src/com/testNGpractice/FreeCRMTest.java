package com.testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest {
	
	WebDriver driver;
	@BeforeMethod
	public void browser() {
		driver = new EdgeDriver();
		driver.get("https://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test
	public void logintest() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("rajbilieber.k@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Iamrajuk@1234");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//a//span[contains(text(), 'Log Out')]")).click();
	}

	
}
