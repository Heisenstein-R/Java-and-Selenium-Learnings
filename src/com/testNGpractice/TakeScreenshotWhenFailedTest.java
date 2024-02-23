package com.testNGpractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenshotWhenFailedTest {

	WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo"
				+ ".orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void logincheck() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		boolean b = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test
	public void Test2() {
		driver.get("https://www.google.com");
		Assert.assertEquals(true, false);
	}

	@AfterMethod
	public void CloseTheBrowser(ITestResult result) throws IOException {
		if(result.FAILURE == result.getStatus()) {
			TakeAScreenshot(driver);
		}
		driver.quit();
	}
	
	public static void TakeAScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		File src = scrnshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\com\\testNGpractice\\Screenshotwhenfailed.png");
		FileHandler.copy(src, dest);
	}

}
