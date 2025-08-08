/*
 * Test Case 10: Verify Subscription in home page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
 */
package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;

public class TC010_VerifySubscriptionInHomePage extends BaseClass{

	@Test(description = "Verify Subscription In Home Page")
    public void VerifySubscriptionInHomePage() throws InterruptedException {
        HomePage home = new HomePage(driver);
        
        // Step 1-3: Navigate to home page and verify
        driver.get(baseURL);
        Reporter.log("Navigating to baseURL: " + baseURL, false);
        assertEquals(driver.getTitle(), "Automation Exercise", "Home page title mismatch");
        Reporter.log("Home Page is displayed successfully", true);
        
        //step 4-5: Scroll down to footer, Verify text 'SUBSCRIPTION'
        JavascriptExecutor js=(JavascriptExecutor) driver;
       
        /*----Scroll down to footer alternate way------
        Point pt = home.LocatorHomePageFooter().getLocation();
        int x=pt.getX();
        int y=pt.getY();
        System.out.println("x:"+x+"  y:"+y);
        js.executeScript("window.scrollBy(0,8350)"); */
        
        js.executeScript("arguments[0].scrollIntoView();", home.LocatorHomePageFooter());
        Thread.sleep(3000);
        assertEquals(home.msgSubscription(), true,"Subscription text is not exist");
        Reporter.log("Scroll down to footer, Verify text 'SUBSCRIPTION'",true);
        
        //step 6: Enter email address in input and click arrow button
        home.setSusbscribeEmailname(userEmail);
        home.clickbtnSubscribeArrow();
        Reporter.log("Entered email address in input and click arrow button",true);

        //step 7: Verify success message 'You have been successfully subscribed!' is visible
        assertTrue(home.getmsgAlertSentMailExist(),"Success message is not visible.");
        assertEquals(home.getMsgAlertSentMail(), "You have been successfully subscribed!","Mis-match in alert Message");
        Reporter.log("Verify success message 'You have been successfully subscribed!' is visible",true);
        
        
}
}