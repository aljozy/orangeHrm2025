package org.orange.pages;

import org.openqa.selenium.By;
import org.orange.enums.WaitStrategy;
import org.orange.reports.ExtentManager;
import org.orange.reports.ExtentReport;


public class MenuSideBar extends BasePage {
    String genericXpath = "//nav[@class='oxd-navbar-nav']//span[.='demo']";
    private By TimeLink = By.xpath(genericXpath.replace("demo", "Time"));

    public MenuSideBar clickMenuOptions() throws Exception {
        doClick(TimeLink, WaitStrategy.VISIBLE);
        return this;

    }

    public String getPageURl(){
        ExtentManager.getExtText().info(getUrl());
        return getUrl();
    }
}
