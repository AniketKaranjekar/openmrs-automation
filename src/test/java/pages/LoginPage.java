package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
    @FindBy(id = "username") WebElement fieldUsername;
    @FindBy(id = "password") WebElement fieldPassword;
    @FindBy(id = "Inpatient Ward") WebElement selectLocation;
    @FindBy(id = "loginButton") WebElement btnLogin;
    
    public void setUsername(String username)
    {
    	fieldUsername.sendKeys(username);
    }
    
    public void setPassword(String password)
    {
    	fieldPassword.sendKeys(password);
    }
    
    public void clickLocation(String location)
    {
    	selectLocation.sendKeys(location);
    }
    
    public void clickLogin()
    {
    	btnLogin.click();
    }
    
    public void login(String username, String password, String location)
    {
        setUsername(username);
        setPassword(password);
        clickLocation(location);
        clickLogin();
    }
}