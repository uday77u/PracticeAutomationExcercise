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
	        HomePage home = new HomePage(driver);
	        
	        // Step 1-3: Navigate to home page and verify
	        driver.get(baseURL);
	        Reporter.log("Navigating to baseURL: " + baseURL, false);
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        Reporter.log("Home Page is displayed successfully", false);
	        
	       //step 4-5: Click on 'Test Cases' button,  Verify user is navigated to test cases page successfully
	        home.clickTestCases();
	        assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases","title mis match");
	        Reporter.log("Clicked on 'Test Cases' button,\nVerify user is navigated to test cases page successfully");
	
}
}