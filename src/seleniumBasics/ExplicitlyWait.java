package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.amazon.in");

		ExplicitlyWaitAndClick(driver, driver.findElement(By.xpath("//*[text() = 'Hello, sign in']")),
				Duration.ofSeconds(30));
		
		driver.findElement(By.className("a-expander-prompt")).click();

		ExplicitlyWaitAndClick(driver, driver.findElement(By.xpath("//a[contains(text(), \"Forgot Password\")]")),
				Duration.ofSeconds(30));

	}

	public static void ExplicitlyWaitAndClick(WebDriver driver, WebElement locator, Duration timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
