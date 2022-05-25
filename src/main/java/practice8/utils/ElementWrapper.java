package practice8.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ElementWrapper {
    private final WebElement element;
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public ElementWrapper(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
        LOGGER.info("Click on " + element.getTagName());
    }

    public void sendKeys(String keys) {
        element.sendKeys(keys);
        LOGGER.info("Sending keys " + keys + " for " + element.getTagName());
    }
}
