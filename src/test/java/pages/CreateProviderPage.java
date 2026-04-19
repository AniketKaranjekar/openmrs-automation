package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

public class CreateProviderPage extends BasePage 
{
    WebDriverWait wait;

    public CreateProviderPage(WebDriver driver)
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @FindBy(xpath="//a[normalize-space()='Add New Account']")WebElement addAccountBtn;

    @FindBy(name="familyName")WebElement familyNameField;

    @FindBy(name="givenName")WebElement givenNameField;

    @FindBy(xpath="//input[@value='M']")WebElement genderBtn;

    @FindBy(name="addProviderAccount")WebElement addProviderAccountChkbox;

    @FindBy(name="identifier") WebElement identifierField;

    By providerRoleDropdown = By.id("adminui-providerRole-field");

    @FindBy(id="save-button")WebElement saveButton;

    By successMessage = By.cssSelector(".note.success, .alert.alert-success, .messages");
    
    public void clickAddAccountBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addAccountBtn)).click();
    }
    
    public String setFamilyName(String familyName)
    {
        wait.until(ExpectedConditions.visibilityOf(familyNameField)).sendKeys(familyName);
		return familyName;
    }
    
    public void setGivenName(String givenName)
    {
        wait.until(ExpectedConditions.visibilityOf(givenNameField)).sendKeys(givenName);
    }
    
    public void clickGenderChkbox()
    {
        wait.until(ExpectedConditions.elementToBeClickable(genderBtn)).click();
    }
    
    public void clickProviderAccountChkbox() 
    {
        wait.until(ExpectedConditions.elementToBeClickable(addProviderAccountChkbox)).click();
    }
    
    public void setIdentifierField(String identifierName)
    {
        wait.until(ExpectedConditions.visibilityOf(identifierField)).sendKeys(identifierName);
    }
    
    public void selectProviderRole(String role)
    {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(providerRoleDropdown));

        Select select = new Select(dropdown);
        select.selectByVisibleText(role);
    }
    
    public void clickSaveButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    
    public String getSuccessMessage()
    {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return msg.getText();
    }
}