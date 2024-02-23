package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("C://Users//91938//OneDrive//Documents//abc.txt");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
