package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://www.saucedemo.com/";
    protected static final String DATA_TEST_PATTERN = "[data-test='%s']";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
