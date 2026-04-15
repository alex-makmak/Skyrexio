package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']" +
                    "/ancestor::div[@class='inventory_item']" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(productName));
        driver.findElement(addToCartButton).click();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
