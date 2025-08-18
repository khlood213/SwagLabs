package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_inventoryPage;
import pages.P03_CartPage;
import pages.P04_CheckOutStepOne;

import static drivers.DriverHolder.getDriver;
import static util.Utility.generateRandomName;
import static util.Utility.generateRandomZip;

public class TC04_CheckOutStepOne extends TestBase{
    P04_CheckOutStepOne checkOutStepOne;
    P01_LoginPage loginPage;
    P03_CartPage cartPage ;
    P02_inventoryPage inventoryPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String fname =generateRandomName();
    String lname = generateRandomName();
    String zipCode =generateRandomZip();
    @Test(priority = 1 , description = "fill in required info to continue checkout process")
    public void fillininfo(){
checkOutStepOne =new P04_CheckOutStepOne(getDriver());
loginPage=new P01_LoginPage(getDriver());
inventoryPage=new P02_inventoryPage(getDriver());
cartPage=new P03_CartPage(getDriver());
loginPage.login(username,password);
double totalPrice = inventoryPage.addRandomNumberOfProductsToCartAndGetTotalPrice();
inventoryPage.goToCart();
cartPage.clickCheckOut();
checkOutStepOne.checkoutinfo(fname,lname,zipCode);
    }
}
