package testng;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority=3)
	public void sendEmail()
	{
		System.out.println("Send email after login");
	}
	@Test(priority=2)
	public void login()
	{
		System.out.println("Login to the account after registration");
	}
	@Test(priority=1)
	public void registerAccount()
	{
		System.out.println("First register your account");
	}

}