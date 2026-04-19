package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

public class CaptureVitalTest extends DriverFactory 
{
	@Test
    public void captureVital() 
	{
        logger.info("TEST START: Capture Vitals");
        logger.info("Logging into application");
        
        new LoginPage(driver).login(p.getProperty("username"),p.getProperty("password"), p.getProperty("location"));
        logger.info("Navigating to Search Patient");
        new HomePage(driver).clickSearchPatientBtn();

        String patientId = p.getProperty("patientid");
        Assert.assertNotNull(patientId, "Patient ID missing");

        logger.info("Opening patient: " + patientId);
        SearchPatientPage sp = new SearchPatientPage(driver);
        sp.openPatientById(patientId);

        Assert.assertEquals( sp.getPatientIdFromDetailPage(), patientId, "Patient ID mismatch");

        PatientDetailPage pd = new PatientDetailPage(driver);
        logger.info("Starting new visit");
        pd.clickStartVisitBtn();
        pd.confirmStartVisit();

        VisitPage vp = new VisitPage(driver);
        logger.info("Opening Capture Vitals");
        vp.clickCaptureVitalBtn();

        CaptureVitalPage vitals = new CaptureVitalPage(driver);

        vitals.completeVitalsFlow("150", "65", "36.5", "80", "18", "120", "80");

        logger.info("Validating vitals saved");
        Assert.assertTrue(
        	    vitals.isRedirectedToVisitPage(),"Not redirected to Visit Page after saving vitals");        
       
        logger.info("Ending visit");
        vp.clickEndVisitBtn();
        vp.confirmEndVisit();

        Assert.assertTrue(vp.isVisitEnded(),"Visit did not end properly");

        logger.info("TEST PASSED: Vitals captured successfully");
    }
}