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

package com.automationExcercise.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationExcercise.BaseTest.BaseClass;
import com.automationExcercise.pageObjects.HomePage;

public class TC003_LoginUserIncorrectEmailAndPassword extends BaseClass {

	@Test(description = "Verify Login User incorrectEmail and Password")
    public void verifyLoginUserIncorrectEmailAndPasswordFlow() throws InterruptedException {
        HomePage home = new HomePage(driver);

        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        // Step 4-5: Click on 'Sign up/Login' button and Verify 'Login to your account' is visible 
        home.clickSignup();
        Thread.sleep(2000);
        assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");
        Reporter.log("'Login to your account' is visible", false);

        // Step 6-7: Enter incorrect email address and password, Click 'login' button,
        home.setEmailAddressLogin(userEmail);
        home.setPassword(password);
        home.clickLogin();
        Reporter.log("Entered incorrect email address and password, \nClicked 'login' button", false);
        
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        Reporter.log("HomePage is displayed");
        Thread.sleep(3000);
        
        //step 8: Verify error 'Your email or password is incorrect!' is visible
        assertEquals(home.errorMsgExist(),true,"Error Message is not displayed");
        Reporter.log("Verified error 'Your email or password is incorrect!' is visible");
        
    
}
}
