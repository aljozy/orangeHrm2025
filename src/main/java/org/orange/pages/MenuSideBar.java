package org.orange.pages;

import org.openqa.selenium.By;
import org.orange.enums.WaitStrategy;
import org.orange.reports.ExtentLogger;



public class MenuSideBar extends BasePage {
    String genericXpath = "//nav[@class='oxd-navbar-nav']//span[.='demo']";
    private final By TimeLink = By.xpath(genericXpath.replace("demo", "Time"));

    public MenuSideBar clickMenuOptions() throws Exception {
        doClick(TimeLink, WaitStrategy.VISIBLE);
        return this;

    }

    public String getPageURl(){

        ExtentLogger.info(getUrl());
        return getUrl();
    }
}
