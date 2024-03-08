package utils;

import config.ConfigFactory;
import constants.StringConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public final class Utils {
    public static void click(By by, String waitStrategy){
        if (waitStrategy.equalsIgnoreCase(WaitStrategy.PRESENT.getWaitStrategy())) {
            waitUntilElementPresent(by).click();
        } else if (waitStrategy.equalsIgnoreCase(WaitStrategy.CLICKABLE.getWaitStrategy())) {
            waitUntilElementToBeClickable(by).click();
        }
    }
    public static void sendKeys(By by, String value){
        waitUntilElementPresent(by).sendKeys(value);
    }
    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private static WebElement waitUntilElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitUntilElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String getTitle(By by){
        return waitUntilElementPresent(by).getText();
    }

    public static void isEnabled(By by){
        waitUntilElementPresent(by).isEnabled();
    }

    public static Boolean isDisplayed(By by){
        return waitUntilElementVisible(by).isDisplayed();
    }
    public static void isSelected(By by){
        waitUntilElementPresent(by).isSelected();
    }
    public static void moveToElement(By by){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(waitUntilElementPresent(by)).build().perform();
    }

    public static void clickbyAction(By by, String waitStrategy){
        Actions action = new Actions(DriverManager.getDriver());
        if (waitStrategy.equalsIgnoreCase(WaitStrategy.PRESENT.getWaitStrategy())) {
            action.click(waitUntilElementPresent(by)).perform();
        } else if (waitStrategy.equalsIgnoreCase(WaitStrategy.VISIBLE.getWaitStrategy())) {
            action.click(waitUntilElementVisible(by)).perform();
        }

    }
    public static List<WebElement> getListOfElements(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeOut()));
        List<WebElement> lists = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return lists;
    }

    public static void scrollToTheEndOfPage(){
       JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public static void clickToTheRight(By btnToClcik, By nearToBtn){
        By create_insurance = RelativeLocator.with(btnToClcik).toRightOf(nearToBtn);
        waitUntilElementToBeClickable(create_insurance).click();
    }
    public static void uploadFile() {
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            //copy the path to the clipboard
            StringSelection ss = new StringSelection(StringConstants.BATCH_FILE_PATH);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            //Copy the File path
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            //Enter the file
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static String getCurrentUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void switchToFrameUsingElement(By by){
        DriverManager.getDriver().switchTo().frame(waitUntilElementPresent(by));
    }
    public static void switchToDefaultFrame(){
        DriverManager.getDriver().switchTo().defaultContent();
    }
}
