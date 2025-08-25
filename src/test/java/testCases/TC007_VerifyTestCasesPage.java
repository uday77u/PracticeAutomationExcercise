/*
 * Test Case 7: Verify Test Cases Page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
 */
package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC007_VerifyTestCasesPage extends BaseClass{

	 @Test(description = "Verify Contact us Form")
	    public void verifyContactUsForm() throws InterruptedException {
			try {
		 	//logger.debug("");
			//logger.info("");
			logger.debug("logging started");
		    logger.info("starting TC007_VerifyTestCasesPage");
		    
	        HomePage home = new HomePage(driver);

	     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
	        logger.info("Step 1: Launching the browser");
	        logger.info("Step 2: Navigating to baseURL: " + baseURL);
	        driver.get(baseURL);
	        
	        logger.info("Step 3: Verifying that home page is visible successfully");
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        Reporter.log("Home Page is displayed successfully", false);
	        
	       //step 4-5: Click on 'Test Cases' button,  Verify user is navigated to test cases page successfully
	        logger.info("Step 4: Click on 'Test Cases' button");
	        home.clickTestCases();
	        logger.info("Step 5: Verify user is navigated to test cases page successfully");
	        
			}
			catch (AssertionError ae) {
		        logger.error("❌ Assertion failed in verifyContactUsForm: " + ae.getMessage(), ae);
		        throw ae; // rethrow so TestNG marks test as failed
		    } catch (Exception e) {
		        logger.error("❌ Unexpected exception in verifyContactUsForm: " + e.getMessage(), e);
		        throw e; // rethrow so TestNG marks test as failed
		    }
			
	        logger.debug("application logs end.......");
	    	logger.info("**** finished TC007_VerifyTestCasesPage  *****"); 
	
}
}