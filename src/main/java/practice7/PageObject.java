package practice7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    @FindBy(xpath = "//input[contains(@name, 'username')]")
    private WebElement loginInput;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement submitButton;

    public PageObject() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public PageObject openWebPage(String url) {
        BrowserFactory.getDriver().get(url);
        return this;
    }

    public PageObject enterCredentials() {
        waitFor("//input[contains(@name, 'username')]");
        loginInput.sendKeys("squadoffi@gmail.com");
        passwordInput.sendKeys("TestPassword123");
        submitButton.click();
        return this;
    }

    private void waitFor(String xpath) {
        WebDriverWait wait = BrowserFactory.driverWait(5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
