package practice8;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GooglePOFactoryTest {
    private WebDriver driver;

    @BeforeTest
    void initDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }

    @Test
    void googleTest(){
        GoogleBOFactory googleBO=new GoogleBOFactory(driver);
        googleBO
                .goToGoogle()
                .search("search Query Text")
                .printSearchResult()
                .clickFirstResult()
                .validateURLHost();
    }

    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }

}