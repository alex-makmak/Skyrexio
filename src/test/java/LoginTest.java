import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void checkLogin() {
        ChromeOptions options = new ChromeOptions();

        WebDriver browser = new ChromeDriver(options);

        try {
            browser.get("https://www.saucedemo.com/");

            browser.findElement(By.id("user-name")).clear();
            browser.findElement(By.id("user-name")).sendKeys("standard_user");

            browser.findElement(By.id("password")).sendKeys("secret_sauce");
            browser.findElement(By.id("login-button")).click();

            String title = browser.findElement(By.cssSelector("[data-test='title']")).getText();
            assertEquals(title, "Products");
        } finally {
            browser.quit();
        }
    }
}