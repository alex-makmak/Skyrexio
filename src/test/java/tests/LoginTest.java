package tests;

import models.UserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login(UserFactory.getStandardUser());

        assertEquals(productsPage.getTitle(), "Products");
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

    @Test(dataProvider = "incorrectLoginData")
    public void checkIncorrectLoginWithDataProvider(String login, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(login, password);

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsgText(), expectedErrorMessage);
    }

    @Test
    public void checkLoginButtonColor() {
        loginPage.open();

        assertEquals(loginPage.getLoginButtonColor(), "rgba(61, 220, 145, 1)");
    }

    @Test
    public void checkOpenCartWithoutLogin() {
        loginPage.openCartPage();

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
    }
}
