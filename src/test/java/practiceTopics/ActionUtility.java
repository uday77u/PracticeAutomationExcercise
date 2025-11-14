package practiceTopics;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtility {

	public void DropDownByVisibleText(WebDriver driver, WebElement webelement, String text) {
		Select sel=new Select(webelement);
		sel.selectByContainsVisibleText(text);
	}
	
	public void WaitForClickableOfWebElementAndClick(WebDriver driver, WebElement webElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();	
}
	public void WaitForWebElementForVisible(WebDriver driver, WebElement webElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(webElement));
}
	
	public void mouseClick(WebDriver driver, WebElement webelement) {
		Actions action=new Actions(driver);
		action.click(webelement).perform();;
	}
	public void mouseClickAndHold(WebDriver driver, WebElement webelement) {
		Actions action=new Actions(driver);
		action.clickAndHold(webelement).perform();
	}
	
	public void mouseMoveToElement(WebDriver driver, WebElement webelement,int x, int y) {
		Actions action=new Actions(driver);
		action.moveToElement(webelement,x,y).perform();
	}
	
	public void mouseHoldAndDragOffsetRelease(WebDriver driver, WebElement webelement,int x, int y) {
		Actions action=new Actions(driver);
		action.clickAndHold(webelement).moveByOffset(x, y).release(webelement).perform();
	}
	public void ScrollToViewWebElement(WebDriver driver, WebElement webElement) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}
}
