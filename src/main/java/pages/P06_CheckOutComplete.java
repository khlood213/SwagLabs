package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CheckOutComplete {
    WebDriver driver;
    public P06_CheckOutComplete(WebDriver driver){
        this.driver=driver;
    }
    private final By successmsg=By.xpath("//div/h2[@class=\"complete-header\"]");

    public boolean displayedsuccessmsg(){
        return driver.findElement(successmsg).isDisplayed();


    }
}
