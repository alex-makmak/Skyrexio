package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
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
}
