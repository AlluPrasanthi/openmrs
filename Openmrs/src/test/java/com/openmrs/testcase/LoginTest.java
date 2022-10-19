package com.openmrs.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.openmrs.libs.TestBase;
import com.openmrs.pages.LoginPage;
import com.openmrs.pages.LogoutPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	LogoutPage logoutpage;
	// HomePage homePage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logoutpage= new LogoutPage();
	}

	@Test(priority = 1)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateOpenMRSLogo();
		Assert.assertTrue(flag);
		if (flag) {
			System.out.println("OpenMRS Logo is Displayed");
		} else {
			System.out.println("OpenMRS Logo is not Displayed");
		}
	}

	@Test(priority = 2)
	public void loginTest() {
		
		try {
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hometitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(hometitle, "Inicio");
		System.out.println("Home Page Title:: "+ hometitle);
		//Logout
		loginPage = logoutpage.validateLogoutPage();
		String logintitle = logoutpage.validateLoginPageTitle();
		Assert.assertEquals(logintitle, "Login");
		System.out.println("Login Page Title:: "+logintitle);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}