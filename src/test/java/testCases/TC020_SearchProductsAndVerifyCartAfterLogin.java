/*
 * Test Case 20: Search Products and Verify Cart After Login
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseClass;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC020_SearchProductsAndVerifyCartAfterLogin extends BaseClass {

	@Test
	public void testSearchProductsAndVerifyCartAfterLogin() {
		
		HomePage homePage=new HomePage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		CartPage cartPage=new CartPage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC020_SearchProductsAndVerifyCartAfterLogin");
	    
        HomePage home = new HomePage(driver);

     // Step 1-2: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

        //step 3-4: Click on 'Products' button, Verify user is navigated to ALL PRODUCTS page successfully
        logger.info("3. Click on 'Products' button");
         homePage.clickProducts();
         
         logger.info(" 4. Verify user is navigated to ALL PRODUCTS page successfully");
         assertTrue(isCurrentTitleWithSegment("All Products"),"Unable to navigated to ALL PRODUCTS page");
        Reporter.log("Verified user is navigated to ALL PRODUCTS page successfully");
        
        //step 5-6: Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible
        logger.info("5. Enter product name in search input and click search button");
        String searchedKey="Top";
        productsPage.setSearchProduct(searchedKey);
        productsPage.clickSubmitSearch();
        
        logger.info(" 6. Verify 'SEARCHED PRODUCTS' is visible");
        assertTrue(productsPage.msgSearchedProductsExist(),"'searched products' message is not visible");
        
       //step 7: Verify all the products related to search are visible
        logger.info("7. Verify all the products related to search are visible");
        SoftAssert sa=new SoftAssert();
        List<WebElement> displayedProductList = productsPage.getSearchedProductsList();
        sa.assertTrue(displayedProductList.size()>0,"No searched products found");
        Reporter.log("Total displayed products: "+displayedProductList.size(),true);        
        for (WebElement displayedProduct : displayedProductList) {
        	String displayedProductName = displayedProduct.getText().toLowerCase();
        	sa.assertTrue(displayedProductName.contains(searchedKey.toLowerCase()), "Mis match in displayed product:"+displayedProductName+" and searched product:"+searchedKey);
        }
        sa.assertAll();
        Reporter.log("all search related products are displayed");
        
       //step 8-9: Add those products to cart, Click 'Cart' button and verify that products are visible in cart
        //logger.info("8. Add those products to cart");
        //logger.info("9. Click 'Cart' button and verify that products are visible in cart");
        
       //step 10: Click 'Signup / Login' button and submit login details
       // logger.info("10. Click 'Signup / Login' button and submit login details");
        
       //step 11-12: Again, go to Cart page,Verify that those products are visible in cart after login as well
        //logger.info("11. Again, go to Cart page");
       // logger.info("12. Verify that those products are visible in cart after login as well");
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC020_SearchProductsAndVerifyCartAfterLogin  *****"); 
        
        
	}
}
