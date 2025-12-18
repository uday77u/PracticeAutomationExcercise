package practiceTopics;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class WebDriverUtility {

	public Logger logger;
    public WebDriver driver;

    // ***************************
    // Constructor
    // ***************************
    public WebDriverUtility(WebDriver driver) {
        this.driver = driver;
    }

    // ***************************
    // WAIT UTILITIES
    // ***************************

    // Explicit wait for visibility
    public WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Explicit wait for clickable
    public WebElement waitForClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Fluent Wait
    public WebElement fluentWait(By locator, int timeout, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait.until(driver -> driver.findElement(locator));
    }

    // ***************************
    // BASIC ACTIONS
    // ***************************
    public void click(By locator) {
        waitForClickable(locator, 10).click();
    }

    public void type(By locator, String text) {
        WebElement element = waitForVisibility(locator, 10);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisibility(locator, 10).getText();
    }

    // ***************************
    // DROPDOWNS (Select)
    // ***************************
    public void selectByVisibleText(By locator, String text) {
        WebElement element = waitForVisibility(locator, 10);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        new Select(waitForVisibility(locator, 10)).selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        new Select(waitForVisibility(locator, 10)).selectByIndex(index);
    }

    // ***************************
    // WINDOWS HANDLING
    // ***************************
    public void switchToWindow(String targetTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            driver.switchTo().window(win);
            if (driver.getTitle().equals(targetTitle)) {
                break;
            }
        }
    }

    // ***************************
    // FRAMES HANDLING
    // ***************************
    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // ***************************
    // ALERTS
    // ***************************
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    // ***************************
    // ACTIONS CLASS
    // ***************************
    public void mouseHover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    public void dragAndDrop(WebElement src, WebElement target) {
        new Actions(driver).dragAndDrop(src, target).perform();
    }

    // ***************************
    // JAVASCRIPT EXECUTOR
    // ***************************
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollByPixels(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    
}

