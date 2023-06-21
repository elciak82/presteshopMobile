package utils.listeners;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestAllureListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(AndroidDriver androidDriver) {
        return ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I'm in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        AndroidDriver androidDriver = BaseTest.getDriver();

        if (androidDriver != null) {
            System.out.println("Screenshot captured for test case: " + getTestMethodName(iTestResult));
            saveScreenshotPNG(androidDriver);
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");


    }


}
