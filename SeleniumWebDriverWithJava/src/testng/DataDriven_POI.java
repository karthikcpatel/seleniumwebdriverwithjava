package testng;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataDriven_POI {
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_85.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws Exception {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.manage().window().maximize();
		File src = new File("C:\\eclipse\\testdata\\login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(sheet1.getRow(0).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(sheet1.getRow(0).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		wb.close();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
	Thread.sleep(6000);
	driver.close();	
	}
}