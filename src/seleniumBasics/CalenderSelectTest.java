package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//button[@aria-label = 'Open the date view']")).click();

		driver.findElement(By.xpath("//a[@role= 'button']//span[@class = 'k-button-text']")).click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@role= 'button']//span[@class = 'k-button-text']")).click();

//		driver.findElement(By.xpath(
//				"//a[@role = 'button']//span[@class = 'k-icon k-svg-icon k-svg-i-caret-alt-right k-button-icon']"))
//				.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		driver.findElement(By.xpath(
//				"//a[@role = 'button']//span[@class='k-icon k-svg-icon k-svg-i-caret-alt-left k-button-icon']"))
//				.click();

		String MMDDYYYY = "Jun-9-2022";
		String MMDDYY[] = MMDDYYYY.split("-");

		String mm = MMDDYY[0];
		String dd = MMDDYY[1];
		String yy = MMDDYY[2];

		// *[@class="k-widget k-calendar
		// k-calendar-md"]/div[2]/table/tbody/tr[1]/td[1]/a

		String beforeXpath = "//*[@class='k-widget k-calendar k-calendar-md']/div[2]/table/tbody/tr[";
		String afterXpath = "]/td[";
		boolean flag = false;

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 4; j++) {
				String year = driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]/a")).getText();
				System.out.println(year);

				if (year.equals(yy)) {
					driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]/a")).click();
					// *[@class="k-widget k-calendar
					// k-calendar-md"]/div[2]/table/tbody/tr[1]/td[1]/a
					for (int k = 1; k <= 3; k++) {
						for (int l = 1; l <= 3; l++) {
							String month = driver.findElement(By.xpath(beforeXpath + k + afterXpath + l + "]/a"))
									.getText();
							System.out.println(month);

							if (month.equals(mm)) {
								driver.findElement(By.xpath(beforeXpath + k + afterXpath + l + "]/a")).click();

								for (int m = 1; m <= 6; m++) {
									for (int n = 1; n <= 7; n++) {
										String day = driver
												.findElement(By.xpath(beforeXpath + m + afterXpath + n + "]/a"))
												.getText();
										System.out.println(day);

										if (day.equals(dd)) {
											driver.findElement(By.xpath(beforeXpath + m + afterXpath + n + "]/a"))
													.click();
											flag = true;
											break;
										}

									}
									if (flag) {
										break;
									}
								}
								if (flag) {
									break;
								}
								if (flag) {
									break;
								}
							}

						}
						if (flag) {
							break;
						}
					}
					if (flag) {
						break;
					}
				}

			}
			if (flag) {
				break;
			}
		}

	}

}
