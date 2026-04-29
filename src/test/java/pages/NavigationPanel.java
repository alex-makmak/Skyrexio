package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {

    private final WebDriver driver;
    private static final String DATA_TEST_PATTERN = "[data-test='%s']";

    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем корзину")
    public void openCart() {
        driver.findElement(cartLink).click();
    }

    @Step("Смотрим количество товаров в корзине")
    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }
}
