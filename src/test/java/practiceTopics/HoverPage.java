package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoverPage extends BasePage{

	public HoverPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locators
	@FindBy(id = "mouse_over")
	private WebElement mouseOverTab;
	
	//methods
	public void HoverMouseOverTab() {
		Actions act=new Actions(driver);
		act.moveToElement(mouseOverTab).perform();
	}

	public String getMouseOverTabTxt() {
		return mouseOverTab.getText();
		
	}
}
