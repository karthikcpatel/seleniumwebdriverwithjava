package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_83.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement cartElement = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", cartElement);
		Thread.sleep(3000);
		WebElement checkout = driver.findElement(By.xpath("//div[@class='clearfix']//following::a[@title='Proceed to checkout']"));
		executor.executeScript("arguments[0].click();", checkout);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		WebElement fcheckout = driver.findElement(By.xpath("(//div[@class='clearfix']//following::a[@title='Proceed to checkout'])[2]"));
		executor.executeScript("arguments[0].click();", fcheckout);
		Thread.sleep(4000);
		driver.close();
	}
}