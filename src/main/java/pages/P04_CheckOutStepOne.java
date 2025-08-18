package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckOutStepOne {
    WebDriver driver;
    public P04_CheckOutStepOne(WebDriver driver){
        this.driver=driver;
    }
    private final By fname = By.id("first-name");
    private final By lname = By.id("last-name");
    private final By zipCode= By.id("postal-code") ;
    private final By continuebtn = By.xpath("//div/input[@value=\"CONTINUE\"]");

    public void checkoutinfo(String fname, String lname , String zipCode){
        driver.findElement(this.fname).sendKeys(fname);
        driver.findElement(this.lname).sendKeys(lname);
        driver.findElement(this.zipCode).sendKeys(zipCode);
        driver.findElement(this.continuebtn).click();
    }
}
