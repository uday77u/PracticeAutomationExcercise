/*
 * Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 */


package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC005_RegisterUserWithExistingEmail extends BaseClass {

	@Test(description = "Verify Register user with Existing Email")
    public void verifyRegisterUserWithExistingEmailFlow() {
		try {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC005_RegisterUserWithExistingEmail");
			    
		HomePage home = new HomePage(driver);

	  // STEP 1-3: Navigate to home page and  Verify that home page is visible successfully
	  logger.info("STEP 1: Launching the browser");
	  logger.info("STEP 2: Navigating to baseURL: " + BASE_URL);
	  driver.get(BASE_URL);

        // STEP 4-5: Click Sign up/Login and verify 'New User Sign up!'
	    logger.info("4. Click on 'Signup / Login' button");
        home.clickSignupOrLoginLink();
        
        logger.info("5. Verify 'New User Signup!' is visible");
        assertTrue(home.msgSignupVisible(), "'New User Signup!' is not visible");
        logger.info("'New User Signup!' is visible");

        // STEP 6-7:Enter name and already registered email address,Click 'Signup' button
        logger.info("6. Enter name and already registered email address");
        home.setUserName(USER_NAME);
        home.setEmail(USER_EMAIL);
        
        logger.info("7. Click 'Signup' button");
        home.clickBtnSignup();
        logger.info("Entered name and already registered email address,Clicked 'Signup' button");
        
       //STEP 8: Verify error 'Email Address already exist!' is visible
        logger.info("8. Verify error 'Email Address already exist!' is visible");
        assertTrue(home.errorMsgEmailAlreadyExist(), "Verify error 'Email Address already exist!' is not visible");
        logger.info("Verified error 'Email Address already exist!' is visible");
        
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in verifyRegisterUserWithExistingEmailFlow: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in verifyRegisterUserWithExistingEmailFlow: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC005_RegisterUserWithExistingEmail  *****"); 
        
}
}
