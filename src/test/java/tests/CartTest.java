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
@Feature("Корзина")
@Owner("Alex")
public class CartTest extends BaseTest {

    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка добавления товара в корзину")
    public void checkAddProductToCart() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        productsPage.addProductToCart("Sauce Labs Backpack");

        assertEquals(productsPage.getNavigationPanel().getCartBadgeText(), "1");
    }

    @Story("Открытие корзины")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка открытия корзины")
    public void checkOpenCart() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getTitle(), TitleNaming.YOUR_CART.getDisplayName());
    }

    @Story("Отображение товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Проверка отображения добавленного товара в корзине")
    public void checkAddedProductIsDisplayedInCart() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getProductNames().get(0), "Sauce Labs Backpack");
    }

    @Story("Отображение нескольких товаров в корзине")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка отображения двух добавленных товаров в корзине")
    public void checkTwoAddedProductsAreDisplayedInCart() {
        loginPage
                .open()
                .login(UserFactory.getStandardUser());

        productsPage
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light");

        assertEquals(productsPage.getNavigationPanel().getCartBadgeText(), "2");

        productsPage.getNavigationPanel().openCart();

        assertEquals(cartPage.getProductNames().size(), 2);
        assertEquals(cartPage.getProductNames().get(0), "Sauce Labs Backpack");
        assertEquals(cartPage.getProductNames().get(1), "Sauce Labs Bike Light");
    }
}
