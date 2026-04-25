package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.PatientDetailPage;
import pages.SearchPatientPage;
import pages.VisitNotePage;
import pages.VisitPage;
import utils.DriverFactory;

public class VisitNoteTest extends DriverFactory
{
    @Test
    public void AddVisitNote()
    {
        logger.info("TEST START: Add Visit Note");

        logger.info("Logging into application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login( p.getProperty("username"), p.getProperty("password"));

        HomePage hp = new HomePage(driver);
        logger.info("Navigating to Search Patient page");
        hp.clickSearchPatientBtn();

        String patientId = p.getProperty("patientid");
        logger.info("Searching patient with ID: " + patientId);

        SearchPatientPage sp = new SearchPatientPage(driver);
        sp.openPatientById(patientId);

        logger.info("Validating patient detail page loaded");
        String actualPatientId = sp.getPatientIdFromDetailPage();
        Assert.assertEquals(actualPatientId, patientId, "Patient ID mismatch");

        logger.info("Starting visit");
        PatientDetailPage pd = new PatientDetailPage(driver);
        pd.clickStartVisitBtn();
        pd.confirmStartVisit();

        logger.info("Waiting for Visit page to load");
        VisitPage vp = new VisitPage(driver);
        vp.clickVisitNoteBtn();
        
        VisitNotePage vn = new VisitNotePage(driver);

        String primary = p.getProperty("Primarydiagnosis");
        logger.info("Adding primary diagnosis: " + primary);
        vn.addPrimaryDiagnosis(primary);

        logger.info("Adding secondary diagnosis");
        vn.addSecondaryDiagnosis("Secondarydiagnoses");

        logger.info("Adding clinical notes");
        vn.addClinicalNote("Clinicalnote");

        logger.info("Saving visit note");
        vn.clickSave();

        logger.info("Validating visit note saved successfully");

        String pageSource = driver.getPageSource().toLowerCase();

        Assert.assertTrue(
            pageSource.contains("success") || pageSource.contains("saved"),
            "Visit note was not saved successfully"
        );
        
        logger.info("Ending visit");
        vp.clickEndVisitBtn();
        vp.confirmEndVisit();
        
        boolean isEnded = vp.isVisitEnded();
        Assert.assertTrue(isEnded, "Visit did not end properly");
        
        logger.info("TEST PASSED: Visit Note Added Successfully");
    }
}