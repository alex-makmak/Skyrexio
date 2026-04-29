package pages;

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

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void continueCheckout() {
        driver.findElement(continueButton).click();
    }
}
