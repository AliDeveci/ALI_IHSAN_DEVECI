package com.insider.pages;

import com.insider.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage{

    @FindBy(xpath = "//h3[contains(text(),'Find your calling')]")
    public WebElement findYourCalling;
    @FindBy(xpath = "//a[contains(text(),'See all teams')]")
    public WebElement seeAllTeams;
    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement ourLocations;
    @FindBy(xpath = "//h2[contains(text(),'Life at Insider')]")
    public WebElement lifeAtInsider;

    public Boolean checkElementDisplayed(WebElement element){
        BrowserUtils.scrollToElement(element);
        return element.isDisplayed();
    }

}
