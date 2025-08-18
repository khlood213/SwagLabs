package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckOutStepTwo {
    WebDriver driver;
    public P05_CheckOutStepTwo(WebDriver driver){
        this.driver=driver;
    }
    private final By finishbtn= By.xpath("//div/a[@class=\"btn_action cart_button\"]");

    public void clickonfinish(){
        driver.findElement(this.finishbtn).click();
    }
}
