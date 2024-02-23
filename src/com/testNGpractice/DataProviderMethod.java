package com.testNGpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMethod {
	
	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test(dataProvider = "provider", threadPoolSize = 3)
	public void LoginCheckWith(String Username, String Password) {
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean b = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		Assert.assertTrue(b);
		
		System.out.println("Threead num is: "+Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void CloseTheBrowser() {
		
		driver.quit();
	}
	
	@DataProvider(name = "provider")
	public Object[][] provide(){
		return new Object[][] {{"Admin", "admin123"}, {"Raju", "raju123"}, {"chitti", "chitti123"}};
	}
}
