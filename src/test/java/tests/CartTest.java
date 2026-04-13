package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkAddProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();

        assertEquals(productsPage.getCartBadgeText(), "1");
    }

    @Test
    public void checkOpenCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.openCart();

        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkAddedProductIsDisplayedInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();
        productsPage.openCart();

        assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
    }
}
