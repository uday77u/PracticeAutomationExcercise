/*
 * Test Case 24: Download Invoice after purchase order
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
21. Click 'Delete Account' button
22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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
import pageObjects.PaymentDonePage;
import pageObjects.PaymentPage;
import pageObjects.SignupPage;

public class TC024_DownloadInvoiceAfterPurchaseOrder extends BaseClass {
	@Test
	public void testDownloadInvoiceAfterPurchaseOrder() throws InterruptedException {
		
		HomePage homePage=new HomePage(driver);
		SignupPage signupPage=new SignupPage(driver);
		CartPage cartPage=new CartPage(driver);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		PaymentPage paymentPage=new PaymentPage(driver);
		PaymentDonePage paymentDonePage=new PaymentDonePage(driver);
		
		// Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, true);
        assertTrue(isCurrentTitleWithSegment("Automation Exercise"),"Home page title mismatch"+driver.getTitle());
        Reporter.log("Home Page is displayed successfully\nNavigate to home page and verified", true);
        
        //step 4-6: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        homePage.mouseHoverToProduct1();
        homePage.clickbtnAddToCartProduct1();
        Thread.sleep(3000);
        homePage.clickLnkViewCart();
        assertTrue(isCurrentUrlWithSegment("cart"), "Unable to open 'cart Page':");
        Reporter.log("Add products to cart, Click 'Cart' button, Verified that cart page is displayed");

        //step 7: Click Proceed To Checkout
        cartPage.clickBtnProceedToCheckout();
        Thread.sleep(3000);
        
        //step 8-11: Click 'Register / Login' button, Fill all details in Signup and create account
        //Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //Verify ' Logged in as username' at top
        cartPage.clickBtnRegisterOrLogin();
        GeneralScriptsForAccountCreation gsAcc=new GeneralScriptsForAccountCreation();
        gsAcc.verifySignupRegistration(driver);
        
        //step 12-14: Click 'Cart' button, Click 'Proceed To Checkout' button, Verify Address Details and Review Your Order
        homePage.clickbtnCart();
        cartPage.clickBtnProceedToCheckout();
        
        //step 15-16: Enter description in comment text area and click 'Place Order'
        checkoutPage.setTxtCommentArea("Good product");
        checkoutPage.clickBtnPlaceOrder();
        assertTrue(isCurrentUrlWithSegment("payment"),"Unable to navigated to payment page."+driver.getCurrentUrl());
        Reporter.log("Commented and navigated to payment page");
        
        //step 17-18: Enter payment details: Name on Card, Card Number, CVC, Expiration date, Click 'Pay and Confirm Order' button
        //Verify success message 'Your order has been placed successfully!'
        paymentPage.settxtNameOnCard("kjhdd");
        paymentPage.settxtCardNumber("45457");
        paymentPage.settxtCVC("4578");
        paymentPage.settxtExpiryMonth("21");
        paymentPage.settxtExpiryYear("2028");
        paymentPage.clickbtnPayAndConfirmOrder();
        assertTrue(driver.getPageSource().contains("successful"),"Success message not displayed");
        
        //step 19: Click 'Download Invoice' button and verify invoice is downloaded successfully.,Click 'Continue' button
        assertTrue(paymentDonePage.msgYourOrderConformedExist(), "Success message not displayed");
        assertEquals(paymentDonePage.getMsgYourOrderConformed(), "Congratulations! Your order has been confirmed!","mismatch in success message");
        paymentDonePage.clickBtnDownloadInvoice();
        
        //step 21-22: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
        gsAcc.DeleteAccount(driver, signupPage);
        
	}
}
