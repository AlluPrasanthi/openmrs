package com.openmrs.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.openmrs.libs.TestBase;
import com.openmrs.pages.HomePage;
import com.openmrs.pages.LoginPage;
import com.openmrs.pages.LogoutPage;
import com.openmrs.pages.RegisterPatientPage;
import com.openmrs.util.TestUtil;

public class RegisterPatientTest extends TestBase {

	LoginPage loginPage;
	LogoutPage logoutpage;
	HomePage homePage;
	RegisterPatientPage registerpatientpage;

	public RegisterPatientTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		logoutpage = new LogoutPage();
		homePage = new HomePage();
		registerpatientpage = new RegisterPatientPage();
	}

	@DataProvider
	public Object[][] getpatientdata() throws IOException {
		Object Data[][] = {{"test","a",1,"10",5,"1985","aaa","ss","dd","ff","11111","9999999999",3,"aaa"}};
		
		return Data;
	}

	@Test(dataProvider = "getpatientdata")
	public void registerPatientPage(String name,String familyname,int gender,String date,int monthindex,String year,
			String address,String village,String state,String country,String postalcode,String phonenumber,int relshiptype,String relpersonname) {
		try {
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		registerpatientpage.clickregisterPatient();
		registerpatientpage.registerPatient(name, familyname, gender, date, monthindex, year, address, village,
				state, country, postalcode, phonenumber, relshiptype, relpersonname);

	}

}
