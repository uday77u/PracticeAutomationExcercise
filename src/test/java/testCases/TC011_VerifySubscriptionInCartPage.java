/*
 * Test Case 11: Verify Subscription in Cart page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC011_VerifySubscriptionInCartPage extends BaseClass {

	@Test(description = "_VerifySubscriptionInCartPage")
    public void _VerifySubscriptionInCartPage() throws InterruptedException {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC011_VerifySubscriptionInCartPage");
	    
        HomePage home = new HomePage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);
        
        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        //step 4-6: Click 'Cart' button, Scroll down to footer, Verify text 'SUBSCRIPTION'
        logger.info("4. Click 'Cart' button");
         home.clickbtnCart();
         
         logger.info("5. Scroll down to footer");
         JavascriptExecutor js=(JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", home.LocatorHomePageFooter());
         Thread.sleep(3000);
         
         logger.info("6. Verify text 'SUBSCRIPTION'");
         assertEquals(home.msgSubscription(), true,"Subscription text is not exist");

         
        //step 7: Enter email address in input and click arrow button
         logger.info("7. Enter email address in input and click arrow button");
         home.setSusbscribeEmailname(userEmail);
         home.clickbtnSubscribeArrow();

        
        //step 8: Verify success message 'You have been successfully subscribed!' is visible
         logger.info("8. Verify success message 'You have been successfully subscribed!' is visible");
         assertTrue(home.getmsgAlertSentMailExist(),"Success message is not visible.");
         assertEquals(home.getMsgAlertSentMail(), "You have been successfully subscribed!","Mis-match in alert Message");

         
         logger.debug("application logs end.......");
     	logger.info("**** finished TC011_VerifySubscriptionInCartPage  *****"); 
        
        
        
        
        
}
}