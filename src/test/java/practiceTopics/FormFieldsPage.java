package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormFieldsPage extends BasePage{

	public FormFieldsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "name-input")
	public WebElement NameInput;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement PasswordInput;
	
	
	@FindBy(css ="input[value='Green']")
	public WebElement GreenRadioButton;
	
	@FindBy(css ="select[name='automation']")
	public WebElement AutomationDropDown;
	
	@FindBy(css ="input[value='Milk']")
	public WebElement checkboxMilk;

	@FindBy(id = "email")
	public WebElement emailInput;
	
	@FindBy(name = "message")
	public WebElement messageInput;
	
	@FindBy(id = "submit-btn")
	public WebElement submitButton;
	
	

	public void EnterName(String name) {
		NameInput.sendKeys(name);
	}
	
	public void EnterPassword(String psw) {
		PasswordInput.sendKeys(psw);
	}
	
	public void clickCheckboxMilk() {
		checkboxMilk.click();
	}
	public void clickGreenRadioButton() {
		try{
			GreenRadioButton.click();
		}
		catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, GreenRadioButton);
		}
	}

	public void selectAutomationDropDown(String Name) {
		DropDownByVisibleText(driver, AutomationDropDown, Name);
	}
	public void clickGreenRadioButton11() {
	    try {
	        ScrollToViewWebElement(driver, GreenRadioButton);
	        GreenRadioButton.click();
	    } catch (Exception e) {
	        ScrollToViewWebElement(driver, GreenRadioButton);
	        WaitForClickableOfWebElementAndClick(driver, GreenRadioButton);
	    }
	}
	public void enterEmailInput(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterMessageInput(String msg) {
		messageInput.sendKeys(msg);
	}
	public void clickSubmitButton() {
		try{
			ScrollToViewWebElement(driver, submitButton);
			submitButton.click();
		}
		catch (Exception e) {
			ScrollToViewWebElement(driver, submitButton);
			WaitForClickableOfWebElementAndClick(driver, submitButton);
		}
		
	
	}
}
