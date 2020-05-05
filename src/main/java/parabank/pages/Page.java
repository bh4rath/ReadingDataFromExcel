package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.cssSelector(".login .button");
    private By usernameField = By.cssSelector("[name='username']");
    private By passwordFiled = By.cssSelector("[name='password']");

    public void login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordFiled).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickMenuLink(String name){
        driver.findElement(By.linkText(name)).click();
    }
}
