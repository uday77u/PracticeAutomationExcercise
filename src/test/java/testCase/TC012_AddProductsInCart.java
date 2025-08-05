/*
 * Test Case 12: Add Products in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
 */
package testCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC012_AddProductsInCart extends BaseClass {
	@Test(description = "AddProductsInCart")
    public void VerifyAddProductsInCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);
        
        //Step 4-5: Click 'Products' button, Hover over first product and click 'Add to cart'
        home.clickProducts();
        ProductsPage product=new ProductsPage(driver);
         Actions act = new Actions(driver);
         act.moveToElement(product.LocatorBtnAddToCartProduct1()).perform();
         Thread.sleep(3000);
         //sol1
         //product.clickbtnAddToCartProduct1();
         
         //sol2
         //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
         //wait.until(ExpectedConditions.elementToBeClickable(product.LocatorBtnAddToCartProduct1()));
         //product.clickbtnAddToCartProduct1();
         
         //sol3
         //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product.LocatorBtnAddToCartProduct1());
         //product.LocatorBtnAddToCartProduct1().click();
         
         //final soln
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.LocatorBtnAddToCartProduct1());
         
         Thread.sleep(3000);
        
        //Step 6-7: Click 'Continue Shopping' button, Hover over second product and click 'Add to cart'
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.btnContinueShopping);
        // product.clickBtnContinueShopping();
         Thread.sleep(3000);
         act.moveToElement(product.LocatorBtnAddToCartProduct3());
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.LocatorBtnAddToCartProduct3());
         
         Thread.sleep(3000);
        //Step 8-9: Click 'View Cart' button, Verify both products are added to Cart
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.btnViewCart);
         //product.clickBtnViewCart();
         Thread.sleep(3000);
         assertTrue(driver.getPageSource().contains(product.LocatorBtnAddToCartProduct1().getText()), "Product1 is not added to cart");
         assertTrue(driver.getPageSource().contains(product.LocatorBtnAddToCartProduct3().getText()), "Product3 is not added to cart");

         
        //Step 10. Verify their prices, quantity and total price

}
}
