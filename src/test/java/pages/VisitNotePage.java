package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class VisitNotePage extends BasePage
{
    WebDriverWait wait;

    public VisitNotePage(WebDriver driver)
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By diagnosisField = By.id("diagnosis-search");
    By diagnosisSuggestions = By.xpath("//ul[contains(@class,'select2-results')]//li");
    By clinicalNoteField = By.xpath("//textarea[contains(@id,'w')]");
    By saveBtn = By.xpath("//button[contains(text(),'Save')] | //input[@value='Save']");

    public void addPrimaryDiagnosis(String diagnosis)
    {
        selectDiagnosis(diagnosis);
    }

    public void addSecondaryDiagnosis(String diagnosis)
    {
        selectDiagnosis(diagnosis);
    }

    private void selectDiagnosis(String diagnosis)
    {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(diagnosisField));
        input.click(); 
        input.clear();
        input.sendKeys(diagnosis);

        By suggestionsContainer = By.xpath("//ul[contains(@class,'select2-results') or contains(@class,'ui-autocomplete')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsContainer));

        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//li[contains(@class,'select2-result') or contains(@class,'ui-menu-item')]")));

        for (WebElement option : options)
        {
            if (option.getText().toLowerCase().contains(diagnosis.toLowerCase()))
            {
                option.click();
                return;
            }
        }

        throw new RuntimeException("Diagnosis not found: " + diagnosis);
    }

    public void addClinicalNote(String note)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clinicalNoteField)).sendKeys(note);
    }

    public void clickSave()
    {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }
}