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


package testCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC005_RegisterUserWithExistingEmail extends BaseClass {

	@Test(description = "Verify Register user with Existing Email")
    public void verifyRegisterUserWithExistingEmailFlow() {
        HomePage home = new HomePage(driver);

        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        // Step 4-5: Click Signup/Login and verify 'New User Signup!'
        home.clickSignup();
        assertTrue(home.msgSignupVisible(), "'New User Signup!' is not visible");
        Reporter.log("'New User Signup!' is visible", false);

        // Step 6-7:Enter name and already registered email address,Click 'Signup' button
        home.setUserName(userName);
        home.setEmail(userEmail);
        home.clickBtnSignup();
        Reporter.log("Entered name and already registered email address,Clicked 'Signup' button", false);
        
       //step 8: Verify error 'Email Address already exist!' is visible
        assertEquals(home.errorMsgEmailAlreadyExist(), true,"Verify error 'Email Address already exist!' is not visible");
        Reporter.log("Verified error 'Email Address already exist!' is visible");
        
}
}
