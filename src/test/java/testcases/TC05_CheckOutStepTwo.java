package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static drivers.DriverHolder.getDriver;
import static util.Utility.generateRandomName;
import static util.Utility.generateRandomZip;

public class TC05_CheckOutStepTwo extends TestBase{
    P05_CheckOutStepTwo checkOutStepTwo;
    P03_CartPage cartPage;
    P04_CheckOutStepOne checkOutStepOne;
    P01_LoginPage loginPage;
    P02_inventoryPage inventoryPage;
    P06_CheckOutComplete checkOutComplete;
    String username = "standard_user";
    String password = "secret_sauce";
    String fname =generateRandomName();
    String lname = generateRandomName();
    String zipCode =generateRandomZip();
    @Test(priority = 1 , description = "clcik on finish")
    public void clickOnFinish(){
        checkOutStepOne =new P04_CheckOutStepOne(getDriver());
        loginPage=new P01_LoginPage(getDriver());
        inventoryPage=new P02_inventoryPage(getDriver());
        cartPage=new P03_CartPage(getDriver());
        checkOutComplete=new P06_CheckOutComplete(getDriver());
        checkOutStepTwo=new P05_CheckOutStepTwo(getDriver());
        loginPage.login(username,password);
        double totalPrice = inventoryPage.addRandomNumberOfProductsToCartAndGetTotalPrice();
        inventoryPage.goToCart();
        cartPage.clickCheckOut();
        checkOutStepOne.checkoutinfo(fname,lname,zipCode);
        checkOutStepTwo.clickonfinish();
        Assert.assertTrue(checkOutComplete.displayedsuccessmsg(),"no");
    }
}
