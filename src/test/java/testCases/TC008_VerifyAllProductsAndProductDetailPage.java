/*
 * Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductsPage;

public class TC008_VerifyAllProductsAndProductDetailPage extends BaseClass{
	
	@Test(description = "Verify all products and product Detail Page")
    public void VerifyAllProductsAndProductDetailPage() throws InterruptedException {
		try {
        HomePage home = new HomePage(driver);
        ProductsPage product=new ProductsPage(driver);
        
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC008_VerifyAllProductsAndProductDetailPage");
	    
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
        
        logger.info("Step 5: Verify user is navigated to ALL PRODUCTS page successfully");
        assertEquals(driver.getTitle(), "Automation Exercise - All Products","Product page title mismatch");
 
        
        //step 6: The products list is visible
        logger.info("Step 6: The products list is visible");
        assertEquals(product.msgAllProducts(), true,"Products list is not visible");

        
        //step 7-8: Click on 'View Product' of first product, User is landed to product detail page
        logger.info("Step 7: Click on 'View Product' of first product");
        product.clickFirstProduct();
        
        logger.info("Step 8: User is landed to product detail page");
        assertEquals(driver.getTitle(), "Automation Exercise - Product Details","Product page title mismatch");
        
        //step 9: Verify that detail detail is visible: product name, category, price, availability, condition, brand
        logger.info("Step 9: Verify that detail detail is visible: product name, category, price, availability, condition, brand");
        /*
        assertTrue(product.FirstProductNameExist(),"Product name is not exist");
        assertTrue(product.ProductCategoryExist(),"Product category is not exist");
        assertTrue(product.ProductPriceExist(),"Product price is not exist");
        assertTrue(product.ProductAvailabilityExist(),"Product availability is not exist");
        assertTrue(product.ProductConditionExist(),"Product condition is not exist");
        assertTrue(product.ProductionBrandExist(),"Product brand is not exist");
        */
         assertTrue(isProductDetailsVisible(), "Product details are missing.");
         
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in VerifyAllProductsAndProductDetailPage: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in VerifyAllProductsAndProductDetailPage: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC008_VerifyAllProductsAndProductDetailPage  *****"); 
        

}
	public boolean isProductDetailsVisible() {
		ProductsPage product=new ProductsPage(driver);
		
		return product.FirstProductNameExist()
        && product.ProductCategoryExist()
        && product.ProductPriceExist()
        && product.ProductAvailabilityExist()   
        && product.ProductConditionExist()
        && product.ProductionBrandExist();
	}
	
}
