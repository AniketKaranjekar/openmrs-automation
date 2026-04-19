package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	WebElement registerPatientBtn;
	
	@FindBy(id="coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension") WebElement searchPatientBtn;
	
	@FindBy(id="coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension") WebElement systemAdministrationBtn;
	
	@FindBy(id="org-openmrs-module-adminui-accounts-app") WebElement manageAccountBtn;
	
	public void clickRegisterPatientBtn()
	{
		registerPatientBtn.click();
	}
	
	public void clickSearchPatientBtn()
	{
		searchPatientBtn.click();
	}
	
	public void clickSystemAdministrationBtn()
	{
		systemAdministrationBtn.click();
	}
	
	public void clickManageAccountBtn()
	{
		manageAccountBtn.click();
	}
}