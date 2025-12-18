package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordionsPage extends BasePage {

	public AccordionsPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//summary")
	private WebElement clickToSeeMoreAccordion;
	
	@FindBy(xpath = "//summary/..//p")
	private WebElement clickToSeeMoreAccordionText;	
	
	
	//Methods
	public void clickedClickToSeeMoreAccordion() {
		clickToSeeMoreAccordion.click();
	}
	
	public String getClickToSeeMoreAccordionText() {
		return clickToSeeMoreAccordionText.getText();
	}
	

}

