package testng;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class UtilityClassForScreenshot {
	public static void captureScreenshot(WebDriver driver, String screenshotname) 
	{
		try
		{
			TakesScreenshot screenshot =(TakesScreenshot)driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("E MM.dd.yy hh-mm-ss a zzz");
			Calendar cal = Calendar.getInstance();
			FileUtils.copyFile(source, new File("./screenshots/"+dateFormat.format(cal.getTime())+".png"));
			System.out.println("Screenshot Taken");
			
		}catch(Exception excep)
		{
			System.out.println("Throwing exception while taking screenshot" +excep.getMessage());
		}
	}
}
