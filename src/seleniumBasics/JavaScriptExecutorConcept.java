package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;


public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();

		driver.get("https://accounts.spotify.com/en/login?continue=https%3A%2F%2Fopen.spotify.com%2F%3F");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		WebElement srchBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]/span[1]")); 
		flash(srchBtn, driver);
		
		drawBorder(srchBtn, driver);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\SleniumBasics\\Bug.png");
		FileHandler.copy(src, dest);
		
		//generateAlert("There is an issue with the login button", driver);
		
		
		clickElementByJS(srchBtn, driver);
		
		Thread.sleep(3000);
		
		refreshBrowserByJS(driver);
		
		System.out.println(getTitleByJS(driver));
		
		System.out.println(getPageInnerText(driver));
		
		//pageScrollDown(driver);
		
		WebElement SignUpLink = driver.findElement(By.xpath("//*[@id='sign-up-link']"));
		
		scrollIntoView(SignUpLink, driver);
		
	}
 
	public static void flash(WebElement element, WebDriver driver) {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(255, 255, 255)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].style.backgroundColor = '" + color + "'" + element);
		js.executeScript("arguments[0].setAttribute('style', 'background: "+color+";');", element);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {

		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;')", element);
		
	}
	
	public static void generateAlert(String message, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
		
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String getTitle = js.executeScript("return document.title;").toString();
		return getTitle;
	}
	
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String getInnerText = js.executeScript("return document.documentElement.innerText;").toString();
		return getInnerText;
	}
	
	public static void pageScrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
