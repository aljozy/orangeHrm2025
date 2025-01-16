package org.orange.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.orange.utils.ReadPropertyFile;
import java.time.Duration;
import java.util.Objects;

public class Driver {


    public static WebDriver initDriver() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        System.out.println("browser opened successfully");
        if (Objects.isNull(DriverManager.getDriver())) {

            DriverManager.setDriver(new ChromeDriver(options));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ReadPropertyFile.get("wait"))));

        }
        return DriverManager.getDriver();
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
            System.out.println("browser closed successfully");
        }
    }
}
