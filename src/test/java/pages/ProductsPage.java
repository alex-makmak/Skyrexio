package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']" +
                    "/ancestor::div[@class='inventory_item']" +
                    "//button[text()='Add to cart']";

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final NavigationPanel navigationPanel;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.navigationPanel = new NavigationPanel(driver);
    }

    @Step("Смотрим заголовок страницы с товарами")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Кладём товар в корзину: {productName}")
    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(productName));
        driver.findElement(addToCartButton).click();
    }

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }
}
