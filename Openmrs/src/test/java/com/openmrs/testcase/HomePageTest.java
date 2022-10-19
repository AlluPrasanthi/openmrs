package com.openmrs.testcase;

import com.openmrs.libs.TestBase;
import com.openmrs.pages.HomePage;
import com.openmrs.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	// TestUtil testUtil;
	// ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		// testUtil = new TestUtil();
		// contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("Home Page Title::  "+homePageTitle);
		Assert.assertEquals(homePageTitle, "Home");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		boolean flag = homePage.verifyCorrectUserName();
		if (flag) {
			System.out.println("UserName Displayed on HomePage");
			Assert.assertTrue(flag);
		} else {
			System.out.println("UserName Not Displayed on HomePage");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
