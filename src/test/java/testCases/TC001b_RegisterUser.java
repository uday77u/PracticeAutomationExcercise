package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SignupPage;

public class TC001b_RegisterUser extends BaseClass{
	@Test
	public void verifySignupRegistration(){
		try {
		//logger.debug("");
		//logger.info("");
		logger.debug("logging started");
	    logger.info("starting TC001_RegisterUser");
	    
	    HomePage home = new HomePage(driver);
	    
	 // STEP 1-3: Navigate to home page and  Verify that home page is visible successfully
	    logger.info("STEP 1: Launching the browser");
	    logger.info("STEP 2: Navigating to baseURL: " + BASE_URL);
	    driver.get(BASE_URL);

	    logger.info("STEP 3: Verifying that home page is visible successfully");
	    assertTrue(driver.getTitle().contains(HOME_TITLE),"Home page title mismatch");
	    logger.info("Home Page is displayed successfully");
	    
	    logger.info("STEP 4: Clicking on 'Signup / Login' button");
	    home.clickSignupOrLoginLink();
	                   
	    logger.info("STEP 5: Verify 'New User Signup!' is visible ");
	    assertTrue(home.msgSignupVisible(), "'New User Signup!'- is not visible");
	    
	    logger.info("STEP 6: Enter name and email address");
	    home.setUserName(USER_NAME);
	    home.setEmail(USER_EMAIL_Temp);
	   // home.setEmail("Random."+System.currentTimeMillis()+"@gmail.com");

	    logger.info("STEP 7: Click 'Signup' button");
	    home.clickBtnSignup();

	    logger.info("Navigating to 'signup' page");
	    assertTrue(driver.getTitle().contains(SIGNUP_TITLE),"Mismatch in the title"+driver.getTitle());

	    logger.info("STEP 8: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
	    SignupPage signup = new SignupPage(driver);
	    assertTrue(signup.msgEnterAccountInfo(),"'ENTER ACCOUNT INFORMATION' is  not visible ");
	   
	    logger.info("STEP 9: Fill details: Title, Name, Email, Password, Date of birth");
	    logger.info("STEPs 10-13: starting");
	    fillAccountDetails(signup);

	    logger.info("STEP 14: Verify that 'ACCOUNT CREATED!' is visible");
	    assertTrue(signup.msgAccountCreated(),"'Acount created'- is not visible");
	    
	    logger.info("STEP 15: Click 'Continue' button");
	    signup.clickContinue();
	    
	    logger.info("STEP 16: Verify that 'Logged in as username' is visible");
	    assertTrue(signup.msgLoggedInAs(USER_NAME),"'LoggedInAs(userName)'- is not visible");
	    logger.info("'LoggedInAs(userName)");

	    
		}
		catch (AssertionError ae) {
	        logger.error("❌ Assertion failed in verifySignupRegistration: " + ae.getMessage(), ae);
	        throw ae; // rethrow so TestNG marks test as failed
	    } catch (Exception e) {
	        logger.error("❌ Unexpected exception in verifySignupRegistration: " + e.getMessage(), e);
	        throw e; // rethrow so TestNG marks test as failed
	    }
	    logger.debug("application logs end.......");
		logger.info("**** finished TC001b_RegisterUser  *****"); 
		
	}

	//******************helper methods***********************************************
	//Filling account details
	public void fillAccountDetails(SignupPage signup) {
		 
		 logger.info("Filling the account details");

		 logger.info("clicking on the 'Mr.' radio button");
		 signup.clickMr();
		 
		 logger.info("set the password");
		 signup.setPassword(PASSWORD);
		 
		 logger.info("set the day in 'Day' dropdown");
		 signup.setDay("23");
		 
		 logger.info("set the Month");
		 signup.setMonth("December");
		 
		 logger.info("set the year");
		 signup.setYear("2020");
		 
		 logger.info("checking the'SignUpForOurNewsletter' check box ");
		 signup.clickSignUpForOurNewsletter();
		 
		 logger.info("checking the 'ReceiveSpecialOffersFromOu' check box");
		 signup.clickReceiveSpecialOffersFromOu();
		 
		 logger.info("set the first name");
		 signup.setfirstName(USER_NAME);
		 
		 logger.info("set the last name");
		 signup.setlastName("lastName");
		 
		 logger.info("set company name");
			signup.setcompany("xyz");
			
		 logger.info("set the address1");
		 signup.setaddress("address1");
			
		 logger.info("set the address2");
		 signup.setaddress2("address2");
		    
		 logger.info("set the country");
		 signup.setcountry("Canada");
		    
		 logger.info("set the state");
		 signup.setstate("Karnataka");
		    
		 logger.info("set the city");
		 signup.setcity("Bangalore");
		    
		 logger.info("set the zipcode");
		 signup.setzipcode("754852");
		    
		 logger.info("set mobile number");
		 signup.setmobileNumber("8867392025");
		 	    
		 logger.info("Clicking on Create Account");
		 signup.clickcreateAccount();

		 

		}



}
