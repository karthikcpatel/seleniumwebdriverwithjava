package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunTestOnChrome {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_85.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
	driver.get("https://www.google.com");	
	driver.manage().window().maximize();	
	}
	
	@AfterMethod
	public void afterMethod() {
	driver.close();	
	}
}