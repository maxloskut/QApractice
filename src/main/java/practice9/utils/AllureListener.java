package practice9.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import practice9.BrowserFactory;

public class AllureListener implements ITestListener {


    @Attachment(value="Page screen", type="image/png")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) BrowserFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="{0}", type="text/plain")
    public String getDom(){
        return BrowserFactory.getDriver().getPageSource();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        getScreenshot();
        getDom();
    }
}