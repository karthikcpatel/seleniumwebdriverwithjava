package pomframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyLoginPage {
		@Test
		public void verifyLogin() 
		{
			WebDriver driver;
			String path = System.getProperty("user.dir");
			String driverpath = path + "\\drivers\\chromedriver_83.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
			driver.get("http://live.demoguru99.com/index.php/");
			LoginPage login = new LoginPage(driver);
			login.accountBeforeLogin();
			login.loginLink();
			login.emailAddress();
			login.password();
			login.loginButton();
			login.accountAfterLogin();
			login.logout();
			driver.close();
		}
}