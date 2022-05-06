package practice8;

import practice8.decorator.ButtonElement;
import practice8.decorator.InputElement;
import practice8.decorator.MyFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class GoogleSearchPOFactory {
    private final WebDriver driver;

    @FindBy(name = "q")
    private InputElement searchInput;

    @FindBy(xpath= "//*[@value='Google Search']")
    private ButtonElement searchButton;

    @FindBy(xpath = "//div[@id=\"rso\"]/div/div/div/div/a")
    private List<WebElement> resultLinkList;


    public GoogleSearchPOFactory(WebDriver driver) {
        this.driver=driver;

        PageFactory.initElements(new MyFieldDecorator(driver),this);

        driver.get("https://www.google.com/");
    }

    public GoogleSearchPOFactory search(String searchQueryText) {
        searchInput.input(searchQueryText
                //    + Keys.ENTER
        );
        return this;
    }

    public List<WebElement> getResultList() {
        return resultLinkList;
    }

    public ResultSearchPOFactory clickFirstResult() {
        getResultList().get(0).click();
        return new ResultSearchPOFactory(driver);
    }

    public void search() {
        searchButton.click();
    }
}