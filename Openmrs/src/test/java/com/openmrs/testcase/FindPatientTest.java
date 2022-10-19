package com.openmrs.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openmrs.libs.TestBase;
import com.openmrs.pages.FindPatientRecorddeletePage;
import com.openmrs.pages.HomePage;
import com.openmrs.pages.LoginPage;
import com.openmrs.pages.LogoutPage;

public class FindPatientTest extends TestBase {

	LoginPage loginPage;
	LogoutPage logoutpage;
	HomePage homePage;
	FindPatientRecorddeletePage findpatientrecord;

	public FindPatientTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logoutpage = new LogoutPage();
		homePage = new HomePage();
		findpatientrecord = new FindPatientRecorddeletePage();
	}

	@Test
	public void findPatientRecord() {
		//Login and Home page Title.
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String hometitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(hometitle, "Inicio");
		System.out.println("Home Page Title:: "+ hometitle);
		
		//Find Patient
		findpatientrecord.clickFindPatient();
		findpatientrecord.seachPatientByName(prop.getProperty("patientname"));
				
		String title = findpatientrecord.validateFindPatientPageTitle();
		String AC_title = "OpenMRS Electronic Medical Record";
		Assert.assertEquals(title, AC_title);
		System.out.println("patient page title" + title);
		
		boolean flag = findpatientrecord.displayedPatientName();
		if (flag) {
			System.out.println("Patient record found");
		} else {
			System.out.println("Patient record not found");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
