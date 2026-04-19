package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPatientPage;
import utils.DriverFactory;
import utils.TestData;

public class RegisterPatientTest extends DriverFactory
{
	@Test
	public void registerPatient()
	{
		 logger.info("Starting login");
			
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLocation(p.getProperty("location"));
		lp.clickLogin();
		
		logger.info("Login completed");

		logger.info("Clicking  register button");
		
		HomePage hp=new HomePage(driver);
		hp.clickRegisterPatientBtn();
		
		logger.info("Starting register patient");

		RegisterPatientPage rp=new RegisterPatientPage(driver);
		rp.setGivenName(TestData.getRandomFirstName());
		rp.setFamilyName(TestData.getRandomLastName());
		rp.clickNextBtn();
		rp.selectGender();
		rp.clickNextBtn2();
		rp.setBirthYear(TestData.getRandomYear());
		rp.setBirthMonth(TestData.getRandomMonth());
		rp.clickNextBtn2();
		rp.setAddress(TestData.getRandomAddress());
		rp.clickNextBtn4();
		rp.setPhoneNumber(TestData.getRandomPhone());
		rp.clickNextBtn5();
		rp.clickNextBtn6();
		rp.clickConfirmBtn();
		
		logger.info("Validating patient creation");
		
		String patientId = rp.getPatientId();
		
		Assert.assertNotNull(patientId, "Patient ID is null");
		System.out.println("Patient Id is "+ patientId);
		
		logger.info("Regiter test passed");
	}
}