package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C://Users//91938//OneDrive//Documents//Chromedriver//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		//System.out.println(alert.getText());
		String text = alert.getText();
		alert.accept();
		
		
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		} 
		else {
			System.out.println("Wrong alert");
		}
		
		//alert.dismiss(); in case of dismiss
		
		driver.quit();
		
		
		
		
		

	}

}
