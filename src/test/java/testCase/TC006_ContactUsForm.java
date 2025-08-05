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


package testCase;

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
	        
	        // Step 1-3: Navigate to home page and verify
	        driver.get(baseURL);
	        Reporter.log("Navigating to baseURL: " + baseURL, false);
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        Reporter.log("Home Page is displayed successfully", false);
	        
	        //step 4-5: Click on 'Contact Us' button, Verify 'GET IN TOUCH' is visible
	        home.clickContactUs();
	        ContactUsFormPage contactus=new ContactUsFormPage(driver);
	        assertEquals(contactus.msgGetInTouch(), true,"GET IN TOUCH is not visible");
	        Reporter.log("Clicked on 'Contact Us' button,\n Verified 'GET IN TOUCH' is visible");
	        
	        //step 6-10: Enter name, email, subject and message,Upload file,Click 'Submit' button,Click OK button
	        contactus.setName(userName);
	        contactus.setemail(userEmail);
	        contactus.setSubject("Sub message");
	        contactus.setYourMessageHere("This is message");
	        Thread.sleep(2000);
	        
	        JavascriptExecutor js=(JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", contactus.locatorUploadFile());
	        Thread.sleep(4000);
	        
	        /*Upload file step
	        contactus.clickUploadFile();
	        Thread.sleep(4000);
	        */
	        
	        contactus.clickSubmit();
	        Thread.sleep(2000);
	        Reporter.log("Entered name, email, subject and message,Upload file,Click 'Submit' button,Click OK button");
	        
	        driver.switchTo().alert().accept();
	        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
	        assertEquals(contactus.msgSuccessExist(),true, "Success! message is not displayed");
	        Reporter.log(" Verify success message 'Success! Your details have been submitted successfully.' is visible");

	       //step 11: Click 'Home' button and verify that landed to home page successfully
	        contactus.clickHome();
	        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
	        Reporter.log("Clicked 'Home' button and verify that landed to home page successfully");
	        
	        
}
}
