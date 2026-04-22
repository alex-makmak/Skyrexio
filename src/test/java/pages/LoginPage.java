package pages;

import models.User;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By userField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("login-button");
    private final By errorMessage = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        driver.findElement(userField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public void login(@NonNull User user) {
        login(user.getUsername(), user.getPassword());
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMsgText() {
        return driver.findElement(errorMessage).getText();
    }

    public String getLoginButtonColor() {
        return driver.findElement(submitButton).getCssValue("background-color");
    }

    public void openCartPage() {
        driver.get(BASE_URL + "cart.html");
    }
}
