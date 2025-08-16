/*
 * Test Case 21: Add review on product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductsPage;

public class TC021_AddReviewOnProduct extends BaseClass {
	@Test
	public void testAddReviewOnProduct() {
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC021_AddReviewOnProduct");
	    
	    HomePage homePage=new HomePage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

        //step 3-4: Click on 'Products' button, Verify user is navigated to ALL PRODUCTS page successfully
        logger.info("3. Click on 'Products' button");
        homePage.clickProducts();
        
        logger.info("4. Verify user is navigated to ALL PRODUCTS page successfully");
        assertTrue(isCurrentTitleWithSegment("All Products"), "All products page is not displayed:Title"+driver.getTitle());
        Reporter.log("Verified user is navigated to ALL PRODUCTS page successfully", true);
        
        //step 5-6: Click on 'View Product' button, Verify 'Write Your Review' is visible
        logger.info("5. Click on 'View Product' button");
        productsPage.clickBtnViewProduct2();
        
        logger.info("6. Verify 'Write Your Review' is visible");
        assertTrue(isCurrentTitleWithSegment("Product Details"), "Unable to navigate the Product Details Page");
        assertTrue(productDetailsPage.isMsgWriteReviewDisplayed(), "Write Reviw is not displayed");
        SoftAssert sa=new SoftAssert();
        sa.assertEquals(productDetailsPage.getMsgWriteReview(), "Write Your Review");
        Reporter.log("Verified 'Write Your Review' is visible", true);
        
      //step 7-9: Enter name, email and review, Click 'Submit' button, Verify success message 'Thank you for your review.'
        logger.info("7. Enter name, email and review");
        productDetailsPage.enterReviewName("Raam");
        productDetailsPage.enterReviewEmailAddress("MyEmail@gmail.com");
        productDetailsPage.enterReviewHere("Good product");
        
        logger.info("8. Click 'Submit' button");
        productDetailsPage.clickButtonReview();
        
        logger.info("9. Verify success message 'Thank you for your review.'");
        assertTrue(driver.getPageSource().contains("Thank you for your review."),"'Thank you for your review.' is not displayed");
        Reporter.log("Verify success message 'Thank you for your review.'\n");
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC021_AddReviewOnProduct  *****"); 
        
	}

	
}
