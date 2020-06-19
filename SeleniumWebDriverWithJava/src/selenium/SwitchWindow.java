package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_81.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.manage().window().maximize();
		String winHandleBefore = driver.getWindowHandle();
		System.out.println(winHandleBefore);
		driver.findElement(By.xpath("(//div[text()='Click this link to launch another window'])[1]")).click();
		for(String winHandleAfter : driver.getWindowHandles()){
			//System.out.println(winHandleBefore);
			//System.out.println(winHandleAfter);
			driver.switchTo().window(winHandleAfter);
		}
		WebElement window2T = driver.findElement(By.xpath("//p[@id='popuptext']"));
		System.out.println("" +window2T.getText());
		driver.findElement(By.xpath("//p[@id='closepopup']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(winHandleBefore);
		driver.close();
	}
}
