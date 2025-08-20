package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_inventoryPage;

import static drivers.DriverHolder.getDriver;

public class TC02_inventory extends TestBase{
    P02_inventoryPage inventoryPage;
    P01_LoginPage loginPage;
    String username = "standard_user";
    String password = "secret_sauce";
    @Test(priority = 1 , description="validate user navigated to the correct page after login")
    public void validatecorrectpage(){

        loginPage=new P01_LoginPage(getDriver());
        inventoryPage=new P02_inventoryPage(getDriver());
        //loginPage.login(username,password);

        //assert url
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
        System.out.println("the url assert is passed");
        //assertlabel
        Assert.assertTrue(inventoryPage.isLabelDisplayed("Products"),"no");
        System.out.println("the label is displyed");
        //assert add to cart
        Assert.assertTrue(inventoryPage.isaddtocartdisplayed(), "no");
        double totalPrice = inventoryPage.addRandomNumberOfProductsToCartAndGetTotalPrice();

        System.out.println("Total price of randomly added products: $" + totalPrice);
        inventoryPage.goToCart();

    }

}
