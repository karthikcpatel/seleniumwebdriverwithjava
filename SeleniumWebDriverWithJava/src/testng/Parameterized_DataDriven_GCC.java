package testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parameterized_DataDriven_GCC {
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeMethod
	public void beforeMethod() {
		String path = System.getProperty("user.dir");
		String driverpath = path + "\\drivers\\chromedriver_85.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();

		// QA
//		driver.get("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		wait = new WebDriverWait(driver, 300);
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//button[@type='submit']//following::span[text()='SIGN IN']")));
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vishal_matere");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("May_2016!");
//		driver.findElement(By.xpath("//button[@type='submit']//following::span[text()='SIGN IN']")).click();
//		driver.navigate().to("http://gcc-cld-dev.midevcld.spglobal.com/gcc-flex/index.html");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create New Article']")));

		// Production
		driver.get("http://gcc-cld-prd.marketintelligence.spglobal.com/gcc-flex/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@type='submit' and @value = 'SIGN IN']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vishal_matere");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SPGlobal123$");
		driver.findElement(By.xpath("//input[@type='submit' and @value = 'SIGN IN']")).click();
		driver.navigate().to("http://gcc-cld-prd.marketintelligence.spglobal.com/gcc-flex/index.html");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create New Article']")));

	}

	@Test
	public void test() throws Exception {
		try {

			performOprationBasedOnSelection pobos = new performOprationBasedOnSelection();
			File src = new File("C:\\eclipse\\testdata\\gcc_inarticle_images.xlsx");
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			int endPoint = 1;

			int startingPoint = pobos.getStartingPoint(sheet);

			if (startingPoint >= 1) {

				for (int i = startingPoint; i <= sheet.getLastRowNum(); i++) {

					System.out.println(
							"--------------------------------------- ********** -----------------------------------------");
					System.out.println("Row No in sheet: " + (i+1));
					
					cell = sheet.getRow(i).getCell(0);
					cell.setCellType(CellType.STRING);
					cell.setCellStyle(cellStyle);
					String articleKeyDoc = cell.getStringCellValue();
					System.out.println("Article KeyDoc: " + articleKeyDoc);

					pobos.searchArticle(driver, articleKeyDoc);

					Thread.sleep(3000);

					cell = sheet.getRow(i).getCell(1);
					cell.setCellType(CellType.STRING);
					cell.setCellStyle(cellStyle);
					String processTobeDone = cell.getStringCellValue();
					System.out.println("Process type: " + processTobeDone);

					cell = sheet.getRow(i).getCell(2);
					cell.setCellType(CellType.STRING);
					cell.setCellStyle(cellStyle);
					String imageKeyfileOrKeydoc = cell.getStringCellValue();
					System.out.println("KeyFile Value: " + imageKeyfileOrKeydoc);

					String processResult;

					if (processTobeDone.equalsIgnoreCase("keyfile") || processTobeDone.equalsIgnoreCase("source")) {

						processResult = pobos.imageRemovalProcessUsingKeyFileOrSource(driver, imageKeyfileOrKeydoc.trim(),
								articleKeyDoc.trim(), processTobeDone.trim());

					} else {

						processResult = pobos.imageRemovalProcessUsingKeyDoc(driver, imageKeyfileOrKeydoc,
								articleKeyDoc);
					}

					System.out.println("Process Result: " + processResult);
					sheet.getRow(i).createCell(3).setCellValue(processResult);
					sheet.getRow(i).getCell(3).setCellStyle(cellStyle);
					fis.close();

					FileOutputStream fos = new FileOutputStream(src);
					workbook.write(fos);
					fos.close();

					System.out.println("Article Process No: " + endPoint);
					if (endPoint == 100) {
						break;
					}
					endPoint++;
				}
			} else {

				System.out.println(
						"--------------------------------------- ********** -----------------------------------------");
				System.out.println("No New Records Found in Sheet..!!");
			}

			driver.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finally block is always executed");
		}
		System.out.println("rest of the code...");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(2000);
	}
}