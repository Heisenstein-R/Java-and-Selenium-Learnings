package seleniumBasics;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcepts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		
		System.out.println(linkslist.size());
		
		
		
		for(int i=0; i < linkslist.size(); i++) {
			
			System.out.println(linkslist.get(i).getText());
			
		}
		
		
		

	}

}
