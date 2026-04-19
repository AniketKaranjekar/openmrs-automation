package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class VisitPage extends BasePage
{
    WebDriverWait wait;

    public VisitPage(WebDriver driver)
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By visitNoteBtn = By.id("referenceapplication.realTime.simpleVisitNote");
    By captureVitalBtn = By.id("referenceapplication.realTime.vitals");
    By endVisitBtn = By.xpath("//a[normalize-space()='End Visit']");

    By endVisitDialog = By.id("end-visit-dialog");
    By confirmYesBtn = By.xpath("//div[@id='end-visit-dialog']//button[contains(@class,'confirm') and normalize-space()='Yes']");

   
    public void clickVisitNoteBtn()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(visitNoteBtn));
        wait.until(ExpectedConditions.elementToBeClickable(visitNoteBtn)).click();
    }

    public void clickCaptureVitalBtn()
    {
    	     wait.until(ExpectedConditions.presenceOfElementLocated(captureVitalBtn));
         wait.until(ExpectedConditions.elementToBeClickable(captureVitalBtn)).click();
    }

    public void clickEndVisitBtn()
    {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(endVisitBtn));
        el.click();
    }

    public void confirmEndVisit()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(endVisitDialog));

        WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmYesBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yesBtn);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesBtn);
    }
    
    public boolean isVisitEnded()
    {
        try
        {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(endVisitBtn));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}