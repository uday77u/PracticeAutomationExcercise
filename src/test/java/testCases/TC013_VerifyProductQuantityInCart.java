/*
 * Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
 */
package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

public class TC013_VerifyProductQuantityInCart extends BaseClass{

	@Test(description = "VerifyProductQuantityInCart")
    public void VerifyProductQuantityInCart() throws InterruptedException {
		try {
		HomePage home = new HomePage(driver);
        ProductDetailsPage proDetail=new ProductDetailsPage(driver);
        
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC013_VerifyProductQuantityInCart");
	    
        

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);
   
        //step 4-5: Click 'View Product' for any product on home page, Verify product detail is opened
        logger.info("Step 4: Click 'View Product' for any product on home page");
         home.clickBtnViewProduct4();
         
         logger.info("Step 5: Verify product detail is opened");
         assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
         
        //step 6-8: Increase quantity to 4, Click 'Add to cart' button, Click 'View Cart' button
         logger.info("Step 6: Increase quantity to 4");
         
         
         logger.info("Step 7: Click 'Add to cart' button");
         String qty="4";
         Thread.sleep(3000);
         proDetail.setQuantity(qty);
         Thread.sleep(3000);
         proDetail.clickBtnAddToCart();
         Thread.sleep(3000);
         
         logger.info("Step 8: Click 'View Cart' button");
         proDetail.clickLnkViewCart();

         
        //step 9: Verify that product is displayed in cart page with exact quantity
         logger.info("Step 9: Verify that product is displayed in cart page with exact quantity");
         assertEquals(proDetail.getQtyInCart(),qty,"Mis match in quantity");

		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in VerifyProductQuantityInCart: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in VerifyProductQuantityInCart: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
         logger.debug("application logs end.......");
     	logger.info("**** finished TC013_VerifyProductQuantityInCart  *****"); 
         
        
}
}
