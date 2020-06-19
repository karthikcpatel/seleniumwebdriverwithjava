package selenium;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
public static void main(String args[]) throws IOException {
	WebDriver driver;
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_81.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	driver.get("https://www.msn.com/en-in/");
	driver.manage().window().maximize();
	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotFile, new File("C:\\Users\\kartikp\\Downloads\\Screenshot.png"));
	driver.close();
}
}
