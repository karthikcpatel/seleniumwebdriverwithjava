package testng;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parameterized_DataDriven_GCC {
	WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	
	@BeforeMethod
	public void beforeMethod() {
	String path = System.getProperty("user.dir");
	String driverpath = path + "\\drivers\\chromedriver_84.exe";
	System.setProperty("webdriver.chrome.driver", driverpath);
	//driver = new ChromeDriver();
	//driver.get("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception {
//		driver.get("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try {
		File src = new File("C:\\eclipse\\testdata\\gcc_keydoc.xlsx");
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheetAt(0);
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			{
				driver = new ChromeDriver();
				driver.get("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver,300);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']//following::span[text()='SIGN IN']")));
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vishal_matere");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("May_2016!");
				driver.findElement(By.xpath("//button[@type='submit']//following::span[text()='SIGN IN']")).click();
				driver.navigate().to("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create New Article']")));
				driver.findElement(By.xpath("//div[contains(@class,'x-tab-panel-header')]//descendant::span[contains(@class,'search-icon')]")).click();
				driver.findElement(By.xpath("//button[text()='Add to filter']")).click();
				driver.findElement(By.xpath("//input[@name='KeyDoc']")).click();
				cell = sheet.getRow(i).getCell(0);
				cell.setCellType(CellType.STRING);
				driver.findElement(By.xpath("//input[@name='KeyDoc']")).sendKeys(cell.getStringCellValue());
				driver.findElement(By.xpath("//input[@name='KeyDoc']")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//button[text()='Search']")).click();
				Thread.sleep(3000);
				driver.close();
			}
		}
		catch(Exception e)
		{System.out.println(e);}
		finally
		{
		 System.out.println("finally block is always executed");
		}  
		 System.out.println("rest of the code...");   
	}

	@AfterMethod
	public void afterMethod() throws Exception {
	Thread.sleep(2000);
	//driver.quit();	
	}
}