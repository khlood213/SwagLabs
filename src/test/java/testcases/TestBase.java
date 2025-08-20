package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {

    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    //setup browser
    public void setupBrowser(@Optional("chrome")String browser) {
        setDriver(getNewInstance(browser));
        getDriver().get("https://www.saucedemo.com/v1/");
    }
   /* @BeforeMethod
    public void navigateToLogin() {

        getDriver().get("https://www.saucedemo.com/v1/");}*/

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }
}
