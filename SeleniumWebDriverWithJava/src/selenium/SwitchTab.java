package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTab {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		for(String winHandleAfter : driver.getWindowHandles()){
		    driver.switchTo().window(winHandleAfter);
		}
		WebElement window2Text = driver.findElement(By.xpath("//a[@class='fedora-navbar-link navbar-link']"));
		System.out.println("" +window2Text.getText());
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(winHandleBefore);
		WebElement window1Text = driver.findElement(By.xpath("//legend[contains(text(),'Switch Tab Example')]"));
		System.out.println("" +window1Text.getText());
		driver.close();
	}
}
