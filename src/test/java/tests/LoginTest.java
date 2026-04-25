package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends DriverFactory {

    @Test
    public void verifyLogin() {

        logger.info("Starting login test");

        LoginPage lp = new LoginPage(driver);

        lp.login(
                p.getProperty("username"),
                p.getProperty("password")
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("home"),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"))
        ));

        boolean isLoggedIn =
                driver.getPageSource().contains("Logout")
                || driver.getCurrentUrl().contains("home");

        Assert.assertTrue(isLoggedIn, "Login failed: user not landed on home page");

        logger.info("Login test passed");
    }
}