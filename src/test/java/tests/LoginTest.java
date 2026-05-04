package tests;

import enums.TitleNaming;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import models.UserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("SauceDemo")
@Feature("Авторизация")
@Owner("Alex")
public class LoginTest extends BaseTest {

    @Story("Успешная авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Проверка успешной авторизации")
    public void checkLogin() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        assertEquals(productsPage.getTitle(), TitleNaming.PRODUCTS.getDisplayName());
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {
                        PropertyReader.getProperty("saucedemo.locked_user"),
                        PropertyReader.getProperty("saucedemo.password"),
                        "Epic sadface: Sorry, this user has been locked out."
                },
                {
                        "",
                        PropertyReader.getProperty("saucedemo.password"),
                        "Epic sadface: Username is required"
                },
                {
                        PropertyReader.getProperty("saucedemo.incorrect_user"),
                        "",
                        "Epic sadface: Password is required"
                }
        };
    }

    @Story("Ошибки при некорректной авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @Test(
            dataProvider = "incorrectLoginData",
            description = "Проверка ошибок при некорректной авторизации"
    )
    public void checkIncorrectLoginWithDataProvider(String login, String password, String expectedErrorMessage) {
        loginPage
                .open()
                .login(login, password);

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsgText(), expectedErrorMessage);
    }

    @Story("Внешний вид формы авторизации")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Проверка цвета кнопки Login")
    public void checkLoginButtonColor() {
        loginPage.open();

        assertEquals(loginPage.getLoginButtonColor(), "rgba(61, 220, 145, 1)");
    }

    @Story("Доступ к корзине без авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия корзины без авторизации")
    public void checkOpenCartWithoutLogin() {
        loginPage.openCartPage();

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
    }
}
