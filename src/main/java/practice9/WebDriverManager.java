package practice9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebDriverManager {
    public static WebDriver setupChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
