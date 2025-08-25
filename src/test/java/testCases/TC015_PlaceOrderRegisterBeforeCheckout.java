/*
 * Test Case 15: Place Order: Register before Checkout
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
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.GenericScript;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.PaymentDonePage;
import pageObjects.PaymentPage;
import pageObjects.SignupPage;

public class TC015_PlaceOrderRegisterBeforeCheckout extends BaseClass {

	@Test(description = "PlaceOrderRegisterBeforeCheckout")
    public void VerifyPlaceOrderRegisterBeforeCheckout() throws InterruptedException, IOException {
       try {
		HomePage home = new HomePage(driver);
        SignupPage signup=new SignupPage(driver);
        CartPage cart=new CartPage(driver);
        CheckoutPage checkout= new CheckoutPage(driver); 
	    PaymentDonePage payDone=new PaymentDonePage(driver);

		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC015_PlaceOrderRegisterBeforeCheckout");
	    

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
 
        //Step 4-5: Click 'Signup / Login' button,Fill all details in Signup and create account
        logger.info("4. Click 'Signup / Login' button");
        GenericScript gs=new GenericScript(driver);
        gs.CreateAccountWithRandomData(home);
        
        logger.info("5. Fill all details in Signup and create account");
        gs.fillAccountDetailsWithRandomData(signup);
        Reporter.log(" Click 'Signup / Login' button,Fill all details in Signup and create account");
        
        //Step 6-7: Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        logger.info("6. Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
        signup.clickContinue();
        
        logger.info("7. Verify ' Logged in as username' at top");
        assertEquals(signup.msgLoggedInAs(gs.RandomUserName),true,"'LoggedInAs(userName)'- is not visible");
        Reporter.log("Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top");
        
        
        //step 8-10: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        logger.info("8. Add products to cart");
        home.mouseHoverToProduct1();
        home.clickBtnContinueShopping();
        home.clickbtnAddToCartProduct1();
        
        logger.info("9. Click 'Cart' button");
        home.mouseHoverToProduct2();
        home.clickbtnAddToCartProduct2();
        home.clickLnkViewCart();
        
        logger.info("10. Verify that cart page is displayed");
        assertTrue(driver.getCurrentUrl().contains("cart"), "Miss-match in the url,Cart page is not displayed");
        Reporter.log("Add products to cart, Click 'Cart' button, Verify that cart page is displayed");
        
        
        //step 11-12:Click Proceed To Checkout, Verify Address Details and Review Your Order
        logger.info("11. Click Proceed To Checkout");
        cart.clickBtnProceedToCheckout();
         
        logger.info("12. Verify Address Details and Review Your Order");
        String expectedName = gs.RandomUserName;
        assertTrue(checkout.getDispDeliveryAddressFirstLastname().contains(expectedName), "Expected name:"+expectedName+" is not in Delivery Address:"+checkout.getDispDeliveryAddressFirstLastname());
        assertTrue(checkout.getDispBillingAddressFirstLastname().contains(expectedName), "Expected name:\"+expectedName+\" is not in the Billing Address"+checkout.getDispBillingAddressFirstLastname());
         
         
        
        //step 13:Enter description in comment text area and click 'Place Order'
         logger.info("13. Enter description in comment text area and click 'Place Order'");
         checkout.setTxtCommentArea("commenting Hello");
         checkout.clickBtnPlaceOrder();
         Reporter.log("step 15: Enter description in comment text area and click 'Place Order'");
        
        //step 14:Enter payment details: Name on Card, Card Number, CVC, Expiration date
         logger.info("14. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
         PaymentPage payment=new PaymentPage(driver);
         payment.settxtNameOnCard("asdf");
         payment.settxtCardNumber("14555");
         payment.settxtCVC("14752");
         payment.settxtExpiryMonth("12");
         Thread.sleep(3000);
         payment.settxtExpiryYear("2058");
         Thread.sleep(3000);
         payment.clickbtnPayAndConfirmOrder();
         Thread.sleep(3000);
         Reporter.log("step 16-17: Enter payment details: Name on Card, Card Number, CVC, Expiration date, Click 'Pay and Confirm Order' button");
         Thread.sleep(3000);  
         Reporter.log("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        
        //step 15-16: Click 'Pay and Confirm Order' button, Verify success message 'Your order has been placed successfully!'
	      logger.info("15. Click 'Pay and Confirm Order' button");
	      assertTrue(payDone.msgYourOrderConformedExist(),"no msgSuccessExist");
	      
	      logger.info("16. Verify success message 'Your order has been placed successfully!'");
	      assertEquals(payDone.getMsgYourOrderConformed(), "Congratulations! Your order has been confirmed!"); 
	      payDone.clickBtnContinue();
	      Reporter.log("step 18: Verify success message 'Your order has been placed successfully!");  
	      
        //step 17-18:Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
	      logger.info("17. Click 'Delete Account' button");
	      logger.info("18. Verify 'ACCOUNT DELETED!' and click 'Continue' button");
	      gs.DeleteAccount(signup);
	      Reporter.log("Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        
   	}
   	catch (AssertionError ae) {
           logger.error("❌ Assertion failed in VerifyPlaceOrderRegisterBeforeCheckout: " + ae.getMessage(), ae);
           throw ae; // rethrow so TestNG marks test as failed
       } catch (Exception e) {
           logger.error("❌ Unexpected exception in VerifyPlaceOrderRegisterBeforeCheckout: " + e.getMessage(), e);
           throw e; // rethrow so TestNG marks test as failed
       }
	        
	      logger.debug("application logs end.......");
	      logger.info("**** finished TC015_PlaceOrderRegisterBeforeCheckout  *****"); 
        
        
        
        
}
}
