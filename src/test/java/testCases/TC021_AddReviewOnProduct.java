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
		HomePage homePage=new HomePage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		
		// Step 1-2: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\n Navigate to home page and verified", true);
        
        //step 3-4: Click on 'Products' button, Verify user is navigated to ALL PRODUCTS page successfully
        homePage.clickProducts();
        assertTrue(isCurrentTitleWithSegment("All Products"), "All products page is not displayed:Title"+driver.getTitle());
        Reporter.log("Verified user is navigated to ALL PRODUCTS page successfully", true);
        
        //step 5-6: Click on 'View Product' button, Verify 'Write Your Review' is visible
        productsPage.clickBtnViewProduct2();
        assertTrue(isCurrentTitleWithSegment("Product Details"), "Unable to navigate the Product Details Page");
        assertTrue(productDetailsPage.isMsgWriteReviewDisplayed(), "Write Reviw is not displayed");
        SoftAssert sa=new SoftAssert();
        sa.assertEquals(productDetailsPage.getMsgWriteReview(), "Write Your Review");
        Reporter.log("Verified 'Write Your Review' is visible", true);
        
      //step 7-9: Enter name, email and review, Click 'Submit' button, Verify success message 'Thank you for your review.'
        productDetailsPage.enterReviewName("Raam");
        productDetailsPage.enterReviewEmailAddress("MyEmail@gmail.com");
        productDetailsPage.enterReviewHere("Good product");
        productDetailsPage.clickButtonReview();
        assertTrue(driver.getPageSource().contains("Thank you for your review."),"'Thank you for your review.' is not displayed");
        Reporter.log("Verify success message 'Thank you for your review.'\n");
        
        
	}

	
}
