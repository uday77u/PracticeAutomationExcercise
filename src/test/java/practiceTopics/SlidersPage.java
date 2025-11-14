package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SlidersPage extends BasePage {

	public SlidersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "slideMe")
	public WebElement slider;
	
	public void holdAndDragSlider(int x,int y) {
		mouseHoldAndDragOffsetRelease(driver, slider, x, y);
	}
	
	@FindBy(id = "value")
	public WebElement valueText;
}
