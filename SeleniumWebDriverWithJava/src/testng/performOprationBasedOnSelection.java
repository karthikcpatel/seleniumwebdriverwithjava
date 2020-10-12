package testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class performOprationBasedOnSelection extends Parameterized_DataDriven_GCC {

	public int getStartingPoint(XSSFSheet sheet) {

		int startingPoint = 0;

		for (int j = 0; j <= sheet.getLastRowNum(); j++) {

			cell = sheet.getRow(j).getCell(3);

			if (cell == null) {

				startingPoint = j;
				break;
			}
		}

		return startingPoint;
	}

	public String getArticleQueueDetails(WebDriver driver) {

		String articleQueue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[8]/div)[1]"))
				.getText();

		return articleQueue;

	}

	public void searchArticle(WebDriver driver, String articleKeyDoc) {

		driver.findElement(By.xpath(
				"//div[contains(@class,'x-tab-panel-header')]//descendant::span[contains(@class,'search-icon')]"))
				.click();
		driver.findElement(By.xpath("//button[text()='Reset']")).click();
		driver.findElement(By.xpath("//button[text()='Add to filter']")).click();
		driver.findElement(By.xpath("//input[@name='KeyDoc']")).click();
		driver.findElement(By.xpath("//input[@name='KeyDoc']")).sendKeys(articleKeyDoc);
		driver.findElement(By.xpath("//input[@name='KeyDoc']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Search']")).click();

	}

	public boolean checkArticleVisiblityAndAvailability(WebDriver driver) {

		boolean articleAvailability = driver
				.findElements(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[6])[1]")).size() > 0;

		if (articleAvailability == true) {

			boolean articleVisiblity = driver
					.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[6])[1]")).isDisplayed();

			if (articleVisiblity == true) {

				return true;
			}

		}

		return false;

	}

	public void takeOwnershipProcess(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);
		boolean popupAvailability = driver.findElements(By.xpath("//span[text() = 'TAKE OWNERSHIP']")).size() > 0;

		if (popupAvailability == true) {

			boolean popupVisiblity = driver.findElement(By.xpath("//span[text() = 'TAKE OWNERSHIP']")).isDisplayed();

			if (popupVisiblity == true) {

				driver.findElement(By.xpath("//button[text() = 'OK']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text() = 'Take Ownership']")).click();
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='editor-status-saved']")));

			}
		}

	}

	public String imageRemovalProcessUsingKeyFileOrSource(WebDriver driver, String imageKeyfileOrKeydoc,
			String articleKeyDoc, String processTobeDone) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String operationResult = "";
		try {

			boolean articleAvailablityOrVisiblity = checkArticleVisiblityAndAvailability(driver);

			if (articleAvailablityOrVisiblity == true) {

				String articleQueue = getArticleQueueDetails(driver);

				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[6])[1]")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//*[text()='Body']//parent::div//following-sibling::div//descendant::iframe[contains(@id,'ext-comp')]")));

				takeOwnershipProcess(driver);

				Thread.sleep(3000);

				disableAutoSave(driver);

				Thread.sleep(2000);

				if (articleQueue.equalsIgnoreCase("DELIVERED")
						|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

					moveArticleToEditorsQueue(driver, articleKeyDoc);
					Thread.sleep(2000);
					disableAutoSave(driver);
				}

				WebElement getIdOfDiv = driver.findElement(By.xpath(
						"//div[contains(@class,'gccDateTime')]/../../../parent::div[contains(@class,'x-panel-body-noheader')]"));
				String idOfDiv = getIdOfDiv.getAttribute("id");
				js.executeScript("$('#" + idOfDiv + "').animate({ scrollTop: '400px'})");

				Thread.sleep(3000);

				WebElement iframe = driver.findElement(By.xpath(
						"//*[text()='Body']//parent::div//following-sibling::div//descendant::iframe[contains(@id,'ext-comp')]"));

				String iframeId = iframe.getAttribute("id");

				driver.switchTo().frame(iframe);

				boolean keyFileAvailability;
				String typeOfDom = "";

				if (processTobeDone.equalsIgnoreCase("keyfile")) {

					typeOfDom = "p";

					keyFileAvailability = driver
							.findElements(By.xpath(
									"//body[@id='tinymce']//a[contains (@href, '" + imageKeyfileOrKeydoc + "')]"))
							.size() > 0;

				} else {

					typeOfDom = typeOfImageDomStructure(driver, imageKeyfileOrKeydoc);

					if (!(typeOfDom.equalsIgnoreCase("") || typeOfDom == null)) {

						keyFileAvailability = driver.findElements(By.xpath("//body[@id='tinymce']//descendant::"
								+ typeOfDom + "//*[contains(text(), '" + imageKeyfileOrKeydoc + "')]")).size() > 0;

					} else {

						keyFileAvailability = false;
						driver.switchTo().defaultContent();
                        clickOnSaveButton(driver);
                        Thread.sleep(2000);
                        deliveredQueueArticles(driver);
					}

				}

				if (keyFileAvailability == true) {

					WebElement imageToRemove;

					if (processTobeDone.equalsIgnoreCase("keyfile")) {

						imageToRemove = driver.findElement(
								By.xpath("//body[@id='tinymce']//a[contains (@href, '" + imageKeyfileOrKeydoc + "')]"));

					} else {

						if (typeOfDom.equalsIgnoreCase("table")) {

							imageToRemove = driver.findElement(By
									.xpath("//body[@id='tinymce']//descendant::" + typeOfDom + "//*[contains(text(), '"
											+ imageKeyfileOrKeydoc + "')]//ancestor::" + typeOfDom + ""));

						} else {

							imageToRemove = driver.findElement(By
									.xpath("//body[@id='tinymce']//descendant::" + typeOfDom + "//*[contains(text(), '"
											+ imageKeyfileOrKeydoc + "')]//parent::" + typeOfDom + ""));
						}

					}

					if (imageToRemove.isDisplayed() == true) {

						// js.executeScript("arguments[0].scrollIntoView(true);", imageToRemove);
						Thread.sleep(2000);
						Actions action = new Actions(driver);
						action.moveToElement(imageToRemove).click().build().perform();
						action.doubleClick().build().perform();
						driver.switchTo().defaultContent();
						driver.findElement(By.xpath("//iframe[@id = '" + iframeId
								+ "']/../following-sibling::div//div[@role = 'button' and text()='" + typeOfDom + "']"))
								.click();
						if (typeOfDom.equalsIgnoreCase("p")) {

							WebElement justifyButton = driver.findElement(By.xpath("//iframe[@id = '" + iframeId
									+ "']/../parent::div//div[@aria-label='Justify']/button"));
							action.doubleClick(justifyButton).build().perform();

						}
						driver.switchTo().frame(iframe);
						takeScreenShot(driver, articleKeyDoc);
						action.sendKeys(Keys.BACK_SPACE).build().perform();

						Thread.sleep(3000);

						driver.switchTo().defaultContent();

						takeScreenShot(driver, articleKeyDoc);

						clickOnSaveButton(driver);

						if (articleQueue.equalsIgnoreCase("DELIVERED")
								|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

							deliveredQueueArticles(driver);

						} else if (articleQueue.equalsIgnoreCase("COPY EDIT")
								|| articleQueue.equalsIgnoreCase("FACT CHECK")) {

							publishCopyEditOrFactCheckQueueArticle(driver);

						} else {

							clickOnCloseButton(driver);
						}

						operationResult = "Image Sucessfully Removed";

					} else {

						driver.switchTo().defaultContent();

						takeScreenShot(driver, articleKeyDoc);

						clickOnSaveButton(driver);

						if (articleQueue.equalsIgnoreCase("DELIVERED")
								|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

							deliveredQueueArticles(driver);

						} else {

							clickOnCloseButton(driver);
						}

						operationResult = "Image Not Available";
					}
				} else {

					takeScreenShot(driver, articleKeyDoc);
					operationResult = "Article Not Found";
				}

			}
		} catch (Exception e) {

			takeScreenShot(driver, articleKeyDoc);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			clickOnCloseButton(driver);
			operationResult = "Exception On Save";
			System.out.println(e);
		}

		return operationResult;

	}

	public String imageRemovalProcessUsingKeyDoc(WebDriver driver, String imageKeyfileOrKeydoc, String articleKeyDoc)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);
		String operationResult = "";
		try {

			boolean articleAvailablityOrVisiblity = checkArticleVisiblityAndAvailability(driver);

			if (articleAvailablityOrVisiblity == true) {

				String articleQueue = getArticleQueueDetails(driver);

				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[6])[1]")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//*[text()='Body']//parent::div//following-sibling::div//descendant::iframe[contains(@id,'ext-comp')]")));

				//takeOwnershipProcess(driver);

				Thread.sleep(3000);

				disableAutoSave(driver);

				Thread.sleep(2000);

				if (articleQueue.equalsIgnoreCase("DELIVERED")
						|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

					moveArticleToEditorsQueue(driver, articleKeyDoc);
					Thread.sleep(2000);
					disableAutoSave(driver);
				}

				WebElement imageToRemove = driver.findElement(By.xpath(
						"//span[text()='Home Page Image']/../..//textarea[contains(@class, 'homePageImageSection')]"));

				String idOfDiv = imageToRemove.getAttribute("id");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String homePageImageKeydoc = (String) js.executeScript("return $('#" + idOfDiv + "').val()");

				if (homePageImageKeydoc.trim().equalsIgnoreCase(imageKeyfileOrKeydoc)) {

					Actions action = new Actions(driver);
					action.moveToElement(imageToRemove).doubleClick().build().perform();
					action.sendKeys(Keys.BACK_SPACE).build().perform();

					Thread.sleep(3000);

					clickOnSaveButton(driver);

					if (articleQueue.equalsIgnoreCase("DELIVERED")
							|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

						deliveredQueueArticles(driver);

					} else if (articleQueue.equalsIgnoreCase("COPY EDIT")
							|| articleQueue.equalsIgnoreCase("FACT CHECK")) {

						publishCopyEditOrFactCheckQueueArticle(driver);

					} else {

						clickOnCloseButton(driver);
					}

					operationResult = "Image Sucessfully Removed";

				} else {

					driver.switchTo().defaultContent();

					clickOnSaveButton(driver);

					if (articleQueue.equalsIgnoreCase("DELIVERED")
							|| articleQueue.equalsIgnoreCase("DELIVERED CORRECTION")) {

						deliveredQueueArticles(driver);

					} else {

						clickOnCloseButton(driver);
					}

					operationResult = "Image Not Available";
				}
			} else {

				operationResult = "Article Not Found";
			}

		} catch (Exception e) {

			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
			clickOnCloseButton(driver);
			operationResult = "Exception On Save";
			System.out.println(e);
		}

		return operationResult;

	}

	public void moveArticleToEditorsQueue(WebDriver driver, String articleKeyDoc) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='More']")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Back to Editor']")).click();
		Thread.sleep(5000);

		String articleQueueCheck = getArticleQueueDetails(driver);
		while (!(articleQueueCheck.equalsIgnoreCase("EDITORIAL CORRECTION"))) {

			driver.findElement(By.xpath("//button[text()='Search']")).click();
			Thread.sleep(10000);
			articleQueueCheck = getArticleQueueDetails(driver);
		}

		Thread.sleep(3000);

		searchArticle(driver, articleKeyDoc);

		boolean articleAvailablityOrVisiblity = checkArticleVisiblityAndAvailability(driver);

		String articleQueue = getArticleQueueDetails(driver);

		if (articleAvailablityOrVisiblity == true && articleQueue.equalsIgnoreCase("EDITORIAL CORRECTION")) {

			driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//tr//td[6])[1]")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//*[text()='Body']//parent::div//following-sibling::div//descendant::iframe[contains(@id,'ext-comp')]")));

		}

	}

	public void deliveredQueueArticles(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);

		boolean snlErrorAvailability = driver
				.findElements(By.xpath("//span[text()='SNL Errors']/..//div//following-sibling::img")).size() > 0;

		if (snlErrorAvailability == true) {

			boolean snlErrorVisiblity = driver
					.findElement(By.xpath("//span[text()='SNL Errors']/..//div//following-sibling::img")).isDisplayed();

			if (snlErrorVisiblity == true) {

				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='SNL Errors']/..//div//following-sibling::img")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='checkbox']/../../..//label[contains(text(),'Override:')]"))
						.click();
				Thread.sleep(2000);
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='More']")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(5000);

		String articleQueue = getArticleQueueDetails(driver);
		while (!(articleQueue.equalsIgnoreCase("DELIVERED") || articleQueue.equalsIgnoreCase("DELIVERED CORRECTION"))) {

			driver.findElement(By.xpath("//button[text()='Search']")).click();
			Thread.sleep(10000);
			articleQueue = getArticleQueueDetails(driver);
		}

	}

	public String typeOfImageDomStructure(WebDriver driver, String sourceName) {

		String typeOfDom = "";
		boolean checkTableFormateAvailablity = driver
				.findElements(
						By.xpath("//body[@id='tinymce']//descendant::table//*[contains(text(), '" + sourceName + "')]"))
				.size() > 0;

		if (checkTableFormateAvailablity == true) {

			boolean checkTableFormateVisiblity = driver
					.findElement(By.xpath(
							"//body[@id='tinymce']//descendant::table//*[contains(text(), '" + sourceName + "')]"))
					.isDisplayed();

			if (checkTableFormateVisiblity == true) {

				typeOfDom = "table";
			}

		} else {

			boolean checkPFormateAvailablity = driver
					.findElements(
							By.xpath("//body[@id='tinymce']//descendant::p//*[contains(text(), '" + sourceName + "')]"))
					.size() > 0;

			if (checkPFormateAvailablity == true) {

				boolean checkPFormateVisiblity = driver
						.findElement(By.xpath(
								"//body[@id='tinymce']//descendant::p//*[contains(text(), '" + sourceName + "')]"))
						.isDisplayed();

				if (checkPFormateVisiblity == true) {

					typeOfDom = "p";

				}
			}

		}

		return typeOfDom;

	}

	public void clickOnCloseButton(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//table[@class='x-table-layout']//tbody//descendant::button[text()='Close']")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@class='x-table-layout']//tbody//descendant::button[text()='Close']"))
				.click();
	}

	public void clickOnSaveButton(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//table[@class='x-table-layout']//tbody//descendant::button[text()='Save']")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@class='x-table-layout']//tbody//descendant::button[text()='Save']"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='editor-status-saved']")));
	}

	public void disableAutoSave(WebDriver driver) {

		boolean checkAutoSaveOptionAvailablity = driver.findElements(By.xpath(
				"//div[text()='Auto Save']/../..//input[@type = 'checkbox' and contains(@class,'status-bar-auto-save')]"))
				.size() > 0;

		if (checkAutoSaveOptionAvailablity == true) {

			boolean checkAutoSaveOptionVisiblity = driver.findElement(By.xpath(
					"//div[text()='Auto Save']/../..//input[@type = 'checkbox' and contains(@class,'status-bar-auto-save')]"))
					.isDisplayed();

			if (checkAutoSaveOptionVisiblity == true) {

				boolean checkedStatusOfAutoSave = driver.findElement(By.xpath(
						"//div[text()='Auto Save']/../..//input[@type = 'checkbox' and contains(@class,'status-bar-auto-save')]"))
						.isSelected();

				if (checkedStatusOfAutoSave == true) {

					driver.findElement(By.xpath(
							"//div[text()='Auto Save']/../..//input[@type = 'checkbox' and contains(@class,'status-bar-auto-save')]"))
							.click();
				}

			}

		}

	}

	public void publishCopyEditOrFactCheckQueueArticle(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 300);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='More']")));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Publish']")).click();
		Thread.sleep(2000);

		boolean popupDisplay = driver.findElement(By.xpath("//span[text() = 'Confirm Article Publish']")).isDisplayed();

		if (popupDisplay == true) {

			driver.findElement(
					By.xpath("//div[@class='x-shadow']//following-sibling::div//following::button[text()='Yes']"))
					.click();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='editor-status-saved']")));

		clickOnCloseButton(driver);

	}

	public void takeScreenShot(WebDriver driver, String articleKeyDoc) throws Exception {

		String timeStamp = new SimpleDateFormat("(yyyy-MM-dd)_(HH-mm-ss)").format(new Date());
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File(
				"C:\\eclipse\\testdata\\ScreenShot_InArticleImage\\" + articleKeyDoc + "_" + timeStamp + ".png"));
	}

}
