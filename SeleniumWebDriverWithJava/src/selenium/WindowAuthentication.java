package selenium;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuthentication {
public static void main(String args[])throws IOException {

	WebDriver driver;
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_83.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	System.setProperty("webdriver.chrome.silentOutput", "true");
	driver = new ChromeDriver();	
	driver.manage().window().maximize();
	Runtime.getRuntime().exec("C:\\eclipse\\autoit v3.3.14.2\\window.exe");
	driver.get("http://www.engprod-charter.net");
}
}
