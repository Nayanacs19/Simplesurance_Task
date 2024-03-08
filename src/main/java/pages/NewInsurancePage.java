package pages;

import static utils.Utils.*;

import constants.StringConstants;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewInsurancePage {

    //Product details
    private static By LAND = By.id("country-select");
    private static By SELECTED_COUNTRY_GERMANY = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='country-select-label']//li[@data-value='DE']");
    private static By PRODUCT_NAME = By.id("product-name-select");
    private static By SELECTED_PRODUCT = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='product-name-select-label']//li");
    private static By RATES = By.id("tariff-name-select");
    private static By SELECTED_TARIFF = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='tariff-name-select-label']//li");
    private static By INSURANCE_CATEGORY = By.id("category-name-select");
    private static By SELECTED_INSURANCE_CATEGORY = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='category-name-select-label']//li");
    private static By DURATION = By.id("duration-select");
    private static By SELECTED_DURATION = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='duration-select-label']//li");
    private static By CLASS = By.id("class-name-select");
    private static By SELECTED_CLASS = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='class-name-select-label']//li");
    private static By PAYMENT = By.id("frequency-select");
    private static By SELECTED_PAYMENT = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9' and @aria-labelledby='frequency-select-label']//li");
    private static By SERIAL_NUMBER = By.xpath("//input[@id='input-createCertificate_serialNumber']");
    private static By NEXT_BUTTON = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//button[@tabindex=0]");
    private static By PRODUCT_DETAILS_COMLT_IMG = By.xpath("//*[local-name()='svg' and @data-testid='CheckCircleIcon']/*[local-name()='path']");
    private static By PRICE_BTN = By.xpath("//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']/parent::div");
    private static By CREATE_CANCEL_INSURANCE = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//button");

    //Customer details
    private static By FIRST_NAME = By.cssSelector("input[id='input-createCertificate_firstName']");
    private static By LAST_NAME = By.cssSelector("input[id='input-createCertificate_lastName']");
    private static By EMAIL = By.cssSelector("input[id='input-createCertificate_email']");
    private static By STREET_NAME = By.cssSelector("input[id='input-createCertificate_streetName']");
    private static By STREET_NUMBER = By.cssSelector("input[id='input-createCertificate_streetNumber']");
    private static By ZIP_CODE = By.cssSelector("input[id='input-createCertificate_zip']");
    private static By CITY = By.cssSelector("input[id='input-createCertificate_city']");
    private static By COUNTRY = By.cssSelector("input[id='input-createCertificate_country']");
    //Confirmation
    private static By CONFIRMATION_CHECKBOX = By.xpath("//input[@type='checkbox']//parent::span");
    private static By CREDIT_DEBIT_CARD_RADIO = By.xpath("//input[@type='radio' and value='STRIPE.CARD']");
    private static By CONFIRM_TO_PAY_BTN = By.xpath("//span[@class='MuiButton-label']//parent::button");
    private static By PAY_PAL_LABEL = By.xpath("//p[text()='PayPal']");

    //Card Details
    private static By CARD_NUMBER = By.xpath("//input[@name='cardnumber']");
    private static By EXP_DATE = By.xpath("//input[@name='exp-date']");
    private static By CVC_NUMBER = By.xpath("//input[@name='cvc']");
    private static By iFRAME = By.xpath("//div[@class='StripeElement StripeElement--empty']//div//iframe");
    private static By PLACE_ORDER = By.xpath("//div//button[1]");
    private static By POLICY_NUMBER = By.xpath("//table[@class='jss27']/tbody/tr[2]/td[2]/div");

    //Sorting Elements
    private static By SORT_BUTTON = By.xpath("//*[local-name()='svg' and @data-testid='ExpandMoreIcon']");
    private static By POLICY_NUM_TABLE = By.xpath("//table[@data-testid='policy-list']//tr//button");
    public void enterProductDetails() {
        click(LAND, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_COUNTRY_GERMANY, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(PRODUCT_NAME, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_PRODUCT, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(RATES, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_TARIFF, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(INSURANCE_CATEGORY, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_INSURANCE_CATEGORY, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(DURATION, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_DURATION, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(PAYMENT, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_PAYMENT, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(CLASS, WaitStrategy.CLICKABLE.getWaitStrategy());
        click(SELECTED_CLASS, WaitStrategy.CLICKABLE.getWaitStrategy());
        sendKeys(SERIAL_NUMBER, WaitStrategy.PRESENT.getWaitStrategy());
        click(NEXT_BUTTON, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public void enterCustomerDetails(String fname, String lname, String email, String street, String houseNum,
                                     String zip, String city, String country) {
        sendKeys(FIRST_NAME, fname);
        sendKeys(LAST_NAME, lname);
        sendKeys(EMAIL, email);
        sendKeys(STREET_NAME, street);
        sendKeys(STREET_NUMBER, houseNum);
        sendKeys(ZIP_CODE, zip);
        sendKeys(CITY, city);
        sendKeys(COUNTRY, country);
        clickToTheRight(CREATE_CANCEL_INSURANCE, PRICE_BTN);
    }
    public static void confirmToTermsAndCondtions () {
        scrollToTheEndOfPage();
        List<WebElement> elements = getListOfElements(CONFIRMATION_CHECKBOX);
        for (int i = 0; i <elements.size(); i++) {
            WebElement webElement = elements.get(i);
            webElement.click();
        }
        clickToTheRight(CREATE_CANCEL_INSURANCE, PRICE_BTN);
    }
    public Boolean isProductDetailsCompleted () {
        return isDisplayed(PRODUCT_DETAILS_COMLT_IMG);
    }

    public Boolean isPaymentOptionDisplayed(){
        return isDisplayed(PAY_PAL_LABEL);
    }

    public void selectPaymentMethod(){
        click(CREDIT_DEBIT_CARD_RADIO, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public void confirmToPay(){
        click(CONFIRM_TO_PAY_BTN, WaitStrategy.CLICKABLE.getWaitStrategy());
    }
    public void enterCardDetails(){
        switchToFrameUsingElement(iFRAME);
        sendKeys(CARD_NUMBER, StringConstants.CARD_NUMBER);
        sendKeys(EXP_DATE, StringConstants.EXP_DATE);
        sendKeys(CVC_NUMBER, StringConstants.CVC);
        switchToDefaultFrame();
    }

    public void payAndCreateInsurance(){
        click(PLACE_ORDER, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public Boolean isPolicyNumberCreated(){
        return isDisplayed(POLICY_NUMBER);
    }

    public void clickOnSortUsingPolicyNumber(){
        click(SORT_BUTTON, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public ArrayList<Long> getPolicies(){
        ArrayList<Long> policies = new ArrayList<Long>();
        List<WebElement> elements = getListOfElements(POLICY_NUM_TABLE);
        for (int i = 0; i <elements.size(); i++) {
            policies.add(Long.parseLong(elements.get(i).getText()));
        }
        return policies;
    }

    public ArrayList<Long> expectedPolicyList(){
        ArrayList<Long> policylist = getPolicies();
         Collections.sort(policylist);
         return policylist;
    }
}

