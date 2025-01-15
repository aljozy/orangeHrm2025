package org.orange.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.orange.utils.ReadPropertyFile;

import java.time.Duration;
import java.util.Objects;

public class Driver {


    public static WebDriver initDriver() throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {

            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ReadPropertyFile.get("wait"))));

        }
        return DriverManager.getDriver();
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();

        }
    }
}
