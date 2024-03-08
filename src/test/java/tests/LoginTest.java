package tests;

import config.ConfigFactory;
import driver.Driver;
import constants.StringConstants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ImportAndSortInsurance;
import pages.LoginPage;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

    @Test
    public void languageChangeValidationTest(){
        loginPage.clickToChangeLanguage();
        Assert.assertTrue(StringConstants.expectedLanguageList.containsAll(loginPage.listOfLanguages()), "Supported languages are not correct;");
        loginPage.selectEnglishLanguage();
        Assert.assertEquals(loginPage.getLanguage(),StringConstants.ENGLISH, "Expected language is not selected");
    }

    @Test
    public void loginValidationTest(){
        ImportAndSortInsurance importAndSortInsurance = loginPage.loginWithCredentials(ConfigFactory.getConfig().username(), ConfigFactory.getConfig().password());
        String homePageTitle = importAndSortInsurance.getPageTitle();
        Assert.assertEquals(homePageTitle, StringConstants.HOME_PAGE_TITLE, "The titles did not match");
    }
}
