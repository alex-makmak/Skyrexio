package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By firstNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCodeField = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueButton = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Смотрим заголовок страницы оформления заказа")
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    @Step("Заполняем данные покупателя")
    public CheckoutPage fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);

        return this;
    }

    @Step("Переходим к проверке заказа")
    public CheckoutPage continueCheckout() {
        driver.findElement(continueButton).click();

        return this;
    }
}
