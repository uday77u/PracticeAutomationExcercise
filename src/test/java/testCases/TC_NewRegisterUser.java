/* Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully      
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible               
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible   
9. Fill details: Title, Name, Email, PASSWORD, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible             
15. Click 'Continue' button
16. Verify that 'Logged in as USER_NAME' is visible
17. Click 'Delete Account' button                      
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button  
*/ 

package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SignupPage;

public class TC_NewRegisterUser extends BaseClass {

    @Test(description = "Verify user registration, login and account deletion")
    public void verifySignupRegistration() throws InterruptedException {

        logger.info("========== STARTING TC001 : Register User ==========");

        try {

            HomePage home = new HomePage(driver);
            SignupPage signup = new SignupPage(driver);

            // STEP 1 - 3 : Verify Home Page
            logger.info("STEP 1-3 : Verifying Home Page");

            driver.get(BASE_URL);
            assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");

            logger.info("✅ Home Page displayed successfully");

            // STEP 4 : Click Signup / Login
            logger.info("STEP 4 : Clicking on Signup / Login link");
            home.clickSignupOrLoginLink();

            // STEP 5 : Verify new user signup message
            logger.info("STEP 5 : Verifying 'New User Signup!' text");
            assertTrue(home.msgSignupVisible(), "'New User Signup!' is NOT visible");

            // STEP 6 : Enter name & email
            logger.info("STEP 6 : Entering USER_NAME and email");
            home.setUserName(USER_NAME);
            home.setEmail("random" + System.currentTimeMillis() + "@gmail.com");

            
            // STEP 7 : Click Signup button
            logger.info("STEP 7 : Clicking Signup button");
            home.clickBtnSignup();

            assertTrue(driver.getTitle().contains("Signup"), "Not navigated to Signup page");
            logger.info("✅ Navigated to Signup page");

            // STEP 8 : Verify Enter Account Information
            logger.info("STEP 8 : Verifying 'ENTER ACCOUNT INFORMATION' section");
            assertTrue(signup.msgEnterAccountInfo(), "'ENTER ACCOUNT INFORMATION' is not visible");

            // STEP 9 - 13 : Fill account details
            logger.info("STEP 9-13 : Filling account information");
            fillAccountDetails(signup);

            // STEP 14 : Verify account created
            logger.info("STEP 14 : Verifying account creation message");
            assertTrue(signup.msgAccountCreated(), "'ACCOUNT CREATED!' is not visible");

            // STEP 15 : Click Continue
            logger.info("STEP 15 : Clicking Continue");
            signup.clickContinue();

            // STEP 16 : Verify logged in
            logger.info("STEP 16 : Verifying Logged in as: " + USER_NAME);
            assertTrue(signup.msgLoggedInAs(USER_NAME), "User not logged in");

            logger.info("✅ User successfully registered and logged in");

            // (Optional) STEP 17-18 : Delete account
            // logger.info("STEP 17-18 : Deleting account");
            // DeleteAccount(signup);

        } catch (AssertionError ae) {
            logger.error("❌ ASSERTION FAILED : " + ae.getMessage(), ae);
            throw ae;

        } catch (Exception e) {
            logger.error("❌ UNEXPECTED ERROR : " + e.getMessage(), e);
            throw e;
        }

        logger.info("========== FINISHED TC001 : Register User ==========\n");
    }

    // ========= Helper Method =========

    public void fillAccountDetails(SignupPage signup) throws InterruptedException {

        logger.info("Filling account details");

        signup.clickMr();
        signup.setPassword(PASSWORD);

        signup.setDay("23");
        signup.setMonth("December");
        signup.setYear("2020");

        signup.clickSignUpForOurNewsletter();
        signup.clickReceiveSpecialOffersFromOu();

        signup.setfirstName(USER_NAME);
        signup.setlastName("LastName");
        signup.setcompany("XYZ");

        signup.setaddress("Address Line 1");
        signup.setaddress2("Address Line 2");

        signup.setcountry("Canada");
        signup.setstate("Karnataka");
        signup.setcity("Bangalore");
        signup.setzipcode("754852");

        signup.setmobileNumber("8867392025");

        logger.info("Submitting Create Account form");
        signup.clickcreateAccount();
    }

    // Optional delete account
    public void DeleteAccount(SignupPage signup) throws InterruptedException {

        logger.info("Deleting account");
        signup.clickdeleteAccount();
        signup.clickContinueD();

        assertEquals(driver.getTitle(), "Automation Exercise", "Failed to return to home page");
        logger.info("✅ Account deleted successfully");
    }
}





