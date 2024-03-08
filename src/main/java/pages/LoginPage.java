package pages;

import static utils.Utils.*;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private static By USERNAME = By.id("login_username");
    private static By PASSWORD = By.id("login_password");
    private static By LOGIN = By.xpath("//button[@type='submit']");
    private static By LANGUAGE_BTN = By.xpath("//button[@type='button']");
    private static By PAGE_TITLE = By.xpath("//h5[text(),'Insurance Manager']");
    private static By LANGUAGE_LIST = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @role='menu']/li");

    private static By ENGLISH = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @role='menu']//li[@tabindex='-1']");

    public String getLoginTitle(){
        return getTitle(PAGE_TITLE);
    }

    public String getLanguage(){
        return getTitle(LANGUAGE_BTN);
    }

    public void clickToChangeLanguage(){
        click(LANGUAGE_BTN, WaitStrategy.CLICKABLE.getWaitStrategy());
    }
    private LoginPage enterUsername(String username){
        sendKeys(USERNAME, username);
        return this;
    }
    private LoginPage enterPassword(String password){
        sendKeys(PASSWORD, password);
        return this;
    }
    private ImportAndSortInsurance clickOnLogin(){
        click(LOGIN, WaitStrategy.CLICKABLE.getWaitStrategy());
        return new ImportAndSortInsurance();
    }

    public ImportAndSortInsurance loginWithCredentials(String username, String password){
        return enterUsername(username).
                enterPassword(password).
                clickOnLogin();
    }
    public void selectEnglishLanguage(){
        click(ENGLISH, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public ArrayList<String> listOfLanguages(){
        List<WebElement> list = getListOfElements(LANGUAGE_LIST);
        ArrayList<String> actualList = new ArrayList<>();

        for (int i = 0; i<list.size(); i++){
            actualList.add(list.get(i).getText());
        }
        return actualList;
    }
}
