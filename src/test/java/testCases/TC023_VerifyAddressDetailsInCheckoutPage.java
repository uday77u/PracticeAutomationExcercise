/*
 * Test Case 23: Verify address details in checkout page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.GeneralScriptsForAccountCreation;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.SignupPage;

public class TC023_VerifyAddressDetailsInCheckoutPage extends BaseClass {
	@Test
	public void testVerifyAddressDetailsInCheckoutPage() throws InterruptedException {
		try {
		HomePage homePage=new HomePage(driver);
		SignupPage signupPage=new SignupPage(driver);
		CartPage cartPage=new CartPage(driver);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC023_VerifyAddressDetailsInCheckoutPage");

		// Step 1-3: Navigate to home page and  Verify that home page is visible successfully
		logger.info("Step 1: Launching the browser");
		logger.info("Step 2: Navigating to baseURL: " + baseURL);
		driver.get(baseURL);
        
        logger.info("Step 3:Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        

        //step 4-7: Click 'Signup / Login' button, Fill all details in Signup and create account
        //Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        logger.info("step 4-7: Click 'Signup / Login' button, Fill all details in Signup and create account");
        GeneralScriptsForAccountCreation gsAcc=new GeneralScriptsForAccountCreation();
        gsAcc.verifySignupRegistration(driver);
        
        //step 8-10:Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        logger.info("8. Add products to cart");
         homePage.mouseHoverToProduct1();
         homePage.clickbtnAddToCartProduct1();
         
         logger.info("9. Click 'Cart' button");
         homePage.clickLnkViewCart();
         
         logger.info("10. Verify that cart page is displayed");
        assertTrue(isCurrentUrlWithSegment("cart"), "Unable to open 'cart Page':");
        Reporter.log("Add products to cart, Click 'Cart' button, Verified that cart page is displayed");
        
        //step 11-12: Click Proceed To Checkout,
        // Verify that the delivery address is same address filled at the time registration of account
        logger.info("11. Click Proceed To Checkout");
        cartPage.clickBtnProceedToCheckout();
        
        logger.info("12. Verify that the delivery address is same address filled at the time registration of account");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.userName), "Delivery user name: "+gsAcc.userName+"not present");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.lastName), "Delivery last name: "+gsAcc.lastName+"not present");
        Reporter.log("Verified that the delivery address is same address filled at the time registration of account",true);
        
        //step 13: Verify that the billing address is same address filled at the time registration of account
        logger.info("13. Verify that the billing address is same address filled at the time registration of account");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.userName), "Billing user name: "+gsAcc.userName+"not present");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.lastName), "Billing last name: "+gsAcc.lastName+"not present");
        Reporter.log("Verified that the billing address is same address filled at the time registration of account",true);

        //step 14-15: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
        logger.info("step 14-15: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button");
         gsAcc.DeleteAccount(driver, signupPage);
        
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in testVerifyAddressDetailsInCheckoutPage: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in testVerifyAddressDetailsInCheckoutPage: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
         logger.debug("application logs end.......");
     	logger.info("**** finished TC023_VerifyAddressDetailsInCheckoutPage  *****"); 
	}
}
