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

import java.awt.event.ActionEvent;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
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
       
		HomePage home = new HomePage(driver);
        SignupPage signup=new SignupPage(driver);
        CartPage cart=new CartPage(driver);
        CheckoutPage checkout= new CheckoutPage(driver); 
	    PaymentDonePage payDone=new PaymentDonePage(driver);

        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);
        
        //Step 4-5: Click 'Signup / Login' button,Fill all details in Signup and create account
        GenericScript gs=new GenericScript(driver);
        gs.CreateAccountWithRandomData(home);
        gs.fillAccountDetailsWithRandomData(signup);
        Reporter.log(" Click 'Signup / Login' button,Fill all details in Signup and create account");
        
        //Step 6-7: Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
        signup.clickContinue();
        assertEquals(signup.msgLoggedInAs(gs.RandomUserName),true,"'LoggedInAs(userName)'- is not visible");
        Reporter.log("Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top");
        
        
        //step 8-10: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        home.mouseHoverToProduct1();
        home.clickBtnContinueShopping();
        home.clickbtnAddToCartProduct1();
        
        home.mouseHoverToProduct2();
        home.clickbtnAddToCartProduct2();
        home.clickLnkViewCart();
        
        assertTrue(driver.getCurrentUrl().contains("cart"), "Miss-match in the url,Cart page is not displayed");
        Reporter.log("Add products to cart, Click 'Cart' button, Verify that cart page is displayed");
        
        
        //step 11-12:Click Proceed To Checkout, Verify Address Details and Review Your Order
         cart.clickBtnProceedToCheckout();
         String expectedName = gs.RandomUserName;
         assertTrue(checkout.getDispDeliveryAddressFirstLastname().contains(expectedName), "Expected name:"+expectedName+" is not in Delivery Address:"+checkout.getDispDeliveryAddressFirstLastname());
         assertTrue(checkout.getDispBillingAddressFirstLastname().contains(expectedName), "Expected name:\"+expectedName+\" is not in the Billing Address"+checkout.getDispBillingAddressFirstLastname());
         
         
        
        //step 13:Enter description in comment text area and click 'Place Order'
	        checkout.setTxtCommentArea("commenting Hello");
	        checkout.clickBtnPlaceOrder();
	        Reporter.log("step 15: Enter description in comment text area and click 'Place Order'");
        
        //step 14:Enter payment details: Name on Card, Card Number, CVC, Expiration date
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
	        assertTrue(payDone.msgYourOrderConformedExist(),"no msgSuccessExist");
	        assertEquals(payDone.getMsgYourOrderConformed(), "Congratulations! Your order has been confirmed!"); 
	        payDone.clickBtnContinue();
	        Reporter.log("step 18: Verify success message 'Your order has been placed successfully!");  
	      
        //step 17-18:Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
	        gs.DeleteAccount(signup);
	        Reporter.log("Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        
        
        
        
        
        
        
}
}
