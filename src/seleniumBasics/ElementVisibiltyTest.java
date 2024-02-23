package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementVisibiltyTest {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		boolean b1 = driver.findElement(By.xpath("//button[contains(text(), 'Home')]")).isDisplayed();
		System.out.println(b1);
		
		boolean b2 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		System.out.println(b2);
		
		driver.findElement(By.id("checkBoxOption1")).click();
		boolean b3 = driver.findElement(By.id("checkBoxOption1")).isSelected();
		System.out.println(b3);
		
		

	}

}
