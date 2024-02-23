package seleniumBasics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeaScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		// File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// File.copyFile(src, new
		// File("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\SleniumBasics\\google.png"));

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(
				"C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\SleniumBasics\\google.png");

		// Copy file at destination
		FileHandler.copy(SrcFile, DestFile);

	}

}
