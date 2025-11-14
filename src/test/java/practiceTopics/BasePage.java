package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends ActionUtility {
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	

}