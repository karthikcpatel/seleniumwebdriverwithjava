package assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario4 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_83.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 30);	
	driver.get("http://live.demoguru99.com/index.php/");	
	driver.manage().window().maximize();
	driver.findElement(By.xpath(".//*[@id='nav']/ol/li[1]/a")).click();
	wait.until(ExpectedConditions.titleContains("Mobile"));
	driver.findElement(By.xpath("(//a[text()='Add to Compare'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@title='Compare']")).click();
	Set<String> AllWindowHandles = driver.getWindowHandles();
	String window1 = (String) AllWindowHandles.toArray()[0];
	System.out.println("Window1 = "+AllWindowHandles.toArray()[0]);
    String window2 = (String) AllWindowHandles.toArray()[1];
	System.out.println("Window2 = "+AllWindowHandles.toArray()[1]);
	driver.switchTo().window(window2);
	wait.until(ExpectedConditions.titleContains("Products Comparison List - Magento Commerce"));
	driver.findElement(By.xpath(".//button[@title='Close Window']")).click();
	driver.switchTo().window(window1);
	}
	
	@AfterMethod
	public void afterMethod() {
	driver.close();	
	}
}