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
	public void testAddToCartFromRecommendedItems() {
		HomePage homePage=new HomePage(driver);
		
		// Step 1-2: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\n Navigate to home page and verified", true);
        
        //step 3-4: Scroll to bottom of page, Verify 'RECOMMENDED ITEMS' are visible
        dragToViewWebElement(driver,homePage.LocatorMsgRecommendedItems() );
        assertTrue(homePage.isRecommendedItems(), "Recommended items are not visible");
        assertFalse(homePage.areRecommendedItemsEmpty(),"Recommended items are not empty" );
        
        //step 5-7: Click on 'Add To Cart' on Recommended product, Click on 'View Cart' button, Verify that product is displayed in cart page
         homePage.clickAddToCartRecommendedProduct4();
         homePage.clickBtnViewProduct4();
         assertTrue(isCurrentTitleWithSegment("cart"), "Unable to navigate to Cart page");
        
	}
}
