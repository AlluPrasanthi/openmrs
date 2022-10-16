package com.openmrs.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.openmrs.libs.TestBase;
import com.openmrs.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	//HomePage homePage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	/*@Test(priority = 3)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Home");
	}*/

	@Test(priority = 1)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Home");
		System.out.println(title);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}