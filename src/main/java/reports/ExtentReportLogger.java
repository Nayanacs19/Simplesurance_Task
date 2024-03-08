package reports;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

public final class ExtentReportLogger {
    private ExtentReportLogger() {
    }

    public static void pass(String message) throws IOException {
        ExtentReport.getExtentTest()
                .pass(message, MediaEntityBuilder
                        .createScreenCaptureFromBase64String(Utils.ScreenshotUtils.getScreenshot()).build());
    }

    public static void fail(String message) {
        ExtentReport.getExtentTest().fail(message, MediaEntityBuilder
                .createScreenCaptureFromBase64String(Utils.ScreenshotUtils.getScreenshot()).build());
    }

    public static void info(String message){
        ExtentReport.getExtentTest().info(message);
    }
}
