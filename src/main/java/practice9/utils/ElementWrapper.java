package practice9.utils;

import org.openqa.selenium.WebElement;

public class ElementWrapper {
    private final WebElement element;

    public ElementWrapper(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public void sendKeys(String keys) {
        element.sendKeys(keys);
    }
}
