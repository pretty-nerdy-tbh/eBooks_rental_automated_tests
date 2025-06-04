package pages.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
    }

    @Test
    void testLoginPage_CheckPositiveValidation(){
        loginPage.enterLogin("testLogin");
        loginPage.enterPassword("testPassword");
        loginPage.loginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(url -> url.getCurrentUrl().equals("https://ta-bookrental-fe.onrender.com/"));
        assertEquals("https://ta-bookrental-fe.onrender.com/", driver.getCurrentUrl());
    }

    @Test
    void testLoginPage_CheckNegativeValidation(){
        loginPage.enterLogin("testWrongLogin");
        loginPage.enterPassword("testWrongPassword");
        loginPage.loginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        assertEquals("Login failed", driver.findElement(By.className("alert__content")).getText());
    }

    @Test
    void testLoginPage_CheckEmptyLoginValidation(){
        loginPage.enterLogin("testLogin");
        loginPage.loginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        assertEquals("You can't leave fields empty", driver.findElement(By.className("alert__content")).getText());
    }

    @Test
    void testLoginPage_CheckEmptyPasswordValidation(){
        loginPage.enterPassword("testPassword");
        loginPage.loginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        assertEquals("You can't leave fields empty", driver.findElement(By.className("alert__content")).getText());
    }

    @Test
    void testLoginPage_CheckEmptyFieldsValidation(){
        loginPage.loginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        assertEquals("You can't leave fields empty", driver.findElement(By.className("alert__content")).getText());
    }

    @AfterEach
    void testDown(){
        loginPage.loginClose();
    }

}