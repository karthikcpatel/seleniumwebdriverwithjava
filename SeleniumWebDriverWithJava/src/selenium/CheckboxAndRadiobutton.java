package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAndRadiobutton {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
		driver.findElement(By.xpath("(//legend[text()='Radio Button Example']//following-sibling::label//descendant::input)[1]")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
