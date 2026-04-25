package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CreateProviderPage;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.TestData;

public class CreateProviderTest extends DriverFactory
{
	@Test
	public void createProvider()
	{
		logger.info("Starting login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login( p.getProperty("username"), p.getProperty("password"));

        logger.info("Login completed");

        HomePage hp = new HomePage(driver);
        
        logger.info("Clicking on System Administration");
        hp.clickSystemAdministrationBtn();
        
        logger.info("Clicking on Manage Account");
        hp.clickManageAccountBtn();
        
        logger.info("Starting provider creation");

        CreateProviderPage cp=new CreateProviderPage(driver);
        cp.clickAddAccountBtn();
        String identifier=cp.setFamilyName(TestData.getRandomFirstName());
        cp.setGivenName(TestData.getRandomLastName());
        cp.clickGenderChkbox();
        cp.clickProviderAccountChkbox();
        cp.setIdentifierField("Provider "+ identifier);
        cp.selectProviderRole("Clinical Doctor");
        cp.clickSaveButton();
        
       // String actual = cp.getSuccessMessage();

        Assert.assertTrue(driver.getCurrentUrl().contains("account"), "Navigation failed");
        //Assert.assertTrue(actual.equalsIgnoreCase("Account saved successfully"),"Account creation failed"); 
      //  System.out.println(actual);
        logger.info("Provider creation passed");

	}
}