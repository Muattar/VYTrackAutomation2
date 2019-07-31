package com.vytrack.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TestBase {


    protected WebDriver driver;
    protected Actions action;


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }


}
