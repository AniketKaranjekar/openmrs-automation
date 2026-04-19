package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class SearchPatientPage extends BasePage
{
    WebDriverWait wait;

    public SearchPatientPage(WebDriver driver)
    {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By patientSearchField = By.id("patient-search");
    By tableRows = By.cssSelector("#patient-search-results-table tbody tr");

    By firstColumnCells = By.cssSelector("#patient-search-results-table tbody tr td:nth-child(1)");

    By patientIdText = By.cssSelector(".float-sm-right span");

    public void searchPatient(String id)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(patientSearchField)).clear();
        driver.findElement(patientSearchField).sendKeys(id);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0));
    }

    public boolean selectPatientById(String expectedId)
    {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0));

        List<WebElement> ids = driver.findElements(firstColumnCells);

        for (int i = 0; i < ids.size(); i++)
        {
            List<WebElement> freshIds = driver.findElements(firstColumnCells);

            if (freshIds.size() <= i)
                break;

            String actualId = freshIds.get(i).getText().trim();

            actualId = actualId.replace("Recent", "").trim();

            System.out.println("Clean ID: " + actualId);

            if (actualId.equalsIgnoreCase(expectedId))
            {
                freshIds.get(i).click();
                return true;
            }
        }
        return false;
    }

    public String getPatientIdFromDetailPage()
    {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(patientIdText)).getText();

        return text.replace("Patient ID", "").replace(":", "").trim();
    }
    
    public void openPatientById(String patientId)
    {
        searchPatient(patientId);
        boolean found = selectPatientById(patientId);

        if(!found)
            throw new RuntimeException("Patient not found: " + patientId);
    }
}