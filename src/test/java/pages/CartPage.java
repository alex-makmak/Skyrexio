package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By backpackItemName = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getItemName() {
        return driver.findElement(backpackItemName).getText();
    }
}
