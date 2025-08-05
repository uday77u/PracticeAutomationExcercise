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
package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

public class TC013_VerifyProductQuantityInCart extends BaseClass{

	@Test(description = "VerifyProductQuantityInCart")
    public void VerifyProductQuantityInCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);
        
        //step 4-5: Click 'View Product' for any product on home page, Verify product detail is opened
         home.clickBtnViewProduct4();
         assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
         Reporter.log("Click 'View Product' for any product on home page, Verify product detail is opened");
         
        //step 6-8: Increase quantity to 4, Click 'Add to cart' button, Click 'View Cart' button
         ProductDetailsPage proDetail=new ProductDetailsPage(driver);
         String qty="4";
         Thread.sleep(3000);
         proDetail.setQuantity(qty);
         Thread.sleep(3000);
         proDetail.clickBtnAddToCart();
         Thread.sleep(3000);
         proDetail.clickLnkViewCart();
         Reporter.log("Increase quantity to 4, Click 'Add to cart' button, Click 'View Cart' button");
         
        //step 9: Verify that product is displayed in cart page with exact quantity
         assertEquals(proDetail.getQtyInCart(),qty,"Mis match in quantity");
         Reporter.log("Verified that product is displayed in cart page with exact quantity");
        
}
}
