package practice8;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class GoogleBOFactory {
    private WebDriver driver;


    public GoogleBOFactory(WebDriver driver) {
        this.driver=driver;
    }

    private GoogleSearchPOFactory googleSearchPO;
    private ResultSearchPOFactory resultSearchPO;

    @Step
    public GoogleBOFactory goToGoogle() {
        //STEP _ 0 go to google
        googleSearchPO=new GoogleSearchPOFactory(driver);
        return this;
    }

    @Step
    public GoogleBOFactory search(String searchQueryText) {
        //STEP _ 1 Try search
        googleSearchPO
                .search(searchQueryText)
                .search();
        ;
        return this;
    }

    @Step
    public GoogleBOFactory printSearchResult() {
        //STEP _ 2 print search result
        searchResultList= googleSearchPO.getResultList();
        searchResultList.forEach(e-> System.out.println(e.getText()+"\t"+e.getAttribute("href")));
        expectedURL= searchResultList.get(0).getAttribute("href");
        return this;
    }

    private List<WebElement> searchResultList;
    private String expectedURL;

    @Step
    public GoogleBOFactory clickFirstResult() {
        //STEP _ 3 select first result
        resultSearchPO = googleSearchPO.clickFirstResult();
        return this;
    }

    @Step
    public GoogleBOFactory validateURLHost() {
        //STEP _ 4 validate URL
        String actualHost=resultSearchPO.getUrl().split("/")[2];
        String expectedHost=expectedURL.split("/")[2];
        Assert.assertEquals(actualHost,expectedHost,"invalid result URL Host");
        return this;
    }

    @Step
    public void failStep() {
        Assert.assertTrue(false);
    }
}