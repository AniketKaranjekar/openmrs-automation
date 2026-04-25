package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest extends DriverFactory {

    @Test
    public void verifyLogin() {

        logger.info("Starting login test");

        LoginPage lp = new LoginPage(driver);

        lp.login(
                p.getProperty("username"),
                p.getProperty("password")
        );

        boolean isLoggedIn =
                driver.getPageSource().contains("Inpatient Ward'")
                || driver.getCurrentUrl().contains("home.page");

        Assert.assertTrue(isLoggedIn, "Login failed: user not landed on home page");

        logger.info("Login test passed");
    }
}