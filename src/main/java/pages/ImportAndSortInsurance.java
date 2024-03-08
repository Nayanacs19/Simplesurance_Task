package pages;

import static utils.Utils.*;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class ImportAndSortInsurance {
    private static By HOME_PAGE_TITLE = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h5 css-zq6grw']");
    private static By NEW_INSURANCE = By.xpath("//a[@href='/policy/create']//button");
    private static By IMPORT_BUTTON = By.xpath("//a[@href='/policy/import']//button");
    private static By FILE_UPLOAD = By.xpath("//*[local-name()='svg' and @data-testid='CloudUploadIcon']/*[local-name()='path']");
    private static By IMPORT_INSURANCES_BUTTON = By.xpath("//span[@role='button']");
    private static By CREATE_INSURANCE_IMPORT = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//button");
    private static By BATCH_UPLOAD_POLICY_NUMBER = By.xpath("//table[@class='MuiTable-root css-1owb465']//tr[1]/th[1]");
    public void uploadInsurancesFromCloudButton(){
        clickbyAction(FILE_UPLOAD, WaitStrategy.CLICKABLE.getWaitStrategy());
        uploadFile();
    }
    public void clickOnCreateInsuraceWithBatch(){
        click(CREATE_INSURANCE_IMPORT, WaitStrategy.CLICKABLE.getWaitStrategy());
    }
    public void clickOnImportButton(){
        click(IMPORT_BUTTON, WaitStrategy.CLICKABLE.getWaitStrategy());
    }
    public void uploadInsurancesFromImportButton() {
        click(IMPORT_INSURANCES_BUTTON,WaitStrategy.CLICKABLE.getWaitStrategy());
        uploadFile();
    }

    public String getPageTitle(){
        return getTitle(HOME_PAGE_TITLE);
    }
    public void clickOnNewInsurance(){
        click(NEW_INSURANCE, WaitStrategy.CLICKABLE.getWaitStrategy());
    }

    public Boolean isPolicyNumberCreated(){
        String policy_num = getTitle(BATCH_UPLOAD_POLICY_NUMBER);
        return policy_num.length()>0;
    }
}
