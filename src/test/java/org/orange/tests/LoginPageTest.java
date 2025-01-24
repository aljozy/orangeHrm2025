package org.orange.tests;

import org.assertj.core.api.Assertions;
import org.orange.pages.DashboardPage;
import org.orange.pages.LoginPage;
import org.orange.pages.MenuSideBar;
import org.orange.utils.ReadPropertyFile;

import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {



    @Test(description = "Login page test")
    public void test1() throws Exception {


        LoginPage loginPage = new LoginPage();
        MenuSideBar menuSideBar =  new MenuSideBar();
        new DashboardPage();
        DashboardPage dashboardPage;
        dashboardPage = loginPage.loginUser(ReadPropertyFile.get("username"), ReadPropertyFile.get("password"));
        String attendanceDetails = dashboardPage.getAttendance();
        System.out.println("Attendance = " + attendanceDetails);
        String currentUser = dashboardPage.getUsernameTxtBox();
        System.out.println("Current user = " + currentUser);
        System.out.println(menuSideBar.clickMenuOptions().getPageURl());
        dashboardPage.logoutWebsite();
        String pageTitle = loginPage.getTitle();
        Assertions.assertThat(pageTitle)
                .isEqualTo("OrangeHRM");


    }


}