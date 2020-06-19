package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;  //downcasting in java
		js.executeScript("window.scrollBy(0,100)"); //first way
		Thread.sleep(8000);
		WebElement element = driver.findElement(By.xpath("//legend[text()='Element Displayed Example']"));
		js.executeScript("arguments[0].scrollIntoView();", element); //second way
		Thread.sleep(8000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //third way
		Thread.sleep(8000);
		driver.close();
	}
}