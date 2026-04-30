package pages;

import io.qameta.allure.Step;
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

    @Step("Открываем страницу авторизации")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Вводим логин и пароль для пользователя: {login}")
    public void login(String login, String password) {
        driver.findElement(userField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    @Step("Авторизуемся под пользователем")
    public void login(@NonNull User user) {
        login(user.getUsername(), user.getPassword());
    }

    @Step("Проверяем, что сообщение об ошибке отображается")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMsgText() {
        return driver.findElement(errorMessage).getText();
    }

    @Step("Проверяем цвет кнопки Login")
    public String getLoginButtonColor() {
        return driver.findElement(submitButton).getCssValue("background-color");
    }

    @Step("Пробуем открыть корзину без авторизации")
    public void openCartPage() {
        driver.get(BASE_URL + "cart.html");
    }
}
