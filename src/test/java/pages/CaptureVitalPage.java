package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.BasePage;

public class CaptureVitalPage extends BasePage
{
	WebDriverWait wait;

    public CaptureVitalPage(WebDriver driver) 
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By activeInput = By.xpath("//fieldset[contains(@class,'focused')]//input");
    By nextBtn = By.id("next-button");
    By saveBtn = By.cssSelector("button[type='submit']");
    
    private void enterAndNext(String value, String fieldName) 
    {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(activeInput));
        input.clear();
        input.sendKeys(value);

        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }

    public void completeVitalsFlow
    (
    		String height,
        String weight,
        String temp,
        String pulse,
        String resp,
        String sys,
        String dia
    ) 
    
    {
        enterAndNext(height, "Height");
        enterAndNext(weight, "Weight");

        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();

        enterAndNext(temp, "Temperature");
        enterAndNext(pulse, "Pulse");
        enterAndNext(resp, "Respiratory");

        List<WebElement> inputs = wait.until( ExpectedConditions.numberOfElementsToBeMoreThan(activeInput, 1));

        inputs.get(0).sendKeys(sys);
        inputs.get(1).sendKeys(dia);

        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();

        try {
        			wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
            } 
        catch (Exception e) 
        {
        		System.out.println("No optional step");
        }

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
   }
    
    public boolean isRedirectedToVisitPage() 
    {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("referenceapplication.realTime.vitals") )).isDisplayed();
        } catch (Exception e) 
        {
            return false;
        }
    }
}