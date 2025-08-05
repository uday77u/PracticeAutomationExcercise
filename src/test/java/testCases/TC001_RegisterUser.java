/* Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully      --m1
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible               --m2
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible   --m3
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible             --m4
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button                      
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button  --m5
*/ 



package testCases;

import static org.testng.Assert.assertEquals;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SignupPage;


public class TC001_RegisterUser extends BaseClass {

 public void fillAccountDetails(SignupPage signup) throws InterruptedException {
		   Thread.sleep(3000);
	     signup.clickMr();
		 signup.setPassword(password);
		 signup.setDay("23");
		 Thread.sleep(3000);
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
 
@Test
public void VerifyHomePage()
{
	
	Reporter.log("Navigating to baseUrl: " + baseURL, false);
	assertEquals(driver.getTitle(),"Automation Exercise","Mismatch in the title");
	Reporter.log("HomePage is displayed successfully", false);

}

@Test(description = "Verify user registration, login and account deletion")
public void verifySignupRegistration() throws InterruptedException {
    HomePage home = new HomePage(driver);
    
    home.clickSignup();
    Reporter.log("Clicked on Signup link", false);

    assertEquals(home.msgSignupVisible(), true, "'New User Signup!'- is not visible");
    Reporter.log("'New User Signup!'- is visible", false);
    
    home.setUserName(userName);
    Reporter.log("Entered username", false);

    home.setEmail(userEmail);
    Reporter.log("Entered Email", false);

    home.clickBtnSignup();
    Reporter.log("clicked on Signup", false);
    Thread.sleep(3000);
    assertEquals(driver.getTitle(),"Automation Exercise - Signup","Mismatch in the title");
    Reporter.log("Signup Page is displayed successfully", false);
    Thread.sleep(3000);
    
    SignupPage signup = new SignupPage(driver);
    assertEquals(signup.msgEnterAccountInfo(), true, "'ENTER ACCOUNT INFORMATION' is  not visible ");
    Reporter.log("'ENTER ACCOUNT INFORMATION' is visible", false);
    
    fillAccountDetails(signup);
    
    assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
    Reporter.log("'Acount created'- is visible",false);
    
    signup.clickContinue();
    Reporter.log("click on continue",false);
    
    assertEquals(signup.msgLoggedInAs(userName), true,"'LoggedInAs(userName)'- is not visible");
    Reporter.log("'LoggedInAs(userName)",false);
    
    DeleteAccount(signup);
       
}

public void DeleteAccount(SignupPage signup) throws InterruptedException
{
	signup.clickdeleteAccount();
    Reporter.log("click on deleteAccount",false);
    
    Thread.sleep(4000);
    signup.clickContinueD();
    Reporter.log("click on continue",false);
    
    assertEquals(driver.getTitle(),"Automation Exercise","Mismatch in the title");
    Reporter.log("Deleted the account and the HomePagedisplaced ",false);
}

}



/*



wait.until(driver -> login.visibleTxtAccCrtDisplayed());
assertEquals(login.visibleTxtAccCrtDisplayed(), true, "'Account Created' not visible");

login.clickBtnContinue();
Reporter.log("Clicked on Continue after account creation", true);

String displayedName = login.getLoginDisplayedName();
assertEquals(displayedName.trim().toLowerCase(), userName.trim().toLowerCase(), "Username display mismatch");

// Optional: Delete account step
/*
login.clickDeleteAcc();
Reporter.log("Clicked on Delete account", true);

login.clickBtnContinue();
Reporter.log("Clicked on Continue after deleting account", true);
*/

