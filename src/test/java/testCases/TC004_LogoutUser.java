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

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC004_LogoutUser extends BaseClass {

	@Test(description = "Verify Logout user")
    public void verifyLogoutUserFlow() throws InterruptedException {
		
		//logger.debug("");
		//logger.info("Step ");
		logger.debug("logging started");
		logger.info("starting TC004_LogoutUser");
			    
		HomePage home = new HomePage(driver);

		// Step 1-3: Navigate to home page and  Verify that home page is visible successfully
		 logger.info("Step 1: Launching the browser");
		 logger.info("Step 2: Navigating to baseURL: " + baseURL);
		 driver.get(baseURL);
	 
        // Step 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
		logger.info("Step 4: Click on 'Sign up / Login' button");
        home.clickSignup();

        logger.info("Step 5. Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        Reporter.log("'Login to your account' is visible", false);

        
        // Step 6-7: Enter correct email address and password, Click 'login' button,
        logger.info("Step 6. Enter correct email address and password ");
        home.setEmailAddressLogin(userEmail);
        home.setPassword(password);
        
        logger.info("Step 7. Click 'login' button");
        home.clickLogin();
        Reporter.log("Entered correct email address and password, Clicked 'login' button", false);
        
        logger.info("Step ");
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");
        Reporter.log("Login page is displayed");
        Thread.sleep(3000);
        
        //step 8: Verify that 'Logged in as username' is visible
        logger.info("Step 8. Verify that 'Logged in as user name' is visible");
        LoginPage Login=new LoginPage(driver);
        assertEquals(Login.msgLoginAsUserName().contains(userName),true,"'Logged in as username' is mis-match with username");
        Reporter.log("Verified that 'Logged in as username' is visible and matched with user name");
        
        //step 9-10:Click 'Logout' button,Verify that user is navigated to login page
        logger.info("Step 9. Click 'Logout' button");
        Login.clickLogout();
        
        logger.info("Step 10. Verify that user is navigated to login page");
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        Reporter.log("Clicked 'Logout' button,\nVerified that user is navigated to login page");
        Thread.sleep(3000);
        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC004_LogoutUser  *****");
        
}
}
