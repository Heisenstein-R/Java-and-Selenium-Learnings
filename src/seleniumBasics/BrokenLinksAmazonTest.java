package seleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrokenLinksAmazonTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.yahoo.com/");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));

		System.out.println("Number of the links are: " +linkslist.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i =0; i<linkslist.size(); i++) {
			System.out.println(linkslist.get(i).getAttribute("href"));
			if(linkslist.get(i).getAttribute("href") != null && !( linkslist.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkslist.get(i));
			}
		}
		
		System.out.println("Number of active links are: " +activeLinks.size());
		
		for (int j=0; j<activeLinks.size(); j++) {
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			//connection.setConnectTimeout(3000);
			connection.connect();
			String response = connection.getResponseMessage();
			
			if(response.equals("OK")) {
				System.out.println(activeLinks.get(j).getAttribute("href")+"  ====>  "+ response);
			}
			connection.disconnect();
		}
		
	}

}
