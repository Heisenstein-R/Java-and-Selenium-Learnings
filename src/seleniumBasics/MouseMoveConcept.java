
package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class MouseMoveConcept {

	public static void main(String[] args) throws InterruptedException {
	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		
		
		actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(), 'Add-ons')]"))).build().perform();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[contains(text(), 'Extra Seat')]")).click();
		
		
		
		
		
		
		
		
		

	}

}
