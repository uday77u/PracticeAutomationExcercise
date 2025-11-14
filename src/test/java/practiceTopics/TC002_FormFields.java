package practiceTopics;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC002_FormFields extends BaseTest {
	@Test
	public void FormFields() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		FormFieldsPage formFieldsPage = new FormFieldsPage(driver);
		
		Reporter.log("TC002_FormFields",true);
		homePage.clickFormFieldsLink(driver);
		Reporter.log("clicked on Form field link",true);
		
		formFieldsPage.EnterName("asfgghj");
		Reporter.log("Entered the name",true);
		
		formFieldsPage.EnterPassword("adsgfryr");
		Reporter.log("Entered the Password");
		
		formFieldsPage.clickCheckboxMilk();
		Reporter.log("clicked on checkbox milk",true);
		
		formFieldsPage.clickGreenRadioButton11();
		Reporter.log("clicked on GreenRadioButton",true);
		
		//ScrollToViewWebElement(driver, homePage.GreenRadioButton);
		formFieldsPage.selectAutomationDropDown("Yes");
		Reporter.log("selectAutomationDropDown",true);
		
		formFieldsPage.enterEmailInput("asdff@sasdd");
		Reporter.log("Entered Email",true);
		
		formFieldsPage.enterMessageInput("good");
		Reporter.log("Entered Message",true);
		
		formFieldsPage.clickSubmitButton();
		Reporter.log("clicked Submit Button",true);
		
		
	}
	

}
