package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P02_inventoryPage {
    //define web driver
    WebDriver driver;
    //constructor to initilize webdriver
    public P02_inventoryPage(WebDriver driver){
        this.driver=driver;
    }
    //loctors using BY
    private final By productLabel = By.className("product_label");
    private final By addToCart = By.xpath("(//div/button[@class=\"btn_primary btn_inventory\"])[1]");
    private final By allproducts = By.id("inventory_container");
    private final By oneItem = By.xpath("//div[@class=\"inventory_item\"]");
    private final By itemprice = By.className("inventory_item_price");
    private final By cart = By.xpath("//a[@href=\"./cart.html\"]");


    //public actions methods
    public boolean isLabelDisplayed(String productLabel){
     String actualText= driver.findElement(this.productLabel).getText();
      return actualText.equals(productLabel)&&driver.findElement(this.productLabel).isDisplayed();
    }
    public boolean isaddtocartdisplayed(){
        return driver.findElement(addToCart).isDisplayed();
    }

     public List<WebElement> getAllProducts() {
        WebElement container = driver.findElement(allproducts);
        return container.findElements(oneItem);
    }

    public double addRandomNumberOfProductsToCartAndGetTotalPrice() {
        List<WebElement> products = getAllProducts();
        int count = util.Utility.getRandomNumber(1, products.size());

        Set<Integer> selectedIndexes = new HashSet<>();
        double totalPrice = 0.0;

        while (selectedIndexes.size() < count) {
            int randomIndex = util.Utility.getRandomNumber(0, products.size() - 1);
            if (selectedIndexes.contains(randomIndex)) continue;

            WebElement product = products.get(randomIndex);
            String priceText = product.findElement(itemprice).getText();  // e.g., "$29.99"
            double price = Double.parseDouble(priceText.replace("$", ""));

            product.findElement(addToCart).click();

            selectedIndexes.add(randomIndex);
            totalPrice += price;

            System.out.println("Added product index: " + randomIndex + ", price: $" + price);
        }

        System.out.println("Total products added: " + count);
        return totalPrice;
    }

    public void goToCart() {
        driver.findElement(cart).click();
    }
}


