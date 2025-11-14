package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowOperationsPage extends BasePage{

	public WindowOperationsPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	@FindBy(xpath = ("//button[@onclick='newTab()' ]"))
	private WebElement newTabBtn;
	
	@FindBy(xpath = "//button[contains(@onclick,'newWindowSelf')]")
	private WebElement ReplaceWindowBtn;
	
	@FindBy(xpath = "//button[contains(@onclick,'newWindow()')]")
	private WebElement NewWindowBtn;
	
	
	
	
	//Methods
	public void clickNewTabBtn() {
		newTabBtn.click();
	}
	
	public void clickReplaceWindowBtn() {
		ReplaceWindowBtn.click();
	}
	
	public void clickNewWindowBtn() {
		NewWindowBtn.click();
	}
}
