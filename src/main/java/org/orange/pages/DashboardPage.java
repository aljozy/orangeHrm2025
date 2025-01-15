package org.orange.pages;

import org.openqa.selenium.By;


public class DashboardPage extends BasePage{

    private final By attendanceElement = By.xpath(("//div[contains(@class, 'card-profile-record')]/p[contains(@class, 'card-details')]"));
    private final By logoutBtn = By.xpath("//div[@class='oxd-topbar-header-userarea']//ul//li/ul/li[.='Logout']");
    private final By usernameTxtBox = By.xpath("//div[@class='oxd-topbar-header-userarea']//ul//li/span/p");


    private DashboardPage clickLogoutBtn() throws Exception {
        //java 8 lamda
            doClick(logoutBtn);
         return this;
    }

    private DashboardPage logoutElement() throws Exception {
        doClick(usernameTxtBox);
        return this;
    }

    public String getUsernameTxtBox(){
        return getTextFromField(usernameTxtBox);
    }

    public LoginPage logoutWebsite() throws Exception {
         logoutElement().clickLogoutBtn();
        return new LoginPage();
    }
    public String getAttendance(){
        return getTextFromField(attendanceElement);
    }
}
