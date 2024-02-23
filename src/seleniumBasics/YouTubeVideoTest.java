package seleniumBasics;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YouTubeVideoTest {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		//WebDriver driver = new ChromeDriver(op);
		op.addExtensions(new File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\Extensions\\adblock.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, op);
		ChromeDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();

		driver.get("https://www.youtube.com/watch?v=j3xbO5zPj4g");
		
		
		Set<String> tabs = driver.getWindowHandles();
		
		Iterator<String> it = tabs.iterator();
		String ParentWindow = it.next();
		System.out.println("Parent window ID: "+ParentWindow);
		
		String ChildWindow = it.next();
		System.out.println("Parent window ID: "+ChildWindow);
		Thread.sleep(5000);
		driver.switchTo().window(ChildWindow).close();
		Thread.sleep(5000);
		
		Screen s = new Screen();
		
		
		
//		Pattern pauseImg = new Pattern("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\targets\\pause.png");
//		s.wait(pauseImg, 5000);
//		s.click();
//		s.click();
//		s.click();
		
//		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id = 'subscribe-button-shape']"))));
//		
		Pattern settingsImg = new Pattern("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\targets\\settings.png");
		s.wait(settingsImg, 5000);
		s.click();
		
		Pattern qualityImg = new Pattern("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\targets\\Video Quality.png");
		s.wait(qualityImg, 5000);
		s.click();
		
		Pattern resImg = new Pattern("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\targets\\720p.png");
		s.wait(resImg, 5000);
		s.click();
		
//		Pattern playImg = new Pattern("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\targets\\720p.png");
//		s.wait(playImg, 5000);
//		s.click();
	}

}
