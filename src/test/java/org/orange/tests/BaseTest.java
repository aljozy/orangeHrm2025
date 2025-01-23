package org.orange.tests;



import org.orange.driver.Driver;
import org.orange.driver.DriverManager;
import org.orange.reports.ExtentReport;
import org.orange.utils.ReadPropertyFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class BaseTest {
    @BeforeSuite
    public void startReporting(){
        ExtentReport.initReports();
    }

    @AfterSuite
    public void generatingReports() throws IOException {
        ExtentReport.flushReports();
    }
    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
//        ExtentReport.test.info("Browser opened successfully");
        DriverManager.getDriver().get(ReadPropertyFile.get("url"));

    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
//        ExtentReport.test.info("Browser closed successfully");
    }

}
