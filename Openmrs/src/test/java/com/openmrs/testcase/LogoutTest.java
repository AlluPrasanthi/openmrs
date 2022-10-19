package com.openmrs.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openmrs.libs.TestBase;
import com.openmrs.pages.LoginPage;
import com.openmrs.pages.LogoutPage;

public class LogoutTest extends TestBase {

	LogoutPage logoutPage;
	LoginPage loginPage;
	// HomePage homePage;

	public LogoutTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		logoutPage = new LogoutPage();
	}

	/*
	 * @Test(priority = 3) public void loginPageTitleTest() { String title =
	 * loginPage.validateLoginPageTitle(); Assert.assertEquals(title, "Home"); }
	 */

	@Test
	public void logoutOpenMRS() {
		loginPage = logoutPage.validateLogoutPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
