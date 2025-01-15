package org.orange.tests;

import org.assertj.core.api.Assertions;
import org.orange.pages.DashboardPage;
import org.orange.pages.LoginPage;
import org.orange.utils.ReadPropertyFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

    @Test(description = "Login page test")
    public void test1() throws Exception {

        LoginPage loginPage = new LoginPage();
        new DashboardPage();
        DashboardPage dashboardPage;
        dashboardPage = loginPage.loginUser(ReadPropertyFile.get("username"), ReadPropertyFile.get("password"));
        String attendanceDetails = dashboardPage.getAttendance();
        System.out.println("Attendance = " + attendanceDetails);
        String currentUser = dashboardPage.getUsernameTxtBox();
        System.out.println("Current user = " + currentUser);
        dashboardPage.logoutWebsite();
        String pageTitle = loginPage.getTitle();
        Assertions.assertThat(pageTitle)
                .isEqualTo("OrangeHRM");


    }


}