package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyElements {

	
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://echarts.apache.org/examples/en/index.html");

		driver.manage().window().maximize();

		

		try {
			WebElement element = driver.findElement(By.xpath("//a[text() = 'Hom']"));

			if (element.isDisplayed()) {
				System.out.println("Element is Displayed");
			} else {
				System.out.println("Element is not Displayed");
			}

		} catch (Exception e) {
			
			System.out.println("Element not found");
		}
		
		System.out.println("jnakcna");
		driver.get(driver.getCurrentUrl());
		driver.close();
		
	}
	
	
}
