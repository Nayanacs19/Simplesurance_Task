package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.base.Throwables;
import org.testng.ITestResult;

import java.io.IOException;

public final class ExtentReportLogger {
    private ExtentReportLogger() {
    }

    public static void pass(ITestResult result) throws IOException {
        ExtentReport.getExtentTest()
                .pass(result.getName()+ " is Passed", MediaEntityBuilder
                        .createScreenCaptureFromBase64String(Utils.ScreenshotUtils.getScreenshot()).build());
    }

    public static void fail(ITestResult result) {
        ExtentReport.getExtentTest().
                fail(result.getThrowable(), MediaEntityBuilder
                .createScreenCaptureFromBase64String(Utils.ScreenshotUtils.getScreenshot()).build());
    }

    public static void info(String message){
        ExtentReport.getExtentTest().info(message);
    }
}
