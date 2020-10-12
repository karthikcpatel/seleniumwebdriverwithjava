package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTestOnChrome {
public static void main(String args[]) {
	WebDriver driver;
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_85.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.close();
}
}