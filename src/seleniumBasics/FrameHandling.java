package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		driver.findElement(By.id("iFrame")).click();
		
		driver.switchTo().frame("globalSqa");
		Thread.sleep(5000);
		
		driver.findElement(By.id("mobile_menu_toggler")).click();
		
		
		
		
		

	}

}
