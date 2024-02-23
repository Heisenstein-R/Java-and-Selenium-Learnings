package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("rog phone 2");
		Thread.sleep(2000);
		
		//Should use findelements to get a list of webelements
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role ='listbox']//li"));
		
		System.out.println("total number pf elements::===> " +list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("rog phone 2 processor")) {
				list.get(i).click();
				break;
			}
			
		}
		
		

	}

}
