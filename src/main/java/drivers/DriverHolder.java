package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {
    //webdriver deifned as threadlocal
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //getter to return threadlocal driver
    public static synchronized WebDriver getDriver(){
        return driver.get();
    }
    //setter to set driver
    public static void setDriver(WebDriver driver){
        DriverHolder.driver.set(driver);

    }
}
