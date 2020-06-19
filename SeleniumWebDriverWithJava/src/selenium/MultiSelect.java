package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {
	public static void main(String args[]) throws Exception {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select dropdown = new Select(driver.findElement(By.name("multiple-select-example")));
		dropdown.selectByVisibleText("Apple");
		Thread.sleep(3000);
		dropdown.selectByIndex(2);
		Thread.sleep(3000);
		dropdown.selectByValue("orange");
		Thread.sleep(3000);
		driver.close();
	}
}
