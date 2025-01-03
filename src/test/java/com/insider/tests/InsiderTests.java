package com.insider.tests;

import com.insider.pages.CareersPage;
import com.insider.pages.Careers_QAPage;
import com.insider.pages.HomePage;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.testng.annotations.Test;

import static com.insider.utilities.BrowserUtils.*;

public class InsiderTests extends TestBase {

    @Test(description = "Verify that Insider home page is loaded")
    public void t01_isHomePageLoaded() {
        homePage = new HomePage();
        extentLogger = report.createTest("Home Page is loaded");

        extentLogger.info("Go to "+ConfigurationReader.get("urlInsider")+" web page");
        Driver.get().get(ConfigurationReader.get("urlInsider"));
        extentLogger.info("Verify that the user lands on "+ConfigurationReader.get("urlInsider")+" url");
        homePage.assertCurrentUrl("urlInsider");
        extentLogger.pass("Home Page is loaded test is Passed");
    }

    @Test(description = "Verify that Locations, Teams, and Life at Insider blocks are loaded on Careers Page")
    public void t02_areBlocksLoadedOnCareers() {
        homePage = new HomePage();
        careersPage= new CareersPage();
        extentLogger = report.createTest("Blocks are loaded on Careers Page");

        extentLogger.info("Go to "+ConfigurationReader.get("urlInsider")+" web page");
        Driver.get().get(ConfigurationReader.get("urlInsider"));
        extentLogger.info("Accept All Cookies");
        homePage.acceptCookies.click();
        extentLogger.info("Go to "+ConfigurationReader.get("urlCareers")+" web page");
        homePage.selectSubMenu("Company","Careers");
        extentLogger.info("Verify that the user lands on "+ConfigurationReader.get("urlCareers")+" page");
        homePage.assertCurrentUrl("urlCareers");
        extentLogger.info("Verify that the 'Teams Block' is displayed");
        careersPage.checkElementDisplayed(careersPage.findYourCalling);
        extentLogger.info("Verify that the 'See all teams link' is displayed");
        careersPage.checkElementDisplayed(careersPage.seeAllTeams);
        extentLogger.info("Verify that the 'Our Locations Block' is displayed");
        careersPage.checkElementDisplayed(careersPage.ourLocations);
        extentLogger.info("Verify that the 'Life at Insider Block' is displayed");
        careersPage.checkElementDisplayed(careersPage.lifeAtInsider);
        extentLogger.pass("Blocks are loaded on Careers Page test is Passed");
    }

    @Test(description = "Verify that the presence of the job list by Careers QA")
    public void t03_presenceOfJobList() {
        careers_QAPage = new Careers_QAPage();

        extentLogger = report.createTest("Job List is presence on Careers QA Page");

        extentLogger.info("Go to "+ConfigurationReader.get("urlCareersQA")+" web page");
        Driver.get().get(ConfigurationReader.get("urlCareersQA"));
        extentLogger.info("Accept All Cookies");
        careers_QAPage.acceptCookies.click();

        extentLogger.info("Click on 'See all QA jobs'");
        careers_QAPage.seeAllQAJobs.click();

        extentLogger.info("Verify that the user lands on "+ConfigurationReader.get("urlOpenPositionsQA")+" page");
        careers_QAPage.assertCurrentUrl("urlOpenPositionsQA");

        extentLogger.info("Filter jobs by Location:'Istanbul, Turkey'");
        select_byVisibleText(careers_QAPage.filterByLocation,"positiveLocationFilter");

        extentLogger.info("Filter jobs by Department:'Quality Assurance'");
        select_byVisibleText(careers_QAPage.filterByDepartment,"positiveDepartmentFilter");

        extentLogger.info("Verify that the open positions are listed");
        careers_QAPage.verifyPresenceOfJobList();

        extentLogger.pass("Job List is presence on Careers QA Page test is Passed");
    }

    @Test(description = "Verify that all jobs info is as expected on Careers QA page")
    public void t04_allJobsContainsExpectedInfo() {
        careers_QAPage = new Careers_QAPage();

        extentLogger = report.createTest("Jobs contains expected data on Careers QA Page");

        extentLogger.info("Go to "+ConfigurationReader.get("urlCareersQA")+" web page");
        Driver.get().get(ConfigurationReader.get("urlCareersQA"));
        extentLogger.info("Accept All Cookies");
        careers_QAPage.acceptCookies.click();

        extentLogger.info("Click on 'See all QA jobs'");
        careers_QAPage.seeAllQAJobs.click();

        extentLogger.info("Verify that the user lands on "+ConfigurationReader.get("urlOpenPositionsQA")+" page");
        careers_QAPage.assertCurrentUrl("urlOpenPositionsQA");

        extentLogger.info("Filter jobs by Location:'Istanbul, Turkey'");
        select_byVisibleText(careers_QAPage.filterByLocation,"positiveLocationFilter");

        extentLogger.info("Filter jobs by Department:'Quality Assurance'");
        select_byVisibleText(careers_QAPage.filterByDepartment,"positiveDepartmentFilter");

        extentLogger.info("Verify that the open positions are listed with expected data");
        careers_QAPage.verifyAllJobSearchResult("Quality Assurance","QA","Istanbul, Turkey","Quality Assurance");

        extentLogger.pass("Jobs contains expected data on Careers QA Page test is Passed");
    }

    @Test(description = "Verify that the clicking 'View Role' button redirects to the Lever Application form page")
    public void t05_redirectingLeverApplicationForm() {
        careers_QAPage = new Careers_QAPage();

        extentLogger = report.createTest("'View Role' button redirects to the Lever Application form page");

        extentLogger.info("Go to "+ConfigurationReader.get("urlCareersQA")+" web page");
        Driver.get().get(ConfigurationReader.get("urlCareersQA"));
        extentLogger.info("Accept All Cookies");
        careers_QAPage.acceptCookies.click();

        extentLogger.info("Click on 'See all QA jobs'");
        careers_QAPage.seeAllQAJobs.click();

        extentLogger.info("Verify that the user lands on "+ConfigurationReader.get("urlOpenPositionsQA")+" page");
        careers_QAPage.assertCurrentUrl("urlOpenPositionsQA");

        extentLogger.info("Filter jobs by Location:'Istanbul, Turkey'");
        select_byVisibleText(careers_QAPage.filterByLocation,"positiveLocationFilter");

        extentLogger.info("Filter jobs by Department:'Quality Assurance'");
        select_byVisibleText(careers_QAPage.filterByDepartment,"positiveDepartmentFilter");

        extentLogger.info("Verify that the open positions are listed with expected data");
        careers_QAPage.verifyAllJobSearchResult("Quality Assurance","QA","Istanbul, Turkey","Quality Assurance");

        extentLogger.info("Verify that the 'APPLY FOR THIS JOB' is displayed after switching to lever page");
        careers_QAPage.verifyRedirectionToLeverApp();

        extentLogger.pass("'View Role' button redirects to the Lever Application form page test is Passed");
    }
}
