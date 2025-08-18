package pages;

import drivers.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage {

    //Step 1:  define webdriver
    WebDriver driver ;

    // Step2: constructor to initialize webdriver
    public P01_LoginPage(WebDriver driver){
        this.driver=driver;
    }

   // Step 3:  define locators using By
    private final By username=By.id("user-name");
    private final By password=By.id("password");
    private final By loginButton=By.id("login-button");


    //public actions methods
    public void login(String username, String password){
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();
    }




}
