package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import utilities.DataProviders;
import utilities.ExcellUtilityNew;

public class TC003b_LoginUserIncorrectEmailAndPassword_DataProvider extends BaseClass {
	 @Test(dataProvider = "InvalidLoginData", dataProviderClass = DataProviders.class,
	          description = "Verify Login User with incorrect email and password (DDT)")
	    public void verifyLoginUserIncorrectEmailAndPasswordUsingDataProvider(String email, String pwd, String expected) throws InterruptedException {

	        boolean status = false;

	        try {

	            logger.debug("logging started");
	            logger.info("starting TC003_LoginUserIncorrectEmailAndPassword");

	            HomePage home = new HomePage(driver);

	            // STEP 1-3
	            logger.info("STEP 1 & 2: Launching and Navigating to URL");
	            driver.get(BASE_URL);

	            // STEP 4-5
	            logger.info("STEP 4: Click on 'Signup / Login' button");
	            home.clickSignupOrLoginLink();

	            logger.info("STEP 5: Verify 'Login to your account' is visible");
	            assertTrue(home.msgLoginToAccountVisible(), "'Login to your account' is not visible");

	            // STEP 6
	            logger.info("STEP 6: Enter incorrect email and password from Excel");
	            home.setEmailAddressLogin(email);
	            home.setPassword(pwd);

	            // STEP 7
	            logger.info("STEP 7: Click Login");
	            home.clickLogin();

	            assertEquals(driver.getTitle(),"Automation Exercise - Signup / Login",
	                    "Login page title is mismatched");

	            Thread.sleep(2000);

	            // STEP 8
	            logger.info("STEP 8: Verify error message is displayed");
	            assertTrue(home.errorMsgExist(), "Error Message is NOT displayed");

	            status = true; // if all assertions pass

	        }
	        /*catch (Exception | AssertionError e) {
	            logger.error("❌ Test Failed: " + e.getMessage());
	            status = false;
	        }*/

	        catch (AssertionError ae) {
		        logger.error("❌ Assertion failed in verifyLoginUserIncorrectEmailAndPasswordFlow: " + ae.getMessage(), ae);
		        throw ae; // rethrow so TestNG marks test as failed
		    } catch (Exception e) {
		        logger.error("❌ Unexpected exception in verifyLoginUserIncorrectEmailAndPasswordFlow: " + e.getMessage(), e);
		        throw e; // rethrow so TestNG marks test as failed
		    }
	        finally {
	            writeResultToExcel(email, status ? "PASS" : "FAIL");
		        logger.info("**** Finished TC003 with data: " + email + " *****");
	        }


	    }


	    // ✅ Write back to Excel
	    public void writeResultToExcel(String email, String result) {

	        try {
	            ExcellUtilityNew excel = new ExcellUtilityNew("./Data/UserData.xlsx");

	            int rows = excel.getRowCount("TestData");

	            for (int i = 1; i < rows; i++) {
	                if (excel.getCellData("TestData", i, 0).equalsIgnoreCase(email)) {
	                    excel.setCellData("TestData", i, 3, result);
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
}

}
