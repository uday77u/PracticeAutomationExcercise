/*
 * Test Case 16: Place Order: Login before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseClass;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentDonePage;
import pageObjects.PaymentPage;

public class TC016_PlaceOrderLoginBeforeCheckout extends BaseClass{
	@Test
	public void testPlaceOrderLoginBeforeCheckout() throws InterruptedException {
		HomePage Home=new HomePage(driver);
		LoginPage Login=new LoginPage(driver);
		CartPage Cart=new CartPage(driver);
		CheckoutPage Checkout= new CheckoutPage(driver);
		PaymentPage payment=new PaymentPage(driver);
		PaymentDonePage PayDone=new PaymentDonePage(driver);
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC016_PlaceOrderLoginBeforeCheckout");
	    
        HomePage home = new HomePage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

        
        //step 4-6: Click 'Signup / Login' button,Fill email,password and click 'Login' button,
        //Verify 'Logged in as username' at top
        logger.info("4. Click 'Signup / Login' button");
        Home.clickSignup();
        
        logger.info("5. Fill email, password and click 'Login' button");
        Home.setEmailAddressLogin(userEmail);
        Home.setPassword(password);
        Home.clickLogin();
        
        logger.info("6. Verify 'Logged in as username' at top");
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");
        assertTrue(Login.msgLoginAsUserName().contains(userName), "mis match in user name");
        
        //step 7-9:Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        logger.info(" 7. Add products to cart");
       Home.mouseHoverToProduct1();
       Home.clickbtnAddToCartProduct1();
       
       logger.info("8. Click 'Cart' button");
       Home.clickbtnCart();
       
       logger.info("9. Verify that cart page is displayed");
       assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page is not displayed");
       
        //step 10-11:Click Proceed To Checkout,Verify Address Details and Review Your Order
       logger.info("10. Click Proceed To Checkout");
        Cart.clickBtnProceedToCheckout();
        
        logger.info("11. Verify Address Details and Review Your Order");
        assertTrue(driver.getCurrentUrl().contains("checkout"), "Checkout page is not displayed");
        SoftAssert sa= new SoftAssert();
        Thread.sleep(3000);
        sa.assertTrue(Checkout.getDispBillingAddressFirstLastname().contains(userName),"user name:'"+userName+"' and address name:'"+Checkout.getDispBillingAddressFirstLastname()+"' are mis match");
        sa.assertTrue(Checkout.getDispDeliveryAddressFirstLastname().contains(userName),"user name:"+userName+" and address name:'"+Checkout.getDispDeliveryAddressFirstLastname()+"' are mis match");
        sa.assertAll();
        Reporter.log("Verified Address Details");
        
        //--verify review order is pending
        
        
        //step 12-15:Enter description in comment text area and click 'Place Order',
        // Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //Click 'Pay and Confirm Order' button,Verify success message 'Your order has been placed successfully!'
        logger.info("12. Enter description in comment text area and click 'Place Order'");
       Checkout.setTxtCommentArea("Good Product");
       Checkout.clickBtnPlaceOrder();
       
       
       assertTrue(driver.getCurrentUrl().contains("payment"));
       
       logger.info("13. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
       payment.settxtNameOnCard("Name");
       payment.settxtCardNumber("12543");
       payment.settxtCVC("cvc54");
       payment.settxtExpiryMonth("June");
       payment.settxtExpiryYear("2027");
       
       logger.info(" 14. Click 'Pay and Confirm Order' button");
       payment.clickbtnPayAndConfirmOrder();
       
       //assertTrue(payment.msgSuccessExist(), "succes message is not displayed"); //next page opens qickly,unable to capture mesage
       //assertEquals( payment.getMsgSuccess(), "Your order has been placed successfully!", "Success message is mis-match.");
      
       logger.info("15. Verify success message 'Your order has been placed successfully!'");
       assertTrue(driver.getCurrentUrl().contains("payment_done"),"payment done page is displayed"+driver.getCurrentUrl()+"!=payment_done");
       assertTrue(PayDone.msgYourOrderConformedExist(), "succes message is not displayed:YourOrderConformed.");
       assertTrue( PayDone.getMsgYourOrderConformed().contains("confirmed"), "Success message is mis-match. Message:"+PayDone.getMsgYourOrderConformed());
        
      //step 16-17: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
     
       /*logger.info("16. Click 'Delete Account' button");
        * logger.info("17. Verify 'ACCOUNT DELETED!' and click 'Continue' button");

       PayDone.clickBtnContinue();
       Login.clickDeletelogin();
       assertEquals(Login.msgDeleteAccount(),"ACCOUNT DELETED!"," 'ACCOUNT DELETED!' is not visible");
       Reporter.log("Clicked on 'Delete Account' button and Verified that 'ACCOUNT DELETED!' is visible");
       
       Login.clickContinueBtnAfterDelete();
       Reporter.log("click on 'Continue'button after delete Account,and Account is deleted successfully");
        */
       
       
       logger.debug("application logs end.......");
   	logger.info("**** finished TC016_PlaceOrderLoginBeforeCheckout  *****"); 
	}
	

}
