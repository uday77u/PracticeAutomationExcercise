package practiceTopics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalsPage extends BasePage{

	public ModalsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(id = "simpleModal")
	private WebElement simpleModalButton;

	@FindBy(xpath = "//div[contains(@id,'title')]")
	private WebElement SimplePopupTitle;
	
	@FindBy(css = "button[aria-label='Close']")
	private WebElement SimplePopupClose;
	
	@FindBy(xpath = "//div[@class='pum-content popmake-content']/p")
	private WebElement SimplePopupContent;		
	
	@FindBy(id = "formModal")
	private WebElement formModalButton;
	
	@FindBy(xpath = "//a[text()='']")
	private WebElement formGobacklButton;
	
	@FindBy(xpath = "//input[contains(@id,'name')]")
	private WebElement formName;
	
	@FindBy(xpath = "//input[contains(@id,'email')]")
	private WebElement formEmail;
	
	@FindBy(xpath = "//textarea[contains(@id,'message')]")
	private WebElement formTextAreaMessage;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement formSubmitButton;		
			
	@FindBy(id = "contact-form-success-header")
	private WebElement formSuccessMessage;
	
	//Methods
	public void clickSimpleModalButton() {
		((JavascriptExecutor) driver).executeScript(
			    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", simpleModalButton);
		simpleModalButton.click();
	}
	
	public String getSimplePopupTitle() {
		WaitForWebElementForVisible(driver, SimplePopupTitle);
		return SimplePopupTitle.getText();
	}
	
	public String getSimplePopupContent() {
		return SimplePopupContent.getText();
	}
	
	public void clickSimplePopupClose() {
		SimplePopupClose.click();
	}
	
	public void clickformModalButton() {
		formModalButton.click();
	}
	
	public void EnterFormEmail(String email) {
		formEmail.sendKeys(email);
	}
	
	public void EnterFormName(String name) {
		formName.sendKeys(name);
	}	
	
	public void EnterFormTextAreaMessage(String msg) {
		formTextAreaMessage.sendKeys(msg);
	}		
	
	public void clickformSubmitButton() {
		formSubmitButton.click();
	}
	
	
	
	
}
