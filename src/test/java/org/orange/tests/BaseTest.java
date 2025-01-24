package org.orange.tests;



import org.orange.driver.Driver;
import org.orange.driver.DriverManager;

import org.orange.utils.ReadPropertyFile;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;




public class BaseTest {

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
        DriverManager.getDriver().get(ReadPropertyFile.get("url"));

    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }

}
