/*
 * 
 Test Case 2: Login User with correct email and password
 -------------------------------------------------------------------
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
 */

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginUserWithCorrectEmailAndPassword extends BaseClass {

	@Test(description = "Verify Login User with correct Email And Password")
    public void verifyLoginUserWithCorrectEmailAndPasswordFlow() throws InterruptedException {
		
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC002_LoginUserWithCorrectEmailAndPassword");
	    
        HomePage home = new HomePage(driver);

     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("Step 1: Launching the browser");
        logger.info("Step 2: Navigating to baseURL: " + baseURL);
        driver.get(baseURL);

        logger.info("Step 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");


        // Step 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
        logger.info("Step 4: Click on 'Signup / Login' button");
        home.clickSignup();
        Thread.sleep(2000);
        
        logger.info("Step 5: Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        Reporter.log("'Login to your account' is visible", false);

        
        // Step 6-7: Enter correct email address and password, Click 'login' button,
        logger.info("Step 6: Enter correct email address and password");
        home.setEmailAddressLogin(userEmail);
        home.setPassword(password);
        
        logger.info("Step 7: Click 'login' button");
        home.clickLogin();
        
        logger.info("Navigating to 'Login'Page");
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");

        Thread.sleep(3000);
        
        //step 8: Verify that 'Logged in as username' is visible
        logger.info("Step 8: Verify that 'Logged in as username' is visible");
        LoginPage Login=new LoginPage(driver);
        assertEquals(Login.msgLoginAsUserName().contains(userName),true,"'Logged in as username' is mis-match with username");
        
       //step 9-10: Click 'Delete Account' button,Verify that 'ACCOUNT DELETED!' is visible
        logger.info("Step 9: Click 'Delete Account' button");
        Login.clickDeletelogin();
        
        logger.info("Step 10: Verify that 'ACCOUNT DELETED!' is visible");
        assertEquals(Login.msgDeleteAccount(),"ACCOUNT DELETED!"," 'ACCOUNT DELETED!' is not visible");
        
        logger.info("clocking on the 'Continue' button after Delete");
        Login.clickContinueBtnAfterDelete();

        
        logger.debug("application logs end.......");
    	logger.info("**** finished TC002_LoginUserWithCorrectEmailAndPassword  *****"); 
         

    }
	
}
