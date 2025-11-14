package practiceTopics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PopupsPage extends BasePage {
	public PopupsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//b[text()='Alert Popup']")
	private WebElement AlertPopup;
	
	@FindBy(xpath = "//b[text()='Confirm Popup']")
	private WebElement ConfirmPopup;
	
	@FindBy(xpath = "//b[text()='Prompt Popup']")
	private WebElement PromptPopup;
	
	@FindBy(id = "myTooltip")
	public WebElement myTooltip;
	
	public void clickAlertPopup() {
		AlertPopup.click();
	}
	
	public void clickConfirmPopup() {  
		ConfirmPopup.click();
	}
	
	public void clickPromptPopup() {
			PromptPopup.click();
	}
	
	public void clickmyTooltip() {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", myTooltip);
			Actions actions = new Actions(driver);
		    actions.click(myTooltip).perform();
		} catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, myTooltip);
		}
		
	}
	public String getTooltipMessage() {
	    // Try "title" attribute first
	    String tooltipText = myTooltip.getAttribute("title");

	    // If not found, try text content
	    if (tooltipText == null || tooltipText.isEmpty()) {
	        tooltipText = myTooltip.getText();
	    }

	    return tooltipText;
	}
	
	
	
	
	
}
