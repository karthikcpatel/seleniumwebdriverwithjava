package testng;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ParallelTest {
WebDriver driver;
@Test
@Parameters("browser")
public void pageTitle(String browserName){
	if(browserName.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.firefox.marionette", "C:/eclipse/drivers/geckodriver_0.24.exe");
		driver = new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("ie")){
		System.setProperty("webdriver.ie.driver", "C:/eclipse/drivers/IEDriverServer_2.40.exe");
		driver = new InternetExplorerDriver();
	}
	else if(browserName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:/eclipse/drivers/chromedriver_83.exe");
		driver = new ChromeDriver();
	}	
	driver.manage().window().maximize();
	driver.get("https://www.google.co.in/");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String title = driver.getTitle();
	System.out.println(title);
	driver.quit();
}
}