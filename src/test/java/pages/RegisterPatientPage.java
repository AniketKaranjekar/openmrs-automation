package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class RegisterPatientPage extends BasePage
{
	public RegisterPatientPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="givenName") WebElement givenNameField;
	@FindBy(name="familyName") WebElement familyNameField;
    @FindBy(id="next-button") WebElement nextBtn;
    @FindBy(xpath="//option[@value='M']") WebElement genderOption;
    @FindBy(id="next-button") WebElement nextBtn2;
    @FindBy(id="birthdateYears-field") WebElement birthYearField;
    @FindBy(id="birthdateMonths-field") WebElement birthMonthField;
    @FindBy(id="next-button") WebElement nextBtn3;  
    @FindBy(id="address1") WebElement addressField;
    @FindBy(id="next-button") WebElement nextBtn4;
    @FindBy(name="phoneNumber") WebElement phoneNumber;
    @FindBy(id="next-button") WebElement nextBtn5;  
    @FindBy(id="next-button") WebElement nextBtn6;
    @FindBy(id="submit") WebElement confirmButton;
    @FindBy(css = ".PersonName-givenName") WebElement givenNameText;
    @FindBy(css = ".PersonName-familyName") WebElement familyNameText;
    @FindBy(css = ".float-sm-right span") WebElement patientId;
    
    public void setGivenName(String givenName)
    {
    		givenNameField.sendKeys(givenName);
    }
    
    public void setFamilyName(String familyName)
    {
    		familyNameField.sendKeys(familyName);
    }
    
    public void clickNextBtn()
    {
    		nextBtn.click();
    }
    
    public void selectGender()
    {
    		genderOption.click();
    }
    
    public void clickNextBtn2()
    {
    		nextBtn2.click();
    }
    
    public void setBirthYear(String year)
    {
    		birthYearField.sendKeys(year);
    }
    
    public void setBirthMonth(String month)
    {
    		birthMonthField.sendKeys(month);
    }
    
    public void clickNextBtn3()
    {
    		nextBtn3.click();
    }
    
    public void setAddress(String address)
    {
    		addressField.sendKeys(address);
    }
    
    public void clickNextBtn4()
    {
    		nextBtn4.click();
    }
    
    public void setPhoneNumber(String PhoneNumber)
    {
    		phoneNumber.sendKeys(PhoneNumber);
    }
    
    public void clickNextBtn5()
    {
    		nextBtn5.click();
    }
    
    public void clickNextBtn6()
    {
    		nextBtn6.click();
    }
    
    public void clickConfirmBtn()
    {
    		confirmButton.click();
    }
    
    public String getPatientFullName()
    {
        return givenNameText.getText() + " " + familyNameText.getText();
    }

    public String getPatientId()
    {
        return patientId.getText();
    }
}
