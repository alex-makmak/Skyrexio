package tests;

import enums.TitleNaming;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import models.UserFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("SauceDemo")
@Feature("Оформление заказа")
public class CheckoutTest extends BaseTest {

    @Story("Успешное оформление заказа")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alex")
    @Test(description = "Проверка успешного оформления заказа")
    public void checkSuccessfulCheckout() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.getNavigationPanel().openCart();

        cartPage.checkout();

        assertEquals(checkoutPage.getTitle(), TitleNaming.CHECKOUT_YOUR_INFORMATION.getDisplayName());

        checkoutPage
                .fillCheckoutForm("Ivan", "Ivanov", "12345")
                .continueCheckout();

        assertEquals(checkoutOverviewPage.getTitle(), TitleNaming.CHECKOUT_OVERVIEW.getDisplayName());
        assertEquals(checkoutOverviewPage.getPaymentInformationLabelText(), "Payment Information:");

        checkoutOverviewPage.finishCheckout();

        assertEquals(checkoutOverviewPage.getCompleteHeaderText(), "Thank you for your order!");
    }
}
