package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdsPage extends BasePage{

	public AdsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locators
	@FindBy(xpath = "(//button[contains(@class,'close')])[2]")
	private WebElement CloseBtn;
	
	
	
	
	//Methods
	public void clickCloseBtn() {
		CloseBtn.click();
	}
	
	

}
