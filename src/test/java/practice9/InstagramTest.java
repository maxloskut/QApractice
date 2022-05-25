package practice9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import practice9.utils.AllureListener;

@Listeners({AllureListener.class})
public class InstagramTest {

    @DataProvider(parallel = true, name = "browserDataProvider")
    public static Object[][] browserDataProvider() {
        return new Object[][]{{"chrome"}};
    }

    String URL = "https://www.instagram.com/";

    @Test(dataProvider = "browserDataProvider")
    public void instagramTest(String browserName) {
        BrowserFactory.initBrowser(browserName);
        PageObject pageObject = new PageObject();
        pageObject.openWebPage(URL);
        pageObject.login();
        pageObject.search();
    }
}
