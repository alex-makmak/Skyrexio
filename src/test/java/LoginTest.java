import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void checkLogin() {
        WebDriver browser = new ChromeDriver();

        try {
            browser.get("https://www.saucedemo.com/");

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