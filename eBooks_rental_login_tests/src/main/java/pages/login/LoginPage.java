package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterLogin(String login){
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys(login);
    }

    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    public void loginButton(){
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void waitUntilLoggedIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sub-title flex-grow--1 margin-right--1")));
    }

    public void loginClose(){
        driver.close();
    }

}
