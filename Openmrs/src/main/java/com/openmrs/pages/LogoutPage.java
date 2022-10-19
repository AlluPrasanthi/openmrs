package com.openmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.libs.TestBase;

public class LogoutPage extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutBtn;

	// Initializing the Page Objects:
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public LoginPage validateLogoutPage() {
		logoutBtn.click();
		return new LoginPage();
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

}
