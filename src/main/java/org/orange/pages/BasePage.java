package org.orange.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orange.driver.DriverManager;
import org.orange.enums.WaitStrategy;
import org.orange.utils.ReadPropertyFile;

import java.time.Duration;


public class BasePage {

    protected void doClick(By by, WaitStrategy waitStrategy) throws Exception {
        if(waitStrategy == WaitStrategy.CLICKABLE) {
            elementToBeClickable(by, Long.parseLong(ReadPropertyFile.get("wait")));
        }
        else if(waitStrategy == WaitStrategy.PRESENCE){
            elementToBePresent(by,Long.parseLong(ReadPropertyFile.get("wait")));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            waitForEnable(by, Long.parseLong(ReadPropertyFile.get("wait")));
        }
        DriverManager.getDriver().findElement(by).click();
    }

    protected  void sendKeys(By by,String value) throws Exception {
       elementToBePresent(by,Long.parseLong(ReadPropertyFile.get("wait")));
       DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected String getTextFromField(By by) throws Exception {
        elementToBePresent(by, Long.parseLong( ReadPropertyFile.get("wait")));
       return DriverManager.getDriver().findElement(by).getText();
    }
    protected String getUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }

    private void waitForEnable(By by,Long timeout){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(driver -> DriverManager.getDriver().findElement(by).isEnabled());
    }
    private void elementToBeClickable(By by, Long timeout) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(condition-> ExpectedConditions.elementToBeClickable(by));

    }
    private void elementToBePresent(By by, Long timeout) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout))
                .until(condition-> ExpectedConditions.presenceOfElementLocated(by));

    }






}
