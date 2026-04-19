package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;
import java.time.Duration;

public class PatientDetailPage extends BasePage
{
    WebDriverWait wait;

    public PatientDetailPage(WebDriver driver)
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    By startVisitBtn = By.id("org.openmrs.module.coreapps.createVisit");
    By confirmBtn = By.id("start-visit-with-visittype-confirm");

    public void clickStartVisitBtn()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(startVisitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(startVisitBtn)).click();
    }

    public void confirmStartVisit()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }
}