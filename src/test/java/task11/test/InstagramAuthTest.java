package task11.test;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import drivers.DriverManager;
import org.testng.annotations.*;
import task11.elements.InstagramAuthTestBO;
import task13.listeners.CustomSuiteListener;
import task13.listeners.CustomTestListener;
import task14.AllureListener;

@Listeners({
        UniversalVideoListener.class,
        CustomSuiteListener.class,
        CustomTestListener.class,
        AllureListener.class
})
public class InstagramAuthTest {

    @BeforeTest
    void init() {
        DriverManager.setupChromeDriver();
    }

    @DataProvider
    Object[][] instagramAuthProvider() {
        return new Object[][]{
                {"user1212323", "12323345"},
                {"user123434523", "456567565234"},
                {"user123123", "user123123"},
                {"aqatest12", "AQAAuthenticationTest"}
        };
    }

    @Test(dataProvider = "instagramAuthProvider")
    @Video(name = "Instagram_auth")
    void instagramAuthTest(String login, String password) {
        InstagramAuthTestBO instagramAuthTestBO = new InstagramAuthTestBO();
        instagramAuthTestBO
                .openLoginPage()
                .login(login, password)
                .verifyLogin();
    }

    @AfterTest
    void closeSession() {
        DriverManager.closeDriver();
    }
}