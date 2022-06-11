package task10.test;

import drivers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import task10.elements.StackOverflowTestBO;


public class StackOverflowTest {

    @BeforeTest
    void init() {
        DriverManager.setupChromeDriver();
    }

    @Test
    void stackOverflowTest() {
        StackOverflowTestBO stackOverflowTestBO = new StackOverflowTestBO();
        stackOverflowTestBO.goToHomePage();
        stackOverflowTestBO.acceptCookies();
        stackOverflowTestBO.clickSignUp();
        stackOverflowTestBO.acceptCookies();
        stackOverflowTestBO.verifySignUpPage();
    }

    @AfterTest
    void closeSession() {
        DriverManager.closeDriver();
    }
}