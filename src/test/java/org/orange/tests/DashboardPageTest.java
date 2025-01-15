package org.orange.tests;


import org.orange.pages.DashboardPage;
import org.orange.pages.LoginPage;
import org.orange.utils.ReadPropertyFile;
import org.testng.annotations.Test;



public class DashboardPageTest  extends  BaseTest{


    @Test(description = "dashboard page test")
    public void test2() throws Exception {
        LoginPage loginPage = new LoginPage();
        new DashboardPage();
        DashboardPage dashboardPage;
        dashboardPage = loginPage.loginUser(ReadPropertyFile.get("username"),ReadPropertyFile.get("password"));
        String attendanceDetails = dashboardPage.getAttendance();
        System.out.println("Attendance = "+attendanceDetails);
        String currentUser = dashboardPage.getUsernameTxtBox();
        System.out.println("Current user = "+currentUser);
        dashboardPage.logoutWebsite();
    }




}
