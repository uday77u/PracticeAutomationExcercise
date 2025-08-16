/*
 * Test Case 14: Place Order: Register while Checkout
Test case management solutionsAutomation testing as a serviceTest case automation tools
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
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TC014_PlaceOrderRegisterWhileCheckout extends BaseClass{

	@Test(description = "PlaceOrderRegisterWhileCheckoute")
    public void VerifyPlaceOrderRegisterWhileCheckout() throws InterruptedException, IOException {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC014_PlaceOrderRegisterWhileCheckout");
	    
        HomePage home = new HomePage(driver);
        CartPage cart=new CartPage(driver);
        SignupPage signup=new SignupPage(driver);
        CheckoutPage checkout=new CheckoutPage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
 
        //step 4-6: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
        logger.info("4. Add products to cart");
         dragToWebElement(driver,home.LocatoraddToCartTshirt());
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.LocatoraddToCartTshirt());
         
         logger.info("5. Click 'Cart' button");
         WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(home.LocatorbtnContinueShopping()));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.LocatorbtnContinueShopping());
       
         logger.info("6. Verify that cart page is displayed");
         dragToWebElement(driver,home.LocatoraddToCartDress());
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.LocatoraddToCartDress());
         //home.clickAddToCartDress();
         
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.LocatorbtnContinueShopping());
         //home.clickBtnContinueShopping();
       Thread.sleep(3000);
       
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnCart);
         home.clickbtnCart();
         assertEquals(driver.getTitle(), "Automation Exercise - Checkout", "mis match title");
         Reporter.log("step 4-6:Add products to cart, Click 'Cart' button, Verify that cart page is displayed");
         
         
        //step 7-8: Click Proceed To Checkout, Click 'Register / Login' button
         logger.info("7. Click Proceed To Checkout");
        
        cart.clickBtnProceedToCheckout();
        
        logger.info("8. Click 'Register / Login' button");
        cart.clickBtnRegisterOrLogin();
        Reporter.log("step 7-8: Click Proceed To Checkout, Click 'Register / Login' button");
        
        //step 9: Fill all details in Signup and create account
        logger.info("9. Fill all details in Signup and create account");
        GenericScript gs= new  GenericScript(driver);
        gs.CreateAccountWithRandomData(home);
        Reporter.log("step 9: Fill all details in Signup and create account");
		
        //step 10-11: Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        logger.info("10. Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        
	    gs.fillAccountDetailsWithRandomData(signup);
	    assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
	    
	    logger.info("11. Verify ' Logged in as username' at top");
	    signup.clickContinue();
	    assertEquals(signup.msgLoggedInAs(gs.RandomUserName),true,"'LoggedInAs(userName)'- is not visible");	        
		
        //step 12-14:Click 'Cart' button, Click 'Proceed To Checkout' button,  Verify Address Details and Review Your Order
	        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnCart);
	    logger.info("12.Click 'Cart' button");
	        home.clickbtnCart();
	        
	        logger.info("13. Click 'Proceed To Checkout' button");
	        cart.clickBtnProceedToCheckout();
	        
	        logger.info("14. Verify Address Details and Review Your Order");
	        
        //step 15: Enter description in comment text area and click 'Place Order'
	        logger.info("15. Enter description in comment text area and click 'Place Order'");
	        
	        checkout.setTxtCommentArea("commenting Hello");
	        checkout.clickBtnPlaceOrder();
	        
        //step 16-17: Enter payment details: Name on Card, Card Number, CVC, Expiration date, Click 'Pay and Confirm Order' button
	        logger.info("16. Enter payment details: Name on Card, Card Number, CVC, Expiration date");
	        PaymentPage payment=new PaymentPage(driver);
	        payment.settxtNameOnCard("asdf");
	        payment.settxtCardNumber("14555");
	        payment.settxtCVC("14752");
	        payment.settxtExpiryMonth("12");
	        Thread.sleep(3000);
	        payment.settxtExpiryYear("2058");
	        Thread.sleep(3000);
	        
	        logger.info("17. Click 'Pay and Confirm Order' button");
	        payment.clickbtnPayAndConfirmOrder();
	        Thread.sleep(3000);
	        Reporter.log("step 16-17: Enter payment details: Name on Card, Card Number, CVC, Expiration date, Click 'Pay and Confirm Order' button");
	        Thread.sleep(3000);
	        
        //step 18: Verify success message 'Your order has been placed successfully!'
	       
	        /* unable to interact with the success message in paymentPage
	        assertTrue(payment.msgSuccessExist(),"no msgSuccessExist");
	        assertEquals(payment.getMsgSuccess(), "'Your order has been placed successfully!'"); 
	        Reporter.log("step 18: Verify success message 'Your order has been placed successfully!");
	        */
	       
	        logger.info("18. Verify success message 'Your order has been placed successfully!'");
	        PaymentDonePage payDone=new PaymentDonePage(driver);
	        assertTrue(payDone.msgYourOrderConformedExist(),"no msgSuccessExist");
	        assertEquals(payDone.getMsgYourOrderConformed(), "Congratulations! Your order has been confirmed!"); 
	        payDone.clickBtnContinue();
	        
        //step 19-20: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
	        logger.info("19. Click 'Delete Account' button");
	        logger.info("20. Verify 'ACCOUNT DELETED!' and click 'Continue' button");
	        gs.DeleteAccount(signup);
        
       
       logger.debug("application logs end.......");
   	logger.info("**** finished TC014_PlaceOrderRegisterWhileCheckout  *****"); 
       
}

	 // Utility method to wait for an element to be visible
    private WebElement waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void dragToWebElement(WebDriver driver, WebElement locator) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locator);
	}
}
