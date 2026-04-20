package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkAddProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");

        assertEquals(productsPage.getNavigationPanel().getCartBadgeText(), "1");
    }

    @Test
    public void checkOpenCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getTitle(), "Your Cart");
    }

    @Test
    public void checkAddedProductIsDisplayedInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getProductNames().get(0), "Sauce Labs Backpack");
    }

    @Test
    public void checkTwoAddedProductsAreDisplayedInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");

        assertEquals(productsPage.getNavigationPanel().getCartBadgeText(), "2");

        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getProductNames().size(), 2);
        assertEquals(cartPage.getProductNames().get(0), "Sauce Labs Backpack");
        assertEquals(cartPage.getProductNames().get(1), "Sauce Labs Bike Light");
    }
}
