package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002b_LoginUserWithCorrectEmailAndPasswordAndDelete extends BaseClass{
	@Test(priority =2)
	public void verifyLoginUserWithCorrectEmailAndPasswordAndDeletion() throws InterruptedException {
		try {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC002_LoginUserWithCorrectEmailAndPassword");
	    
        HomePage home = new HomePage(driver);

     // STEP 1-3: Navigate to home page and  Verify that home page is visible successfully
        logger.info("STEP 1: Launching the browser");
        logger.info("STEP 2: Navigating to baseURL: " + BASE_URL);
        driver.get(BASE_URL);

        logger.info("STEP 3: Verifying that home page is visible successfully");
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");


        // STEP 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
        logger.info("STEP 4: Click on 'Signup / Login' button");
        home.clickSignupOrLoginLink();
        Thread.sleep(2000);
        
        logger.info("STEP 5: Verify 'Login to your account' is visible");
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        logger.info("'Login to your account' is visible");

        
        // STEP 6-7: Enter correct email address and password, Click 'login' button,
        logger.info("STEP 6: Enter correct email address and password");
        home.setEmailAddressLogin(USER_EMAIL_Temp);
        home.setPassword(PASSWORD);
        
        logger.info("STEP 7: Click 'login' button");
        home.clickLogin();
        
        logger.info("Navigating to 'Login'Page");
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");

        Thread.sleep(3000);
        
        //STEP 8: Verify that 'Logged in as username' is visible
        logger.info("STEP 8: Verify that 'Logged in as username' is visible");
        LoginPage Login=new LoginPage(driver);
        assertEquals(Login.msgLoginAsUserName().contains(USER_NAME),true,"'Logged in as username' is mis-match with username");
        
       //STEP 9-10: Click 'Delete Account' button,Verify that 'ACCOUNT DELETED!' is visible
        logger.info("STEP 9: Click 'Delete Account' button");
        Login.clickDeletelogin();
        
        logger.info("STEP 10: Verify that 'ACCOUNT DELETED!' is visible");
        assertEquals(Login.msgDeleteAccount(),"ACCOUNT DELETED!"," 'ACCOUNT DELETED!' is not visible");
        
        logger.info("clocking on the 'Continue' button after Delete");
        Login.clickContinueBtnAfterDelete();

		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in verifyLoginUserWithCorrectEmailAndPasswordFlow: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in verifyLoginUserWithCorrectEmailAndPasswordFlow: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
		
        logger.debug("application logs end.......");
    	logger.info("**** finished TC002_LoginUserWithCorrectEmailAndPassword with Deleted Account*****"); 
         

    }
	

}
