package seleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadPropertyFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\SleniumBasics\\Feed.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));
		
		String url = prop.getProperty("url");
		
		String b = prop.getProperty("browser");
		
		if(b.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(b.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		
		
	}

}
