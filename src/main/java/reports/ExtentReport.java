package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.StringConstants;

public class ExtentReport {

    private static final ThreadLocal<ExtentTest> EXTENT_TEST_LOCAL = new ThreadLocal<>();
    static ExtentTest getExtentTest(){
        return EXTENT_TEST_LOCAL.get();
    }
    static void setExtentTestLocal(ExtentTest test){
        EXTENT_TEST_LOCAL.set(test);
    }
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    private ExtentReport(){}
    public static void initReports(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(StringConstants.REPORT_PATH);
        extentReports.attachReporter(sparkReporter);
    }
    public static void flushReports(){
        extentReports.flush();
    }
    public static void createTests(String test){
        extentTest = extentReports.createTest(test);
        setExtentTestLocal(extentTest);
    }
}
