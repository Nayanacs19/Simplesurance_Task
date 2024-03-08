package driver;

import config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class Driver {

    private Driver(){}

    public static void initDriver() {
        WebDriver driver = DriverManager.getDriver(ConfigFactory.getConfig().browser());
        DriverManager.setDriver(driver);
        System.out.println(ConfigFactory.getConfig().Url());
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ConfigFactory.getConfig().Url());
        DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeOut(), TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        DriverManager.getDriver().quit();
    }
}
