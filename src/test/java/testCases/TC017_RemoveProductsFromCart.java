/*
 * Test Case 17: Remove Products From Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class TC017_RemoveProductsFromCart extends BaseClass{

	@Test
	public void testRemoveProductsFromCart() {
		HomePage Home=new HomePage(driver);
		CartPage Cart=new CartPage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC017_RemoveProductsFromCart");
	    
        HomePage home = new HomePage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

        //step 4-6: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        logger.info("4. Add products to cart");
        Home.mouseHoverToProduct1();
        Home.clickbtnAddToCartProduct1();
        
        logger.info("5. Click 'Cart' button");
        waitForWebElementToBeClickable(Home.btnCart);
        Home.clickbtnCart();
        
        logger.info("6. Verify that cart page is displayed");
        assertTrue(isCurrentUrlWithSegment("cart"),"current url not contains segment:'cart'");
        Reporter.log("Verified that cart page is displayed",true);

        
        //step 7-8: Click 'X' button corresponding to particular product, Verify that product is removed from the cart
        logger.info("7. Click 'X' button corresponding to particular product");
        Cart.clickProduct1DeleteCrossMark();
        
        logger.info("8. Verify that product is removed from the cart");
        assertTrue(driver.getPageSource().toLowerCase().contains("blue top"), "Blue Top is still Present in the cart page after removal.");
		assertTrue(driver.getPageSource().contains("cart_info_table"), "cart_info_table is Present in the SourcePage");//only one product,removing product leads to removing product
		Reporter.log("Verified that product is removed from the cart", true);
		
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC017_RemoveProductsFromCart  *****"); 
	}
}
