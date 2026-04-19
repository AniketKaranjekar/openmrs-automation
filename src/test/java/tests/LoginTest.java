package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest extends DriverFactory 
{
	@Test
	public void verifyLogin()
	{
		 logger.info("Starting login test");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLocation(p.getProperty("location"));
		lp.clickLogin();
				
		String expectedUrl="https://o2.openmrs.org/openmrs/referenceapplication/home.page";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed: URL mismatch");
		
		 logger.info("Login test passed");

	}
}