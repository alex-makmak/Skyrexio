import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String title = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        By errorMessage = By.xpath("//*[@data-test='error']");

        boolean isErrorMsgDisplayed = driver.findElement(errorMessage).isDisplayed();
        assertTrue(isErrorMsgDisplayed, "The error message fails to appear");

        String errorText = driver.findElement(errorMessage).getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");
    }
}
