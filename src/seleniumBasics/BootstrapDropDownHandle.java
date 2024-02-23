package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDropDownHandle {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();

		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button[contains(text(), 'Dropdown button')]")));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Actions actions = new Actions(driver);
		//actions.moveToElement(driver.findElement(By.xpath("//button[@id = 'dropdownMenuButton' and @class = 'btn btn-secondary dropdown-toggle']"))).build().perform();
		driver.findElement(By.xpath("//button[@id = 'dropdownMenuButton' and @class = 'btn btn-secondary dropdown-toggle']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'dropdown-menu show']//a"));
		
		System.out.println(list.size());
		
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
			}
			
		}
		
	}

}
