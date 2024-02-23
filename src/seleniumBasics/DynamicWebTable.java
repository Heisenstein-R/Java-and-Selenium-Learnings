package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTable {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notiffications");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[1]/a
		
		
		String before_xpath = "//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		String after_xpath = "]/td[1]/a";
		
		for(int i =2 ; i<10; i++) {
			String country = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(country);
			
			if(i==9) {
				//*[@id='leftcontainer']/table/tbody/tr[5]/td[1]/a
				//WebElement checkBox = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[5]/td[1]/a"));
				//ScrollToTheElement(driver, checkBox);
				driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" +i+ "]/td[1]/a")).click();
			}	
		}
	}
	
	/*public static void ScrollToTheElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}*/

}
