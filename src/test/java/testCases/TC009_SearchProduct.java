/*
 * Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */
package testCases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC009_SearchProduct extends BaseClass{
	
	@Test(description = "SearchProduct")
    public void VerifySearchProduct() throws InterruptedException {
		logger.debug("logging started");
		logger.info("*****TC009_SearchProduct*****");
		try {
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);

        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        
        
       //step 4-5: Click on 'Products' button,Verify user is navigated to ALL PRODUCTS page successfully
        logger.info("Step 4: Click on 'Products' button");
        home.clickProducts();
        
        logger.info("Step 5: Verifying user is navigated to ALL PRODUCTS page successfully");
        assertEquals(driver.getTitle(), "Automation Exercise - All Products","Product page title mismatch");
        Reporter.log("Click on 'Products' button,Verify user is navigated to ALL PRODUCTS page successfully");
        
        
        //step 6-7: Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible
        logger.info("Step 6: Entering product name in search input and click search button");
        String searchedKey="Shirt".toLowerCase();
        ProductsPage products= new ProductsPage(driver);
        products.setSearchProduct(searchedKey);
        logger.info("Product name: "+searchedKey);
        logger.info("clicking on search button");
        products.clickSubmitSearch();
        
        logger.info("Step 7: Verify 'SEARCHED PRODUCTS' is visible");
        assertEquals(products.msgSearchedProductsExist(), true,"msg SearchedProducts is not exist");
        Reporter.log("Enter product name in search input and click search button, Verify 'SEARCHED PRODUCTS' is visible");
 
        //step 8: Verify all the products related to search are visible
        /* Improved alternate
        List<WebElement> searchedProducts = products.getSearchedProducts();
        assertEquals(searchedProducts.size() > 0, true, "No products found for the search.");

        for (WebElement product : searchedProducts) {
            String productName = product.getText().toLowerCase();
            assertEquals(productName.contains("shirt"), true, "Product not matching search: " + productName);
        }
        Reporter.log("All searched products contain the keyword 'shirt'", false);
        */

      //step 8: Verify all the products related to search are visible
        logger.info("Step 8: Verify all the products related to search are visible");
        List<WebElement> searchedProducts=products.getSearchedProductsList();
        assertEquals(searchedProducts.size()>0, true,"No products found for the search.");
        
        for(WebElement productContainer: searchedProducts) {
        	String productName=productContainer.getText().toLowerCase();
        	assertEquals(productName.contains(searchedKey), true,"Product not matching search: " + productName+"\tsearchedkey: "+searchedKey);
        }
        Reporter.log(" Verified all the products related to search are visible");
        
		} catch (Throwable t) { // catch both Exception & AssertionError
	        logger.error("Test failed", t);
	        Assert.fail("Failure occurred: " + t.getMessage());
	    }
    
	logger.debug("application logs end.......");
	logger.info("**** finished TC009_SearchProduct  *****"); 
        
}
}