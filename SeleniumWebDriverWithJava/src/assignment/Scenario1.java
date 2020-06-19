package assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario1 {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_83.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		WebElement selectPhone = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", selectPhone);
		WebElement clickCheckout = driver.findElement(By.xpath("(//span[text()='Proceed to Checkout'])[1]"));
		executor.executeScript("arguments[0].click();", clickCheckout);
		WebElement clickContinue = driver.findElement(By.xpath("(//span[text()='Continue'])[1]"));
		executor.executeScript("arguments[0].click();", clickContinue);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='billing:firstname']")).sendKeys("Kartik");
		driver.findElement(By.xpath("//input[@id='billing:lastname']")).sendKeys("Patel");
		driver.findElement(By.xpath("//input[@id='billing:email']")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//input[@id='billing:street1']")).sendKeys("A/27, Pushpak Tenaments");
		driver.findElement(By.xpath("//input[@id='billing:city']")).sendKeys("A/27, Pushpak Tenaments");
		WebElement selectState = driver.findElement(By.id("billing:region_id"));
		Select dropdown = new Select(selectState);
		dropdown.selectByVisibleText("California");
		driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys("90201");
		WebElement selectCountry = driver.findElement(By.id("billing:country_id"));
		Select dropdown1 = new Select(selectCountry);
		dropdown1.selectByVisibleText("United States");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys("1-541-754-3010");
		WebElement clickContinue2 = driver.findElement(By.xpath("(//span[text()='Continue'])[2]"));
		executor.executeScript("arguments[0].click();", clickContinue2);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		WebElement clickContinueCout = driver.findElement(By.xpath("(//span[text()='Continue'])[4]"));
		executor.executeScript("arguments[0].click();", clickContinueCout);
		driver.findElement(By.xpath("//input[@value='checkmo']")).click();
		WebElement clickContinueCout1 = driver.findElement(By.xpath("(//span[text()='Continue'])[5]"));
		js.executeScript("window.scrollBy(0,100)");
		executor.executeScript("arguments[0].click();", clickContinueCout1);
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		String orderText = driver.findElement(By.xpath("(//h2[@class='sub-title']//following-sibling::p)[1]")).getText();
		System.out.println(orderText);
		driver.close();
	}
}