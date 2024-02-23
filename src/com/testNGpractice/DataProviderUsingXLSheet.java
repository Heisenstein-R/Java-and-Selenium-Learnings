package com.testNGpractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingXLSheet {

	WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.wpeverest.com/user-registration/new-customer-registration-form/");

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		 ArrayList<Object[]> testData = UtilExcelSheetReader.getExcelData();
		 return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void formfillup(String title, String firstname, String lastname, String mail, String password, String phone,
			String gender, String address1, String address2, String city, String state, String country, String textarea,
			String yesorno) throws InterruptedException {
		WebElement TitleDropDown = driver.findElement(By.xpath("//select[@id='select_1665555058']"));
		Select selectTitle = new Select(TitleDropDown);
		selectTitle.selectByValue(title);

		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("last_name")).sendKeys(lastname);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_email")).sendKeys(mail);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='phone_1665556334']")).sendKeys(phone);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//ul//li[@class='ur-radio-list']//label[text() = '" + gender + "']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='input_box_1665556705']")).sendKeys(address1);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='input_box_1665556759904']")).sendKeys(address2);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='input_box_1665556812']")).sendKeys(city);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@data-label='State/Province']")).sendKeys(state);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement CountryField = driver.findElement(By.xpath("//select[@id='billing_country']"));
		Select countrySelect = new Select(CountryField);
		countrySelect.selectByVisibleText(country);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//textarea[@id='textarea_1665557189']")).sendKeys(textarea);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//ul//li[@class='ur-radio-list']//input[@value = '" + yesorno + "']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		boolean b = driver.findElement(By.xpath("//ul[text()='User successfully registered.']")).isDisplayed();
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void CloseTheBrowser() {
		driver.quit();
	}

}
