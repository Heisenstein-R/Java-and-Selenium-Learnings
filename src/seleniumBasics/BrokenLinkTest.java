package seleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v117.fetch.model.AuthChallengeResponse.Response;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://google.com/");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Number of Elements: " +linkslist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i =0; i<linkslist.size(); i++) {
			System.out.println(linkslist.get(i).getAttribute("href"));
			if(linkslist.get(i).getAttribute("href") != null) {
				activelinks.add(linkslist.get(i));
			}
		}
		System.out.println("Number of ActiveElements: " +activelinks.size());
		
		for (int j = 0; j< activelinks.size(); j++) {
			
			HttpURLConnection connection =(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activelinks.get(j).getAttribute("href") + " =====>   	" + response);
			
			
			
		}
		
	}

}
