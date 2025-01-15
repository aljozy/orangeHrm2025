package org.orange.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orange.driver.DriverManager;
import org.orange.utils.ReadPropertyFile;

import java.time.Duration;


public class BasePage {

    protected void doClick(By by) throws Exception {
        waiting(by, Long.parseLong( ReadPropertyFile.get("wait")));
        DriverManager.getDriver().findElement(by).click();
    }

    protected  void sendKeys(By by,String value) throws Exception {
        waiting(by, Long.parseLong( ReadPropertyFile.get("wait")));
       DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected String getTextFromField(By by){
       return DriverManager.getDriver().findElement(by).getText();
    }

    protected void waiting(By by,Long timeout){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(driver -> DriverManager.getDriver().findElement(by).isEnabled());
    }





}
