package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionInTestNG {
	@Test
	public void softAssert() {
		SoftAssert assertion = new SoftAssert();
		System.out.println("Test 1 started");
		assertion.assertEquals(12, 13);
		System.out.println("Test 1 completed");
		assertion.assertAll();
	}
	@Test
	public void hardAssert() {
		System.out.println("Test 2 started");
		Assert.assertEquals(12, 13);
		System.out.println("Test 2 completed");
	}
}