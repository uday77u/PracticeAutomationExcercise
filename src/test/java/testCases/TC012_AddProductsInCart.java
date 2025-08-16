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
package testCases;

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
        ProductsPage product=new ProductsPage(driver);
        
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC012_AddProductsInCart");

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        //Step 4-5: Click 'Products' button, Hover over first product and click 'Add to cart'
        logger.info("Step 4: Click 'Products' button");
        home.clickProducts();

        
        logger.info("Step 5: Hover over first product and click 'Add to cart'");
         Actions act = new Actions(driver);
         act.moveToElement(product.LocatorBtnAddToCartProduct1()).perform();
         Thread.sleep(3000);
        
        
        //Step 6-7: Click 'Continue Shopping' button, Hover over second product and click 'Add to cart'
         logger.info("Step 6: Click 'Continue Shopping' button");
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.btnContinueShopping);
        // product.clickBtnContinueShopping();
         Thread.sleep(3000);
         
         logger.info("Step 7: Hover over second product and click 'Add to cart'");
         act.moveToElement(product.LocatorBtnAddToCartProduct3());
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.LocatorBtnAddToCartProduct3());
         
         Thread.sleep(3000);
        //Step 8-9: Click 'View Cart' button, Verify both products are added to Cart
         logger.info("Step 8: Click 'View Cart' button");
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.btnViewCart);
         //product.clickBtnViewCart();
         Thread.sleep(3000);
         
         logger.info("Step 9: Verify both products are added to Cart");
         assertTrue(driver.getPageSource().contains(product.LocatorBtnAddToCartProduct1().getText()), "Product1 is not added to cart");
         assertTrue(driver.getPageSource().contains(product.LocatorBtnAddToCartProduct3().getText()), "Product3 is not added to cart");

         
        //Step 10. Verify their prices, quantity and total price
         logger.info("Step 10: Verify their prices, quantity and total price--**Pending Skiped step**");
         
         
         logger.debug("application logs end.......");
     	logger.info("**** finished TC012_AddProductsInCart  *****"); 
}
}
