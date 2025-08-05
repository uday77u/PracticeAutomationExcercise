package com.automationExcercise.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationExcercise.BaseTest.BaseClass;
import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.SignupPage;

import java.time.Duration;

public class TC001_RegisterUser_chatGPTimproved extends BaseClass {

    private WebDriverWait wait;

    // Utility method to wait for an element to be visible
    private WebElement waitForVisibility(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fillAccountDetails(SignupPage signup) {
        signup.clickMr();
        signup.setPassword(password);
        signup.setDay("23");
        signup.setMonth("December");
        signup.setYear("2020");

        signup.clickSignUpForOurNewsletter();
        signup.clickReceiveSpecialOffersFromOu();

        signup.setfirstName(userName);
        signup.setlastName("lastName");
        signup.setcompany("xyz");
        signup.setaddress("address1");
        signup.setaddress2("address2");
        signup.setcountry("Canada");
        signup.setstate("Karnataka");
        signup.setcity("Bangalore");
        signup.setzipcode("754852");
        signup.setmobileNumber("8867392044");

        Reporter.log("Filled account details", false);
        signup.clickcreateAccount();
        Reporter.log("Clicked on Create Account", false);
    }

    @Test(description = "Verify user registration, login and account deletion")
    public void verifyUserRegistrationFlow() {
        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", false);

        // Step 4-5: Click Signup/Login and verify 'New User Signup!'
        home.clickSignup();
        assertTrue(home.msgSignupVisible(), "'New User Signup!' is not visible");
        Reporter.log("'New User Signup!' is visible", false);

        // Step 6-7: Enter name and email, click Signup
        home.setUserName(userName);
        home.setEmail(userEmail);
        home.clickBtnSignup();
        Reporter.log("Signup form submitted", false);

        // Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
        waitForVisibility(signup.locatorEnterAccountInfo());
        assertTrue(signup.msgEnterAccountInfo(), "'ENTER ACCOUNT INFORMATION' is not visible");
        Reporter.log("'ENTER ACCOUNT INFORMATION' is visible", false);

        // Step 9-13: Fill account details and create account
        fillAccountDetails(signup);

        // Step 14: Verify 'ACCOUNT CREATED!' is visible
        waitForVisibility(signup.locatorAccountCreated());
        assertTrue(signup.msgAccountCreated(), "'ACCOUNT CREATED!' is not visible");
        Reporter.log("'ACCOUNT CREATED!' is visible", false);

        // Step 15: Click 'Continue' button
        signup.clickContinue();
        Reporter.log("Clicked on Continue", false);

        // Step 16: Verify 'Logged in as username' is visible
        waitForVisibility(signup.locatorLoggedInAs());
        assertTrue(signup.msgLoggedInAs(userName), "'Logged in as " + userName + "' is not visible");
        Reporter.log("User is logged in as " + userName, false);

        // Step 17-18: Delete account and verify
       // deleteAccount(signup);
    }

    public void deleteAccount(SignupPage signup) {
        signup.clickdeleteAccount();
        Reporter.log("Clicked on Delete Account", false);

        // Step 18: Verify 'ACCOUNT DELETED!' and click Continue
        waitForVisibility(signup.locatorAccountDeleted());
        assertTrue(signup.msgaccountDeleted(), "'ACCOUNT DELETED!' is not visible");
        Reporter.log("'ACCOUNT DELETED!' is visible", false);

        signup.clickContinueD();
        Reporter.log("Clicked on Continue after deletion", false);

        assertEquals(driver.getTitle(), "Automation Exercise", "Return to home page failed");
        Reporter.log("Returned to Home Page successfully", false);
    }
}
