package seleniumBasics;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RedbusDate {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.navigate().to("https://www.redbus.in/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().window().maximize();
		  
		  //This will select From date 
		  WebElement elementFromDate = driver.findElement(By.id("onward_cal"));
		  ((JavascriptExecutor)driver).executeScript ("document.getElementById('onward_cal').removeAttribute('readonly',0);"); // Enables the from date box
		  elementFromDate.clear();
		  elementFromDate.sendKeys("Date 18 Nov 2023"); //Enter date in required format

	}

}
