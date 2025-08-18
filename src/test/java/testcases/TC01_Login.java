package testcases;


import org.testng.annotations.Test;
import pages.P01_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC01_Login extends TestBase {

    P01_LoginPage loginPage;

    String username = "standard_user";
    String password = "secret_sauce";

    @Test(priority = 1, description = "Login to SwagLabs Web App using Valid Data")
    public void validateLoginToSwagLabsUsingValidCredientials_P() {
        loginPage = new P01_LoginPage(getDriver());

        loginPage.login(username, password);
    }

    // negative scenarios
    @Test(priority = 2, description = "Login to SwagLabs using invalid username")
    public void checkLoginWithInvalidUsername_N() {
        loginPage = new P01_LoginPage(getDriver());

        username = "Testtest";
        loginPage.login(username, password);
    }

    @Test(priority = 3, description = "Login to SwagLabs using invalid password")
    public void checkLoginWithInvalidPassword_N() {
        loginPage = new P01_LoginPage(getDriver());

        password = "password@123";
        username = "standard_user";

        loginPage.login(username, password);
    }

    @Test(priority = 4, description = "Login to SwagLabs using invalid username andpassword")
    public void checkLoginWithInvalidUsernameAndPassword_N() {
        loginPage = new P01_LoginPage(getDriver());

        password = "password@123";
        username = "testtest";

        loginPage.login(username, password);
    }

}
