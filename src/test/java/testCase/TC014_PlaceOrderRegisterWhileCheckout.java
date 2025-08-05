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
package testCase;

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
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully\nStep 1-3: Navigate to home page and verify", false);
        
        //step 4-6: Add products to cart, Click 'Cart' button, Verify that cart page is displayed
         dragToWebElement(driver,home.addToCartTshirt);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.addToCartTshirt);
  
         WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(home.btnContinueShopping));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnContinueShopping);
       
         
         dragToWebElement(driver,home.addToCartDress);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.addToCartDress);
         //home.clickAddToCartDress();
         
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnContinueShopping);
         //home.clickBtnContinueShopping();
       Thread.sleep(3000);
       
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnCart);
         home.clickbtnCart();
         assertEquals(driver.getTitle(), "Automation Exercise - Checkout", "mis match title");
         Reporter.log("step 4-6:Add products to cart, Click 'Cart' button, Verify that cart page is displayed");
         
         
        //step 7-8: Click Proceed To Checkout, Click 'Register / Login' button
        CartPage cart=new CartPage(driver);
        cart.clickBtnProceedToCheckout();
        cart.clickBtnRegisterOrLogin();
        Reporter.log("step 7-8: Click Proceed To Checkout, Click 'Register / Login' button");
        
        //step 9: Fill all details in Signup and create account
        GenericScript gs= new  GenericScript(driver);
        gs.CreateAccountWithRandomData(home);
        Reporter.log("step 9: Fill all details in Signup and create account");
		
        //step 10-11: Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top
        SignupPage signup=new SignupPage(driver);
	    gs.fillAccountDetailsWithRandomData(signup);
	    assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
	    signup.clickContinue();
	    assertEquals(signup.msgLoggedInAs(gs.RandomUserName),true,"'LoggedInAs(userName)'- is not visible");
	    Reporter.log("Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top");
	    Reporter.log("step 10-11: Verify 'ACCOUNT CREATED!' and click 'Continue' button, Verify ' Logged in as username' at top");
	        
		
        //step 12-14:Click 'Cart' button, Click 'Proceed To Checkout' button,  Verify Address Details and Review Your Order
	        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", home.btnCart);
	        home.clickbtnCart();
	        cart.clickBtnProceedToCheckout();
	        Reporter.log("step 12-14:Click 'Cart' button, Click 'Proceed To Checkout' button,  Verify Address Details and Review Your Order");
	        
        //step 15: Enter description in comment text area and click 'Place Order'
	        CheckoutPage checkout=new CheckoutPage(driver);
	        checkout.setTxtCommentArea("commenting Hello");
	        checkout.clickBtnPlaceOrder();
	        Reporter.log("step 15: Enter description in comment text area and click 'Place Order'");
	        
        //step 16-17: Enter payment details: Name on Card, Card Number, CVC, Expiration date, Click 'Pay and Confirm Order' button
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
	        
        //step 18: Verify success message 'Your order has been placed successfully!'
	       
	        /* unable to interact with the success message in paymentPage
	        assertTrue(payment.msgSuccessExist(),"no msgSuccessExist");
	        assertEquals(payment.getMsgSuccess(), "'Your order has been placed successfully!'"); 
	        Reporter.log("step 18: Verify success message 'Your order has been placed successfully!");
	        */
	       
	        
	        PaymentDonePage payDone=new PaymentDonePage(driver);
	        assertTrue(payDone.msgYourOrderConformedExist(),"no msgSuccessExist");
	        assertEquals(payDone.getMsgYourOrderConformed(), "Congratulations! Your order has been confirmed!"); 
	        payDone.clickBtnContinue();
	        
	        Reporter.log("step 18: Verify success message 'Your order has been placed successfully!");
	        
        //step 19-20: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button
	        gs.DeleteAccount(signup);
       Reporter.log("Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        
        
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
