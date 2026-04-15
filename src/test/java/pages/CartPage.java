package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By productNames = By.cssSelector(DATA_TEST_PATTERN.formatted("inventory-item-name"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public List<String> getProductNames() {
        List<WebElement> allProducts = driver.findElements(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }
}
