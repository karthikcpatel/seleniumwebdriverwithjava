package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropDown {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement dropdownclick = driver.findElement(By.id("carselect"));
		Select dropdown = new Select(dropdownclick);
		dropdown.selectByVisibleText("Honda");
		Thread.sleep(3000);
		dropdown.selectByIndex(0);
		Thread.sleep(3000);
		dropdown.selectByValue("benz");
		Thread.sleep(3000);
		driver.close();
	}
}
