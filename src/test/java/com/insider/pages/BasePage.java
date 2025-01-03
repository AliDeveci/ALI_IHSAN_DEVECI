package com.insider.pages;

import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement acceptCookies;

    public void assertCurrentUrl(String expectedUrl){
        assertTrue(Driver.get().getCurrentUrl().equals(ConfigurationReader.get(expectedUrl)));
    }
    public void selectMenu(String menuName) {
        Driver.get().findElement(By.linkText(menuName)).click();
    }

    public void selectSubMenu(String menuName,String subMenuName) {
        Driver.get().findElement(By.linkText(menuName)).click();
        Driver.get().findElement(By.linkText(subMenuName)).click();
    }

}
