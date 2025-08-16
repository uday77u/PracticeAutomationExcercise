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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC005_RegisterUserWithExistingEmail extends BaseClass {

	@Test(description = "Verify Register user with Existing Email")
    public void verifyRegisterUserWithExistingEmailFlow() {
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
		logger.info("starting TC005_RegisterUserWithExistingEmail");
			    
		HomePage home = new HomePage(driver);

	  // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
	  logger.info("Step 1: Launching the browser");
	  logger.info("Step 2: Navigating to baseURL: " + baseURL);
	  driver.get(baseURL);

        // Step 4-5: Click Sign up/Login and verify 'New User Sign up!'
	    logger.info("4. Click on 'Signup / Login' button");
        home.clickSignup();
        
        logger.info("5. Verify 'New User Signup!' is visible");
        assertTrue(home.msgSignupVisible(), "'New User Signup!' is not visible");
        Reporter.log("'New User Signup!' is visible", false);

        // Step 6-7:Enter name and already registered email address,Click 'Signup' button
        logger.info("6. Enter name and already registered email address");
        home.setUserName(userName);
        home.setEmail(userEmail);
        
        logger.info("7. Click 'Signup' button");
        home.clickBtnSignup();
        Reporter.log("Entered name and already registered email address,Clicked 'Signup' button", false);
        
       //step 8: Verify error 'Email Address already exist!' is visible
        logger.info("8. Verify error 'Email Address already exist!' is visible");
        assertEquals(home.errorMsgEmailAlreadyExist(), true,"Verify error 'Email Address already exist!' is not visible");
        Reporter.log("Verified error 'Email Address already exist!' is visible");
        
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC005_RegisterUserWithExistingEmail  *****"); 
        
}
}
