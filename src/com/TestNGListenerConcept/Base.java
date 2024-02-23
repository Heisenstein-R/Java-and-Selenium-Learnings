package com.TestNGListenerConcept;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	public static WebDriver driver;
	
	public void Initialization() {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
	
	public void failed(String MethodName) {
		try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\com\\TestNGListenerConcept\\"+MethodName+"_Failed.png"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
