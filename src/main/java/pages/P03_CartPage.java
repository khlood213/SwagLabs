package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    // define webdriver
    WebDriver driver;
    //constructor
    public P03_CartPage(WebDriver driver){
        this.driver=driver;
    }
    //loctors
    private final By checkoutBtn = By.xpath("//a[@href=\"./checkout-step-one.html\"]");

    // public actions methods
    public void clickCheckOut(){
        driver.findElement(checkoutBtn).click();
    }
}
