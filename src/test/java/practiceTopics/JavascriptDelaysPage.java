package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavascriptDelaysPage extends BasePage {
	
	public JavascriptDelaysPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "start")
	public WebElement startButton;
	
	@FindBy(id = "delay")
	public WebElement delayText;
	
	
	
	public void clickStartButton(WebDriver driver) {
		try{
			ScrollToViewWebElement(driver,startButton);
			startButton.click();
		}
		catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, startButton);
		}
	}

}
