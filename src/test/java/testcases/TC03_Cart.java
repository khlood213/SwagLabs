package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_inventoryPage;
import pages.P03_CartPage;

import static drivers.DriverHolder.getDriver;

public class TC03_Cart extends TestBase{
    P02_inventoryPage inventoryPage;
    P01_LoginPage loginPage;
    P03_CartPage cartPage;
    String username = "standard_user";
    String password = "secret_sauce";
    @Test(priority = 1 , description = "validate cart list")
    public void addToCart(){
        loginPage=new P01_LoginPage(getDriver());
        inventoryPage=new P02_inventoryPage(getDriver());
        cartPage=new P03_CartPage(getDriver());
        loginPage.login(username,password);
        Assert.assertTrue(inventoryPage.isaddtocartdisplayed(), "no");
        double totalPrice = inventoryPage.addRandomNumberOfProductsToCartAndGetTotalPrice();
        System.out.println("Total price of randomly added products: $" + totalPrice);
        inventoryPage.goToCart();
        cartPage.clickCheckOut();

    }
}
