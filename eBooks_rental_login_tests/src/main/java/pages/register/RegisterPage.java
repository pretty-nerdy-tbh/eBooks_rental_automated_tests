package pages.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterLogin(String login){
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys(login);
    }

    public void enterPassword(String password){
        WebElement loginField = driver.findElement(By.name("password"));
        loginField.sendKeys(password);
    }

    public void confirmPassword(String password){
        WebElement loginField = driver.findElement(By.name("password-repeat"));
        loginField.sendKeys(password);
    }

    public void loginButton(){
        WebElement loginButton = driver.findElement(By.id("register-btn"));
        loginButton.click();
    }

}
