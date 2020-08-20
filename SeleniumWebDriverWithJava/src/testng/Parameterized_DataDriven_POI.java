package testng;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parameterized_DataDriven_POI {
	WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	
	@BeforeMethod
	public void beforeMethod() {
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_84.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws Exception {
		driver.get("http://live.demoguru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File src = new File("C:\\eclipse\\testdata\\parameterized_login.xlsx");
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(0);
		for(int i=0; i<=sheet.getLastRowNum(); i++){
			driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(cell.getStringCellValue());
			driver.findElement(By.xpath("//button[@id='send2']")).click();
			driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		}
	}

	@AfterMethod
	public void afterMethod() throws Exception {
	Thread.sleep(6000);
	driver.close();	
	}
}