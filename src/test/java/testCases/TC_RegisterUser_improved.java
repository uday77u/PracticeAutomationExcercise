package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SignupPage;

import java.time.Duration;

public class TC_RegisterUser_improved extends BaseClass {

    private WebDriverWait wait;

    @Test(description = "Verify user registration, login and account deletion")
    public void verifyUserRegistrationFlow() {
        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        // Step 1-3: Navigate to home page and verify
        driver.get(BASE_URL);
        logger.info("Navigating to baseURL: " + BASE_URL);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        logger.info("Home Page is displayed successfully");

        // Step 4-5: Click Signup/Login and verify 'New User Signup!'
        home.clickSignupOrLoginLink();
        assertTrue(home.msgSignupVisible(), "'New User Signup!' is not visible");
        logger.info("'New User Signup!' is visible");

        // Step 6-7: Enter name and email, click Signup
        home.setUserName(USER_NAME);
        home.setEmail(USER_EMAIL);
        home.clickBtnSignup();
        logger.info("Signup form submitted");

        // Step 8: Verify 'ENTER ACCOUNT INFORMATION' is visible
        waitForVisibility(signup.locatorEnterAccountInfo());
        assertTrue(signup.msgEnterAccountInfo(), "'ENTER ACCOUNT INFORMATION' is not visible");
        logger.info("'ENTER ACCOUNT INFORMATION' is visible");

        // Step 9-13: Fill account details and create account
        fillAccountDetails(signup);

        // Step 14: Verify 'ACCOUNT CREATED!' is visible
        waitForVisibility(signup.locatorAccountCreated());
        assertTrue(signup.msgAccountCreated(), "'ACCOUNT CREATED!' is not visible");
        logger.info("'ACCOUNT CREATED!' is visible");

        // Step 15: Click 'Continue' button
        signup.clickContinue();
        logger.info("Clicked on Continue");

        // Step 16: Verify 'Logged in as USER_NAME' is visible
        waitForVisibility(signup.locatorLoggedInAs());
        assertTrue(signup.msgLoggedInAs(USER_NAME), "'Logged in as " + USER_NAME + "' is not visible");
        logger.info("User is logged in as " + USER_NAME);

        // Step 17-18: Delete account and verify
       // deleteAccount(signup);
    }

    public void deleteAccount(SignupPage signup) {
        signup.clickdeleteAccount();
        logger.info("Clicked on Delete Account");

        // Step 18: Verify 'ACCOUNT DELETED!' and click Continue
        waitForVisibility(signup.locatorAccountDeleted());
        assertTrue(signup.msgaccountDeleted(), "'ACCOUNT DELETED!' is not visible");
        logger.info("'ACCOUNT DELETED!' is visible");

        signup.clickContinueD();
        logger.info("Clicked on Continue after deletion");

        assertEquals(driver.getTitle(), "Automation Exercise", "Return to home page failed");
        logger.info("Returned to Home Page successfully");
    }
    // Utility method to wait for an element to be visible
    
    private WebElement waitForVisibility(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fillAccountDetails(SignupPage signup) {
        signup.clickMr();
        signup.setPassword(PASSWORD);
        signup.setDay("23");
        signup.setMonth("December");
        signup.setYear("2020");

        signup.clickSignUpForOurNewsletter();
        signup.clickReceiveSpecialOffersFromOu();

        signup.setfirstName(USER_NAME);
        signup.setlastName("lastName");
        signup.setcompany("xyz");
        signup.setaddress("address1");
        signup.setaddress2("address2");
        signup.setcountry("Canada");
        signup.setstate("Karnataka");
        signup.setcity("Bangalore");
        signup.setzipcode("754852");
        signup.setmobileNumber("8867392044");

        logger.info("Filled account details");
        signup.clickcreateAccount();
        logger.info("Clicked on Create Account");
    }
}
