/*
 *Test Case 3: Login User with incorrect email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible 
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC003_LoginUserIncorrectEmailAndPassword extends BaseClass {

	@Test(description = "Verify Login User incorrectEmail and Password")
    public void verifyLoginUserIncorrectEmailAndPasswordFlow() throws InterruptedException {
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC003_LoginUserIncorrectEmailAndPassword");
	    
        HomePage home = new HomePage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);

        // Step 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
        logger.info("Step 4. Click on 'Signup / Login' button");
        home.clickSignup();
        
        logger.info("Step 5. Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        

        // Step 6-7: Enter incorrect email address and password, Click 'login' button,
        logger.info("Step 6. Enter incorrect email address and password");
        home.setEmailAddressLogin(userEmail);
        home.setPassword(password);
        
        logger.info("Step 7. Click 'login' button");
        home.clickLogin();
        
        logger.info("Navigating to Signup / Login Page");
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        Reporter.log("HomePage is displayed");
        Thread.sleep(3000);
        
        //step 8: Verify error 'Your email or password is incorrect!' is visible
        logger.info("Step 8. Verify error 'Your email or password is incorrect!' is visible");
        assertEquals(home.errorMsgExist(),true,"Error Message is not displayed");
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC003_LoginUserIncorrectEmailAndPassword  *****"); 

    
}
}
