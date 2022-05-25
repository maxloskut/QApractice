package practice8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practice8.utils.ElementWrapper;

public class PageObject {
    WebDriver _driver = BrowserFactory.getDriver();

    @FindBy(xpath = "//input[contains(@name, 'username')]")
    private WebElement loginInput;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Search input')]")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@href, '/kittens_of_world/')]")
    private WebElement kittensButton;

    private ElementWrapper loginWrapper;
    private ElementWrapper passwordWrapper;
    private ElementWrapper submitButtonWrapper;
    private ElementWrapper searchInputWrapper;
    private ElementWrapper kittensButtonWrapper;
    public PageObject() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
        loginWrapper = new ElementWrapper(loginInput);
        passwordWrapper = new ElementWrapper(passwordInput);
        submitButtonWrapper = new ElementWrapper(submitButton);
        searchInputWrapper = new ElementWrapper(searchInput);
        kittensButtonWrapper = new ElementWrapper(kittensButton);
    }

    public PageObject openWebPage(String url) {
        BrowserFactory.getDriver().get(url);
        return this;
    }

    public PageObject login() {
        waitFor("//input[contains(@name, 'username')]");
        loginWrapper.sendKeys("squadoffi@gmail.com");
        passwordWrapper.sendKeys("TestPassword123");
        submitButtonWrapper.click();
        return this;
    }

    public PageObject search() {
        waitFor("//input[contains(@aria-label, 'Search input')]");
        searchInputWrapper.sendKeys("kittens");
        waitFor("//a[contains(@href, '/kittens_of_world/')]");
        kittensButtonWrapper.click();
        return this;
    }

    private void waitFor(String xpath) {
        WebDriverWait wait = BrowserFactory.driverWait(5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
