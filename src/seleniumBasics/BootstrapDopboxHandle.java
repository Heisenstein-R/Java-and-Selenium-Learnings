package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootstrapDopboxHandle {

	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);

		driver.manage().window().maximize();

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class = 'multiselect-container dropdown-menu']//li//a//label"));

		System.out.println(list.size());

		// for selecting all the elements

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().equals("Web Development") || list.get(i).getText().equals("Programming Languages")
					|| list.get(i).getText().equals("Databases")) {
				list.get(i).click();
			}
		}

//		for (int i =0; i<list.size(); i++) {
//		 System.out.println(list.get(i).getText());
//		
//		if(list.get(i).getText().equals("Java")) {
//			list.get(i).click();
//			break;
//		}
//	}

	}

}
