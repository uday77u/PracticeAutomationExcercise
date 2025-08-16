/*
 * Test Case 6: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */


package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.ContactUsFormPage;
import pageObjects.HomePage;

public class TC006_ContactUsForm extends BaseClass{

	 @Test(description = "Verify Contact us Form")
	    public void verifyContactUsForm() throws InterruptedException {
		 
		 	HomePage home = new HomePage(driver);
	        ContactUsFormPage contactus=new ContactUsFormPage(driver);
	        
			//logger.debug("");
			//logger.info("Step ");
			logger.debug("logging started");
		    logger.info("starting TC006_ContactUsForm");
		    
	        
	     // Step 1-3: Navigate to home page and  Verify that home page is visible successfully
	        logger.info("Step 1: Launching the browser");
	        logger.info("Step 2: Navigating to baseURL: " + baseURL);
	        driver.get(baseURL);

	        logger.info("Step 3: Verifying that home page is visible successfully");
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        Reporter.log("Home Page is displayed successfully", false);
	        
	        //step 4-5: Click on 'Contact Us' button, Verify 'GET IN TOUCH' is visible
	        logger.info("Step 4: Click on 'Contact Us' button");
	        home.clickContactUs();
	        
	        logger.info("Step 5: Verify 'GET IN TOUCH' is visible");
	        assertEquals(contactus.msgGetInTouch(), true,"GET IN TOUCH is not visible");

	        //step 6-10: Enter name, email, subject and message,Upload file,Click 'Submit' button,Click OK button
	        logger.info("Step 6: Enter name, email, subject and message");
	        contactus.setName(userName);
	        contactus.setemail(userEmail);
	        contactus.setSubject("Sub message");
	        contactus.setYourMessageHere("This is message");
	        Thread.sleep(2000);
	        
	        JavascriptExecutor js=(JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", contactus.locatorUploadFile());
	        Thread.sleep(4000);
	        
	        logger.info("Step 7: Upload file --Skipped--");
	        /*Upload file step --skip--
	        contactus.clickUploadFile();
	        Thread.sleep(4000);
	        */
	        
	        logger.info("Step 8: Click 'Submit' button");
	        contactus.clickSubmit();
	        Thread.sleep(2000);
	        Reporter.log("Entered name, email, subject and message,Upload file,Click 'Submit' button,Click OK button");
	        
	        logger.info("Step 9: Click OK button");
	        driver.switchTo().alert().accept();
	        
	        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
	        logger.info("Step 10: Verify success message 'Success! Your details have been submitted successfully.' is visible");
	        assertEquals(contactus.msgSuccessExist(),true, "Success! message is not displayed");

	       //step 11: Click 'Home' button and verify that landed to home page successfully
	        logger.info("Step 11: Click 'Home' button and verify that landed to home page successfully");
	        contactus.clickHome();
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        
	        
	        
	        logger.debug("application logs end.......");
	    	logger.info("**** finished TC006_ContactUsForm  *****"); 
	        
	        
	        
}
}
