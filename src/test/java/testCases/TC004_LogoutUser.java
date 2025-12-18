/*
 * Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC004_LogoutUser extends BaseClass {

	@Test(description = "Verify Logout user")
    public void verifyLogoutUserFlow() throws InterruptedException {
		try {
		//logger.debug("");
		//logger.info("STEP ");
		logger.debug("logging started");
		logger.info("starting TC004_LogoutUser");
			    
		HomePage home = new HomePage(driver);

		// STEP 1-3: Navigate to home page and  Verify that home page is visible successfully
		 logger.info("STEP 1: Launching the browser");
		 logger.info("STEP 2: Navigating to baseURL: " + BASE_URL);
		 driver.get(BASE_URL);
	 
        // STEP 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
		logger.info("STEP 4: Click on 'Sign up / Login' button");
        home.clickSignupOrLoginLink();

        logger.info("STEP 5. Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        logger.info("'Login to your account' is visible");
        
        
        // STEP 6-7: Enter correct email address and password, Click 'login' button,
        logger.info("STEP 6. Enter correct email address and password ");
        home.setEmailAddressLogin(USER_EMAIL);
        home.setPassword(PASSWORD);
        
        logger.info("STEP 7. Click 'login' button");
        home.clickLogin();
        logger.info("Entered correct email address and password, Clicked 'login' button");
        Thread.sleep(5000);
        
        logger.info("Navigating to the user home Page");
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");
        logger.info("Login page is displayed");
        
        //STEP 8: Verify that 'Logged in as username' is visible
        logger.info("STEP 8. Verify that 'Logged in as user name' is visible");
        LoginPage Login=new LoginPage(driver);
        assertTrue(Login.msgLoginAsUserName().contains(USER_NAME),"'Logged in as username' is mis-match with username");
        logger.info("Verified that 'Logged in as username' is visible and matched with user name");
        
        //STEP 9-10:Click 'Logout' button,Verify that user is navigated to login page
        logger.info("STEP 9. Click 'Logout' button");
        Login.clickLogout();
        
        logger.info("STEP 10. Verify that user is navigated to login page");
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        logger.info("Clicked 'Logout' button,\nVerified that user is navigated to login page");
        Thread.sleep(3000);
        
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in verifyLogoutUserFlow: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in verifyLogoutUserFlow: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC004_LogoutUser  *****");
        
}
}
