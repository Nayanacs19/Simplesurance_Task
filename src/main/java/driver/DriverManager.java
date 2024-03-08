package driver;

import static constants.StringConstants.*;
import config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(String browser) {
        WebDriver driver;
        System.out.printf("testing driver");
        if (ConfigFactory.getConfig().browser().equalsIgnoreCase(CHROME)){
//            System.setProperty("webdriver.chrome.driver","C:\\Users\\nayan\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (ConfigFactory.getConfig().browser().equalsIgnoreCase(FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
