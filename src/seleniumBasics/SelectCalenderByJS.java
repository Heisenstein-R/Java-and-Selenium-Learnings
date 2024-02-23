package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCalenderByJS {

	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement dateElement = driver.findElement(By.xpath("//*[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']"));
		WebElement sendLoc = driver.findElement(By.xpath(
				"//*[@class = 'css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//input[@value = 'Select Destination']"));
		// sendLoc.sendKeys("del");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		sendLoc.sendKeys("del");
		String sdate = "Thu, 30 Nov 2023";
		String edate = "Tue, 5 Dec 2023";

		selectDateByJS(driver, dateElement, sdate);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// selectDateByJS(driver, dateElement, edate);
		driver.findElement(By.xpath("//*[@class = 'css-1dbjc4n r-1loqt21 r-1otgn73']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean isdisplayed = driver
				.findElement(By.xpath("//*[@class = 'css-1dbjc4n']//div[contains(text(), 'Search Flight')]"))
				.isDisplayed();
		System.out.println("element diaplayed?:: " + isdisplayed);

		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class = 'css-1dbjc4n']//div[contains(text(), 'Search Flight')]")))
				.click();

		// driver.findElement(By.xpath("//*[@class =
		// 'css-1dbjc4n']//div[contains(text(), 'Search Flight')]")).click();

	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + dateVal + "')", element);
		js.executeScript("arguments[0].innerText='" + dateVal + "'", element);

		String dt = element.getText();
		System.out.println(dt);

	}
}
