package com.openmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.openmrs.libs.TestBase;

public class FindPatientRecorddeletePage extends TestBase {
	
	// Page Factory:
	@FindBy(xpath = "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
	WebElement findPatient;

	@FindBy(id = "patient-search")
	WebElement patientSearch;

	@FindBy(xpath = "//tbody")
	WebElement checkPatientList;

	// Initializing the Page Objects:
	public FindPatientRecorddeletePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateFindPatientPageTitle() {
		return driver.getTitle();
	}

	public void clickFindPatient() {
		findPatient.click();
	}

	public void seachPatientByName(String patientname) {
		patientSearch.sendKeys(patientname);
	}

	public boolean displayedPatientName() {
		boolean flag = checkPatientList.isDisplayed();
		return flag;

	}

}
