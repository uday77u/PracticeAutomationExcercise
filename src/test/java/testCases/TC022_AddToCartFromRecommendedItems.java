/*
 * Test Case 22: Add to cart from Recommended items
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC022_AddToCartFromRecommendedItems extends BaseClass{
	
	@Test
	public void testAddToCartFromRecommendedItems() throws InterruptedException {
		
		try {
		HomePage homePage=new HomePage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC022_AddToCartFromRecommendedItems");

		// Step 1-2: Navigate to home page and  Verify that home page is visible successfully
		logger.info("Step 1: Launching the browser");
		logger.info("Step 2: Navigating to baseURL: " + baseURL);
		driver.get(baseURL);
        
        logger.info("Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

        //step 3-4: Scroll to bottom of page, Verify 'RECOMMENDED ITEMS' are visible
        logger.info("3. Scroll to bottom of page");
        dragToViewWebElement(driver,homePage.LocatorMsgRecommendedItems() );
        Thread.sleep(3000);
        
        logger.info("4. Verify 'RECOMMENDED ITEMS' are visible");
        assertTrue(homePage.isRecommendedItems(), "Recommended items are not visible");
        assertFalse(homePage.areRecommendedItemsEmpty(),"Recommended items are not empty" );
        Reporter.log("Verify 'RECOMMENDED ITEMS' are visible");
        Thread.sleep(3000);
        
        //step 5-7: Click on 'Add To Cart' on Recommended product, Click on 'View Cart' button, Verify that product is displayed in cart page
        logger.info("5. Click on 'Add To Cart' on Recommended product");
        homePage.clickAddToCartRecommendedProduct4();
         Thread.sleep(3000);
         
         logger.info("6. Click on 'View Cart' button");
         homePage.clickBtnViewProduct4();
         Thread.sleep(3000);
         
         logger.info("7. Verify that product is displayed in cart page");
         assertTrue(isCurrentTitleWithSegment("cart"), "Unable to navigate to Cart page");
         
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in testAddToCartFromRecommendedItems: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in testAddToCartFromRecommendedItems: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
         logger.debug("application logs end.......");
     	logger.info("**** finished TC022_AddToCartFromRecommendedItems  *****"); 
        
	}
}
