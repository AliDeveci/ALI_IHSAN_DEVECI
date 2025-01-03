package com.insider.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.insider.pages.CareersPage;
import com.insider.pages.Careers_QAPage;
import com.insider.pages.HomePage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {

    WebDriver driver;

     ExtentReports report;
     ExtentHtmlReporter htmlReporter;
     ExtentTest extentLogger;

     HomePage homePage;
     CareersPage careersPage;
     Careers_QAPage careers_QAPage;

    @BeforeTest
    public void setUpReport(){
        report = new ExtentReports();
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Insider Task Tests");
        report.setSystemInfo("Environment","Production/InsiderHomePage");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Ali Ihsan Deveci");
    }
    @AfterTest
    public void tearDownReport(){
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            extentLogger.fail(result.getThrowable());
        }
        Driver.closeDriver();
    }
}
