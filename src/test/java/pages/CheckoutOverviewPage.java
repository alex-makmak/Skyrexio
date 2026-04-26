package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage {

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By paymentInformationLabel = By.cssSelector(DATA_TEST_PATTERN.formatted("payment-info-label"));
    private final By finishButton = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));
    private final By completeHeader = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    public String getPaymentInformationLabelText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInformationLabel));
        return driver.findElement(paymentInformationLabel).getText();
    }

    public void finishCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
    }

    public String getCompleteHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader));
        return driver.findElement(completeHeader).getText();
    }
}
