package com.automationExcercise.BaseTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.SignupPage;
import com.automationExcercise.utilities.ExcellUtilities;

public class GenericScript{
	WebDriver driver;
	public  GenericScript(WebDriver driver) {
		this.driver=driver;
	}
	public String RandomEmail=setRandomAlphabete(6)+"@gmail";
	public String RandomPassword=setRandomAlphanumeric8();
	
	
	
	public String RandomUserName = setRandomAlphabete4();
	// set fixed lengh of random alphabet\Alphanumeric\Numeric methods
	public String setRandomAlphabete4() {
		return RandomStringUtils.randomAlphabetic(4);
	}
	
	public String setRandomAlphanumeric8() {
		return RandomStringUtils.randomAlphanumeric(8);
	}
	
	public String setRandomNumber10() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	
	
	// set dynamic lengh of random alphabet\Alphanumeric\Numeric methods
	public String setRandomAlphabete(int s) {
		return RandomStringUtils.randomAlphabetic(s);
	}
	
	public String setRandomAlphanumeric(int s) {
		return RandomStringUtils.randomAlphanumeric(s);
	}
	
	public String setRandomNumber(int s) {
		return RandomStringUtils.randomNumeric(s);
	}

	//generate the random date(0-30) method
	public String setDate() {
    Random random = new Random();
    int dataN = random.nextInt(31); // generates number from 0 to 30 inclusive
    String date = Integer.toString(dataN);
    //System.out.println("date: " + date);
    return date;
	}
	
	//generate the random Year(1900-2021)  method
	public String setYear() {
	    Random random = new Random();
	    int yearN = 1900 + random.nextInt(2022 - 1900); // 1900 to 2021 inclusive
	    String year = Integer.toString(yearN);
	    //System.out.println("year: " + year);
	    return year;
	}
	 
	//------------Create Account With RandomData in AutomationExcercise----------
	public void CreateAccountWithRandomData(HomePage home) throws IOException {
		
	    home.clickSignup();
	    Reporter.log("Clicked on Signup link", false);

	    assertEquals(home.msgSignupVisible(), true, "'New User Signup!'- is not visible");
	    Reporter.log("'New User Signup!'- is visible", false);
	    
	    home.setUserName(RandomUserName);
	    Reporter.log("Entered username", false);

	    
	    home.setEmail(RandomEmail);
	    System.out.println("RandomEmail: "+RandomEmail);
	    ExcellUtilities xl = new ExcellUtilities("./Data/TestData.xlsx");
        
       
	    Reporter.log("Entered Email", false);

	    home.clickBtnSignup();
	    Reporter.log("clicked on Signup", false);
	    
	    
	}
	
	
	//fill details of creating new account with random details in AutomationExcercise
	public void fillAccountDetailsWithRandomData(SignupPage signup) throws IOException {
        signup.clickMr();
        
        signup.setPassword(RandomPassword);
        System.out.println("RandomPassword: "+RandomPassword);
        ExcellUtilities xl = new ExcellUtilities("./Data/TestData.xlsx");
        
        signup.setDay(setDate());
        signup.setMonth("December");
        signup.setYear(setYear());

        signup.clickSignUpForOurNewsletter();
        signup.clickReceiveSpecialOffersFromOu();

        signup.setfirstName(setRandomAlphabete4());
        signup.setlastName(setRandomAlphabete4());
        signup.setcompany(setRandomAlphabete(6));
        signup.setaddress(setRandomAlphabete(10));
        signup.setaddress2(setRandomAlphabete(10));
        signup.setcountry("Canada");
        signup.setstate("Karnataka");
        signup.setcity("Bangalore");
        signup.setzipcode("754852");
        signup.setmobileNumber(setRandomNumber10());

        Reporter.log("Filled account details", false);
        signup.clickcreateAccount();
        xl.enterUserDataInExcel("RandomPassword: "+RandomPassword+"RandomEmail: "+RandomEmail+"AccountCreated");
        Reporter.log("Clicked on Create Account", false);
    }
	
	//Delete the account and verify
	public void DeleteAccount(SignupPage signup) throws InterruptedException, IOException
	{
		signup.clickdeleteAccount();
	    Reporter.log("click on deleteAccount",false);
	    
	    Thread.sleep(4000);
	    ExcellUtilities xl = new ExcellUtilities("./Data/TestData.xlsx");
	    xl.enterUserDataInExcel("RandomPassword: "+RandomPassword+"RandomEmail: "+RandomEmail+"AccountDeleted");
	    signup.clickContinueD();
	    Reporter.log("click on continue",false);
	    
	    assertEquals(driver.getTitle(),"Automation Exercise","Mismatch in the title");
	    Reporter.log("Deleted the account and the HomePagedisplaced ",false);
	}
}






/*//setDate fail,setting 08 instead of 8;
public String setDate() {
    String date;
    int dataN;

    do {
        date = RandomStringUtils.randomNumeric(2);
        dataN = Integer.parseInt(date);
    } while (dataN > 30);

    System.out.println("date: " + date);
    return date;
}

public String setYear() {
	String year;
	int yearN;
	do {
	year = RandomStringUtils.randomNumeric(4);
	yearN=Integer.parseInt(year);
	}while(yearN>=1900 || yearN<=2021);
	
	System.out.println("year: "+year);
	return year;
}
*/
