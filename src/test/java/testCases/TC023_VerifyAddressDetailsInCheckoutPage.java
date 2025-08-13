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
import BaseTest.GenericScript;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.SignupPage;

public class TC023_VerifyAddressDetailsInCheckoutPage extends BaseClass {
	@Test
	public void testVerifyAddressDetailsInCheckoutPage() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		SignupPage signupPage=new SignupPage(driver);
		CartPage cartPage=new CartPage(driver);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		
		// Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertTrue(isCurrentTitleWithSegment("Automation Exercise"),"Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nNavigate to home page and verified", true);
        
        //step 4-7: Click 'Signup / Login' button, Fill all details in Signup and create account
        //Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        GeneralScriptsForAccountCreation gsAcc=new GeneralScriptsForAccountCreation();
        gsAcc.verifySignupRegistration(driver);
        
        //step 8-10:Add products to cart, Click 'Cart' button, Verify that cart page is displayed
         homePage.mouseHoverToProduct1();
         homePage.clickbtnAddToCartProduct1();
         homePage.clickLnkViewCart();
        assertTrue(isCurrentUrlWithSegment("cart"), "Unable to open 'cart Page':");
        Reporter.log("Add products to cart, Click 'Cart' button, Verified that cart page is displayed");
        
        //step 11-12: Click Proceed To Checkout,
        // Verify that the delivery address is same address filled at the time registration of account
        cartPage.clickBtnProceedToCheckout();
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.userName), "Delivery user name: "+gsAcc.userName+"not present");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.lastName), "Delivery last name: "+gsAcc.lastName+"not present");
        Reporter.log("Verified that the delivery address is same address filled at the time registration of account",true);
        
        //step 13: Verify that the billing address is same address filled at the time registration of account
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.userName), "Billing user name: "+gsAcc.userName+"not present");
        assertTrue(checkoutPage.getDispBillingAddressFirstLastname().contains(gsAcc.lastName), "Billing last name: "+gsAcc.lastName+"not present");
        Reporter.log("Verified that the billing address is same address filled at the time registration of account",true);

        //step 14-15: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
         gsAcc.DeleteAccount(driver, signupPage);
        
	}
}
