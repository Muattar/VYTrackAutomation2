package com.vytrack.tests.components.login_Navigation;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.*;
import com.vytrack.pages.login_navigation.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginTest1() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dashboard");
    }

    @Test
    public void negativeLoginTest1() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");

    }
}