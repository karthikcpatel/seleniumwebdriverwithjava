package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		String tableText = driver.findElement(By.xpath("//table[@id='product']")).getText();
		System.out.println(tableText);
		Thread.sleep(2000);
		driver.close();
	}
}
