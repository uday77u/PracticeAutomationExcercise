package BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageObjects.HomePage;
import pageObjects.SignupPage;

public class GeneralScriptsForAccountCreation extends BaseClass {
	
	GenericScript gs=new GenericScript(driver);
	public String userName=gs.setRandomAlphabete(6);
	public String email=gs.setRandomAlphabete(6)+"@gmail"+gs.setRandomAlphabete4();
	public String lastName=gs.setRandomAlphabete(6); 
	public String address1=gs.setRandomAlphabete(6)+" "+gs.setRandomAlphabete4();
	public String address2=gs.setRandomAlphabete4()+" "+gs.setRandomAlphabete4();
	public String MobileNumber=gs.setRandomNumber(10);
	
	 public void VerifyHomePage()
	 {
	 	
	 	Reporter.log("Navigating to baseUrl: " + baseURL, false);
	 	assertEquals(driver.getTitle(),"Automation Exercise","Mismatch in the title");
	 	Reporter.log("HomePage is displayed successfully", false);

	 }
	 
	 //Register account
	 public void verifySignupRegistration(WebDriver driver) throws InterruptedException {
		    HomePage home = new HomePage(driver);
		    SignupPage signup = new SignupPage(driver);
		    
		  
		    home.clickSignup();
		    //Reporter.log("Clicked on Signup link", true);

		    assertTrue(home.msgSignupVisible(),"'New User Signup!'- is not visible");
		    Reporter.log("'New User Signup!'- is visible,(Signup Page is opened Successfully)", true);
		    
		    home.setUserName(userName);
		    Reporter.log("Entered username: "+userName, true);

		    home.setEmail(email);
		    Reporter.log("Entered Email: "+email, true);

		    home.clickBtnSignup();
		    //Reporter.log("clicked on Signup", true);
		    Thread.sleep(3000);
		    assertEquals(driver.getTitle(),"Automation Exercise - Signup","Mismatch in the title");
		    //Reporter.log("Signup Page is displayed successfully", true);
		    Thread.sleep(3000);
		 
		    assertEquals(signup.msgEnterAccountInfo(), true, "'ENTER ACCOUNT INFORMATION' is  not visible ");
		    //Reporter.log("'ENTER ACCOUNT INFORMATION' is visible", true);
		    
		    fillAccountDetails(signup);
		    
		    assertEquals(signup.msgAccountCreated(), true,"'Acount created'- is not visible");
		    Reporter.log("'Acount created'- is visible",true);
		    
		    signup.clickContinue();
		    //Reporter.log("click on continue",true);
		    
		    assertTrue(signup.msgLoggedInAs(userName),"'LoggedInAs(userName)'- is not visible");
		    Reporter.log("'LoggedInAs: "+userName+"\n",true);

		}
	 
	 //Fill account details
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
		signup.setlastName(lastName);
		signup.setcompany("xyz");
		signup.setaddress(address1);
	    signup.setaddress2(address2);
	    signup.setcountry("Canada");
	    signup.setstate("Karnataka");
	    signup.setcity("Bangalore");
	    signup.setzipcode("754852");
	    signup.setmobileNumber(MobileNumber);
	    Reporter.log("Filled account details", false);
	    signup.clickcreateAccount();
	    Reporter.log("Clicked on Create Account", false);
	    
	}
	 
	 //Delete the Account
	 public void DeleteAccount(WebDriver driver, SignupPage signupPage ) throws InterruptedException
	 {
		
	 	signupPage.clickdeleteAccount();
	     //Reporter.log("click on deleteAccount",false);
	     
	     Thread.sleep(4000);
	     signupPage.clickContinueD();
	     //Reporter.log("click on continue",true);
	     
	     assertEquals(driver.getTitle(),"Automation Exercise","Mismatch in the title");
	     Reporter.log("Deleted the account and the HomePagedisplaced ",true );
	 }


}
