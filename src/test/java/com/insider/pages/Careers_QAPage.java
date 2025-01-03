package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.insider.utilities.BrowserUtils.*;
import static org.testng.Assert.*;

public class Careers_QAPage extends BasePage {

    Select select;

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllQAJobs;
    @FindBy(id = "filter-by-location")
    public WebElement filterByLocation;
    @FindBy(id = "filter-by-department")
    public WebElement filterByDepartment;
    @FindBy(id = "resultCounter")
    public WebElement resultForJobSearch;
    @FindBy(id = "career-position-list")
    public WebElement positions;
    @FindBy(css = ".position-list-item-wrapper.bg-light")
    public List<WebElement> positionList;
    @FindBy(id = "select2-filter-by-location-container")
    public WebElement selectedLocationText;
    @FindBy(xpath = "(//a[text()='Apply for this job'])[1]")
    public WebElement applyBtn;

    public void verifyPresenceOfJobList(){
        waitForAttributeValue(selectedLocationText, "title", "Istanbul, Turkey", 10);
        scrollToElement(positions);
        waitFor(2);
        assertTrue(positionList.size() > 0);
    }

    public void verifyAllJobSearchResult(String expectedPosition1, String expectedPosition2, String expectedLocation, String expectedDepartment) {
        waitForAttributeValue(selectedLocationText, "title", "Istanbul, Turkey", 10);
        scrollToElement(positions);
        waitFor(2);
        assertTrue(positionList.size() > 0);
        assertTrue(resultForJobSearch.getText().contains("Showing"));
        for (int i = 1; i <= positionList.size(); i++) {
            String actualPosition = Driver.get().findElement(By.xpath("(//p[@class='position-title font-weight-bold'])["+i+"]")).getText();
            String actualLocation = Driver.get().findElement(By.xpath("(//div[contains(@class,'position-location')])[" + i + "]")).getText();
            String actualDepartment = Driver.get().findElement(By.xpath("(//span[contains(@class,'position-department')])[" + i + "]")).getText();
            assertTrue(actualDepartment.contains(expectedPosition1)||actualPosition.contains(expectedPosition2));
            assertTrue(actualLocation.contains(expectedLocation));
            assertTrue(actualDepartment.contains(expectedDepartment));
        }
    }

    public void verifyRedirectionToLeverApp() {
        for (int i = 1; i <= positionList.size(); i++) {
            WebElement position = Driver.get().findElement(By.xpath("(//div[contains(@class,'position-location')])[" + i + "]"));
            WebElement viewRoleButton = Driver.get().findElement(By.xpath("(//a[text()='View Role'])["+ i +"]"));
            hover(position);
            waitForVisibility(viewRoleButton,10);
            viewRoleButton.click();
            switchToWindowAndVerify("lever",applyBtn,5);
        }
    }

}
