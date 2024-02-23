package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleBootstrapDropbox {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/signup/v2/createaccount?theme=glif&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@jsname='wSASue']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul//li[@role = 'option' and  @data-value]"));
		System.out.println(list.size());
		 
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("Melayu")){
				

				
				
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(list.get(i)));
//				new Actions(driver).moveToElement(list.get(i)).click().build().perform();
//				js.executeScript("arguments[0].click();", list.get(i));
//				new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
				list.get(i).click();
				break;
			}
			
		}
		

	}

}
