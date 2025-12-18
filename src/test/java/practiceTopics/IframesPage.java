package practiceTopics;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframesPage extends BasePage{

	public IframesPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//iframe[@name='top-iframe']")
	private WebElement topIframe;
	
	@FindBy(xpath = "//a[text()='Get started']")
	private WebElement topFrameGetStartedBtn;

	@FindBy(xpath = "//iframe[@name='bottom-iframe']")
	private WebElement bottomIframe;
	
	@FindBy(xpath = "//span[text()='Projects']")
	private WebElement bottomIframeProjectsBtn;
	
	
	
	//Methods
	
	public void clickGetStartedBtn() {
		//switch to topFrame
		driver.switchTo().frame(topIframe);
		
		//wait for element click able
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(topFrameGetStartedBtn));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", topFrameGetStartedBtn);
		topFrameGetStartedBtn.click();
		
		//switch to parent frame
		driver.switchTo().defaultContent();
	}
	
	public void clickProjectsBtn() {
		//switch to bottom frame
		driver.switchTo().frame(bottomIframe);
		
		//wait for element click able and click
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(bottomIframeProjectsBtn));
		
		//scroll to the element:bottomIframeProjectsBtn
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", bottomIframeProjectsBtn);		
		bottomIframeProjectsBtn.click();
		
		//switch to parent frame
		driver.switchTo().defaultContent();
	}
	

}
