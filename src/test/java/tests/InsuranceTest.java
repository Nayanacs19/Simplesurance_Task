package tests;

import constants.StringConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ImportAndSortInsurance;
import pages.NewInsurancePage;
import testdata.TestDataExcel;

import java.util.ArrayList;

public class InsuranceTest extends BaseTest{
    ImportAndSortInsurance importAndSortInsurance = new ImportAndSortInsurance();
    NewInsurancePage newInsurancePage = new NewInsurancePage();

    @DataProvider
    public Object[][] customerDetails() {
        return TestDataExcel.readTestData();
    }

    @Test
    public void createInsuranceByImportButtonValidationTest() throws InterruptedException {
        importAndSortInsurance.clickOnImportButton();
        Assert.assertEquals(importAndSortInsurance.getPageTitle(), StringConstants.IMPORT_PAGE_TITLE,"Import page is not loaded.");
        importAndSortInsurance.uploadInsurancesFromImportButton();
        importAndSortInsurance.clickOnCreateInsuraceWithBatch();
        Assert.assertTrue(importAndSortInsurance.isPolicyNumberCreated(),"Error occured and policy number is not created");
    }

    @Test
    public void createInsuranceByCloudButtonValidationTest() {
        importAndSortInsurance.clickOnImportButton();
        importAndSortInsurance.uploadInsurancesFromCloudButton();
        importAndSortInsurance.clickOnCreateInsuraceWithBatch();
        Assert.assertTrue(importAndSortInsurance.isPolicyNumberCreated(),"Error occured and policy number is not created");
    }

    @Test(dataProvider = "customerDetails")
    public void createNewInsuranceTest(String fname, String lname, String email, String street, String houseNum,
                                   String zip, String city, String country) throws InterruptedException {
        importAndSortInsurance.clickOnNewInsurance();
        newInsurancePage.enterProductDetails();
        Assert.assertTrue(newInsurancePage.isProductDetailsCompleted(), "Failed to enter all the product details");
        newInsurancePage.enterCustomerDetails(fname, lname, email, street, houseNum, zip, city, country);
        newInsurancePage.confirmToTermsAndCondtions();
        Assert.assertTrue(newInsurancePage.isPaymentOptionDisplayed(),"Insurance creation is unsuccessful");
        //newInsurancePage.selectPaymentMethod();
        newInsurancePage.confirmToPay();
        newInsurancePage.enterCardDetails();
        newInsurancePage.payAndCreateInsurance();
        Assert.assertTrue(newInsurancePage.isPolicyNumberCreated(),"Error creating Policy Number");
    }

    @Test
    public void sortPoliciesWithPolicyNumberTest() throws InterruptedException {
        ArrayList<Long> expectedSortedList =newInsurancePage.getPolicies();
        newInsurancePage.clickOnSortUsingPolicyNumber();
        ArrayList<Long> actualSortedlist = newInsurancePage.getPolicies();
        Assert.assertTrue(expectedSortedList.equals(actualSortedlist),"Unable to sort the Policies");
    }
}
