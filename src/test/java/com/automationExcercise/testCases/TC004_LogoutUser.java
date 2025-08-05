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






package com.automationExcercise.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationExcercise.BaseTest.BaseClass;
import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.LoginPage;

public class TC004_LogoutUser extends BaseClass {

	@Test(description = "Verify Logout user")
    public void verifyLogoutUserFlow() throws InterruptedException {
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

        // Step 6-7: Enter correct email address and password, Click 'login' button,
        home.setEmailAddressLogin(userEmail);
        home.setPassword(password);
        home.clickLogin();
        Reporter.log("Entered correct email address and password, Clicked 'login' button", false);
        
        assertEquals(driver.getTitle(), "Automation Exercise","Login page title is mis-match");
        Reporter.log("Login page is displayed");
        Thread.sleep(3000);
        
        //step 8: Verify that 'Logged in as username' is visible
        LoginPage Login=new LoginPage(driver);
        assertEquals(Login.msgLoginAsUserName().contains(userName),true,"'Logged in as username' is mis-match with username");
        Reporter.log("Verified that 'Logged in as username' is visible and matched with user name");
        
        //step 9-10:Click 'Logout' button,Verify that user is navigated to login page
        Login.clickLogout();
        assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login","Login page title is mis-match");
        Reporter.log("Clicked 'Logout' button,\nVerified that user is navigated to login page");
        Thread.sleep(3000);
        
}
}
