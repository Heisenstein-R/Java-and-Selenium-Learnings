package seleniumBasics;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTable2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notiffications");
		op.addExtensions(new File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\Extensions\\adblock.crx"));
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		driver.findElement(By.xpath("//*[contains(text(), 'Afghanistan')]/parent::td//preceding-sibling::td//input[@class = 'hasVisited']")).click();
		
		

	}

}
