package practiceTopics;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.RetryAnalyzer;

public class TC002_FormFields extends BaseTest {
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void FormFields() throws InterruptedException {
		try {
			HomePage homePage = new HomePage(driver);
			FormFieldsPage formFieldsPage = new FormFieldsPage(driver);
			
			logger.info("TC002_FormFields",true);
			homePage.clickFormFieldsLink(driver);
			logger.info("Step 1: clicked on Form field link",true);
			
			formFieldsPage.EnterName("asfgghj");
			logger.info("Step 2: Entered the name",true);
			
			formFieldsPage.EnterPassword("adsgfryr");
			logger.info("Step 3: Entered the Password");
			
			formFieldsPage.clickCheckboxMilk();
			logger.info("Step 4: clicked on checkbox milk",true);
			
			formFieldsPage.clickGreenRadioButton11();
			logger.info("Step 5: clicked on GreenRadioButton",true);
			
			//ScrollToViewWebElement(driver, homePage.GreenRadioButton);
			formFieldsPage.selectAutomationDropDown("Yes");
			logger.info("Step 6: selectAutomationDropDown",true);
			
			formFieldsPage.enterEmailInput("asdff@sasdd");
			logger.info("Step 7: Entered Email",true);
			
			formFieldsPage.enterMessageInput("good");
			logger.info("Step 8: Entered Message",true);
			
			formFieldsPage.clickSubmitButton();
			logger.info("Step 9: clicked Submit Button",true);
			
		} catch (Exception e) {
			logger.error("Exception:"+e.getMessage());
			throw e;
		} catch (AssertionError ae) {
			logger.error("AssertionError:"+ae.getMessage());
			throw ae;
		}
		
		
		
	}
	

}
