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
		try {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC003_LoginUserIncorrectEmailAndPassword");
	    
        HomePage home = new HomePage(driver);

     // STEP 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("STEP 1: Launching the browser");
        logger.info("STEP 2: Navigating to baseURL: " + BASE_URL);
        driver.get(BASE_URL);

        // STEP 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
        logger.info("STEP 4. Click on 'Signup / Login' button");
        home.clickSignupOrLoginLink();
        
        logger.info("STEP 5. Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        

        // STEP 6-7: Enter incorrect email address and password, Click 'login' button,
        logger.info("STEP 6. Enter incorrect email address and password");
        home.setEmailAddressLogin("Wrong"+USER_EMAIL);
        home.setPassword(PASSWORD);
        
        logger.info("STEP 7. Click 'login' button");
        home.clickLogin();
        
        logger.info("Navigating to Signup / Login Page");
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        Reporter.log("HomePage is displayed");
        Thread.sleep(3000);
        
        //STEP 8: Verify error 'Your email or password is incorrect!' is visible
        logger.info("STEP 8. Verify error 'Your email or password is incorrect!' is visible");
        assertEquals(home.errorMsgExist(),true,"Error Message is not displayed");
        
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in verifyLoginUserIncorrectEmailAndPasswordFlow: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in verifyLoginUserIncorrectEmailAndPasswordFlow: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC003_LoginUserIncorrectEmailAndPassword  *****"); 

    
}
	
	

}
