package org.orange.pages;
import org.openqa.selenium.By;
import org.orange.enums.WaitStrategy;

public final class LoginPage extends BasePage{


    private final By usernameField = By.cssSelector( "input[name='username']");
    private final By passwrdField = By.cssSelector("input[name='password']");
    private final By loginBtn = By.cssSelector("button[type='submit']");


    private LoginPage enterUserName(String username) throws Exception {
        sendKeys(usernameField,username);
        return this;
    }

    private LoginPage enterPasswrd(String passwd) throws Exception {
        sendKeys(passwrdField,passwd);
        return this;
    }

    private LoginPage clickLoginBtn() throws Exception {
        doClick(loginBtn, WaitStrategy.CLICKABLE);
        return this;
    }
    public DashboardPage loginUser(String username,String password) throws Exception {
        enterUserName(username)
                .enterPasswrd(password)
                .clickLoginBtn();
        return new DashboardPage();
    }
    public String getTitle(){
      return  getPageTitle();
    }






}
