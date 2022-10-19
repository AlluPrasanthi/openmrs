package com.openmrs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.openmrs.libs.TestBase;

public class RegisterPatientPage extends TestBase {
	
	@FindBy(id = "//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
	WebElement registerPatient;

	@FindBy(xpath = "//input[@name='givenName']")
	WebElement patientName;

	@FindBy(xpath = "//input[@name='familyName']")
	WebElement patientFamilyName;

	@FindBy(xpath = "//button[@id='next-button']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//select[@name='gender']")
	WebElement dropdowngender;

	@FindBy(xpath = "//input[@id='birthdateDay-field']")
	WebElement dateTB;
	
	@FindBy(xpath = "//select[@id='birthdateMonth-field']")
	WebElement dropdownmonth;
	
	@FindBy(xpath = "//input[@id='birthdateYear-field']")
	WebElement yearTB;
	
	@FindBy(id = "address1")
	WebElement addressTB;
	
	@FindBy(id = "cityVillage")
	WebElement villageTB;
	
	@FindBy(id = "stateProvince")
	WebElement stateTB;
	
	@FindBy(id = "country")
	WebElement countryTB;
	
	@FindBy(id = "postalCode")
	WebElement postalCodeTB;
	
	@FindBy(id = "fr743-field")
	WebElement phoneNumberTB;
	
	@FindBy(xpath = "//select[@id='relationship_type']")
	WebElement relationshiptype;
	
	@FindBy(xpath = "//input[@placeholder='Person Name']")
	WebElement relationshippersonname;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	@FindBy(id = "cancelSubmission")
	WebElement cancelBtn;

	// Initializing the Page Objects:
	public RegisterPatientPage() {
		PageFactory.initElements(driver, this);
	}
	public static void selectoptionfromdropdown(WebElement element,int index) {
		
		Select option = new Select(element);
		option.selectByIndex(index);
	}
	
	public void clickregisterPatient() {
		registerPatient.click();
	}
	
	public void registerPatient(String name,String familyname,int gender,String date,int monthindex,String year,String address,String village,String state,
			String country,String postalcode,String phonenumber,int relshiptype,String relpersonname) {
		
		patientName.sendKeys(name);
		patientFamilyName.sendKeys(familyname);
		nextBtn.click();
		
		selectoptionfromdropdown(dropdowngender,gender);
		nextBtn.click();
		
		dateTB.sendKeys(date);
		selectoptionfromdropdown(dropdownmonth,monthindex);
		yearTB.sendKeys(year);
		nextBtn.click();
		
		addressTB.sendKeys(address);
		villageTB.sendKeys(village);
		stateTB.sendKeys(state);
		countryTB.sendKeys(country);
		postalCodeTB.sendKeys(postalcode);
		nextBtn.click();
		
		phoneNumberTB.sendKeys(phonenumber);
		nextBtn.click();
		
		selectoptionfromdropdown(relationshiptype,relshiptype);
		relationshippersonname.sendKeys(relpersonname);
		submitBtn.click();		
		
	}


}
