package practice7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InstagramLoginTest {
    @DataProvider(parallel = true, name = "browserDataProvider")
    public static Object[][] browserDataProvider() {
        return new Object[][]{{"chrome"}};
    }

    String URL = "https://www.instagram.com/";

    @Test(dataProvider = "browserDataProvider")
    public void loginTest(String browserName) {
        BrowserFactory.initBrowser(browserName);
        PageObject pageObject = new PageObject();
        pageObject.openWebPage(URL);
        pageObject.enterCredentials();
    }

    @AfterMethod
    void quitBrowser() {
        BrowserFactory.getDriver().quit();
    }
}
