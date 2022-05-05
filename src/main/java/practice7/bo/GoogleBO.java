package practice7.bo;

import practice7.po.GoogleSearchPO;
import practice7.po.ResultSearchPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;

public class GoogleBO {
    private WebDriver driver;

    public GoogleBO(WebDriver driver) {
        this.driver=driver;
    }

    private GoogleSearchPO googleSearchPO;
    private ResultSearchPO resultSearchPO;

    public GoogleBO goToGoogle() {
        //STEP _ 0 go to google
        googleSearchPO=new GoogleSearchPO(driver);
        return this;
    }

    public GoogleBO search(String searchQueryText) {
        //STEP _ 1 Try search
        googleSearchPO.search(searchQueryText);
        return this;
    }

    public GoogleBO printSearchResult() {
        //STEP _ 2 print search result
        searchResultList= googleSearchPO.getResultList();
        searchResultList.forEach(e-> System.out.println(e.getText()+"\t"+e.getAttribute("href")));
        expectedURL= searchResultList.get(0).getAttribute("href");
        return this;
    }

    private List<WebElement> searchResultList;
    private String expectedURL;

    public GoogleBO clickFirstResult() {
        //STEP _ 3 select first result
        resultSearchPO = googleSearchPO.clickFirstResult();
        return this;
    }

    public void validateURL() {
        //STEP _ 4 validate URL
        Assert.assertEquals(resultSearchPO.getUrl(),expectedURL,"invalid result URL");
    }
}