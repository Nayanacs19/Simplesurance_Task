package tests;

import config.ConfigFactory;
import driver.Driver;
import pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        Driver.initDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithCredentials(ConfigFactory.getConfig().username(), ConfigFactory.getConfig().password());
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
