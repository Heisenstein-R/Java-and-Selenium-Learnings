package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://nxtgenaiacademy.com/multiplewindows/");
		
		driver.findElement(By.id("button1")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String ParentWindow = it.next();
		System.out.println("Parent window ID: "+ParentWindow);
		
		String ChildWindow = it.next();
		System.out.println("Parent window ID: "+ChildWindow);
		
		driver.switchTo().window(ChildWindow);
		Thread.sleep(2000);
		
		driver.close(); //quits only specific instance of browser
		
		driver.switchTo().window(ParentWindow);
		Thread.sleep(2000);
		
		System.out.println("Parent window ID: "+ParentWindow);
		
		
;
	}

}
