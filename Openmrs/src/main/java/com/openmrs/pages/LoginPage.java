package com.openmrs.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.libs.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "Inpatient Ward")
	WebElement locationSession;

	@FindBy(xpath = "//input[@id='loginButton']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@src='/openmrs/ms/uiframework/resource/referenceapplication/images/openMrsLogo.png']")
	WebElement openMRSLogo;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateOpenMRSLogo() {
		return openMRSLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		locationSession.click();
		// loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}

}
