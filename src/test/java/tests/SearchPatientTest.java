package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPatientPage;
import utils.DriverFactory;

public class SearchPatientTest extends DriverFactory
{
    @Test
    public void searchPatient()
    {
        logger.info("Starting login");

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(p.getProperty("username"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLocation(p.getProperty("location"));
        lp.clickLogin();

        logger.info("Login completed");

        HomePage hp = new HomePage(driver);
        hp.clickSearchPatientBtn();

        logger.info("Navigated to search page");

        String patientId = p.getProperty("patientid");

        logger.info("Searching patient: " + patientId);

        SearchPatientPage sp = new SearchPatientPage(driver);

        sp.searchPatient(patientId);

        boolean isSelected = sp.selectPatientById(patientId);

        Assert.assertTrue(isSelected, "Patient ID not found: " + patientId);

        logger.info("Patient selected successfully");

        String actualPatientId = sp.getPatientIdFromDetailPage();

        Assert.assertEquals(actualPatientId, patientId, "Patient ID mismatch");

        logger.info("Test passed");
    }
}