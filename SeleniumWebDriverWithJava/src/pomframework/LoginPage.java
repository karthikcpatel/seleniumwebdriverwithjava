package pomframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By accountBeforeLogin = By.xpath("(//span[@class='label'])[3]");
	By loginLink = By.xpath("//a[contains(text(),'Log In')]");
	By emailAddress = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='pass']");
	By loginButton = By.xpath("//button[@id='send2']");
	By accountAfterLogin = By.xpath("//span[@class='label'][contains(text(),'Account')]");
	By logout = By.xpath("//a[contains(text(),'Log Out')]");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void accountBeforeLogin() {
		driver.findElement(accountBeforeLogin).click();
	}
	public void loginLink() {
		driver.findElement(loginLink).click();
	}
	public void emailAddress() {
		driver.findElement(emailAddress).sendKeys("testerkittu@gmail.com");
	}
	public void password() {
		driver.findElement(password).sendKeys("Netweb@123");
	}
	public void loginButton() {
		driver.findElement(loginButton).click();
	}
	public void accountAfterLogin() {
		driver.findElement(accountAfterLogin).click();
	}
	public void logout() {
		driver.findElement(logout).click();
	}
}