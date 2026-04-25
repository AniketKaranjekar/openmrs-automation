package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement fieldUsername;

    @FindBy(id = "password")
    WebElement fieldPassword;

    @FindBy(id = "Inpatient Ward")
    WebElement inpatientWard;

    @FindBy(id = "loginButton")
    WebElement btnLogin;

    public void enterUsername(String username) {
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }

    public void selectInpatientWard() {
        inpatientWard.click();
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        selectInpatientWard();
        clickLogin();
    }
}