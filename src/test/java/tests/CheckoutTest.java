package tests;

import models.UserFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkSuccessfulCheckout() {
        loginPage.open();
        loginPage.login(UserFactory.getStandardUser());

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.getNavigationPanel().openCart();

        cartPage.checkout();

        assertEquals(checkoutPage.getTitle(), "Checkout: Your Information");

        checkoutPage.fillCheckoutForm("Ivan", "Ivanov", "12345");
        checkoutPage.continueCheckout();

        assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Overview");
        assertEquals(checkoutOverviewPage.getPaymentInformationLabelText(), "Payment Information:");

        checkoutOverviewPage.finishCheckout();

        assertEquals(checkoutOverviewPage.getCompleteHeaderText(), "Thank you for your order!");
    }
}
