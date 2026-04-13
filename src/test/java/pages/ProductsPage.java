package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public String getCartBadgeText() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
