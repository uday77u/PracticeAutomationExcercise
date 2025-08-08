package BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public String baseURL="http://automationexercise.com";
	public String userName="User1";
	public String userEmail="User1New@gmail.com";
	public String password="User1New@gmail.com";
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		Reporter.log("Browser is Launched", false);
		
		driver.manage().window().maximize();
		Reporter.log("Browser Window is maximized ", false);
		
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

}
	//utility method to verify the current page URL contains segment
	public boolean isCurrentUrlWithSegment(String segment) {
		return driver.getCurrentUrl().contains(segment);
	}
	
	//utility method to verify the current page Title contains segment
	public boolean isCurrentTitleWithSegment(String segment) {
		return driver.getTitle().contains(segment);
	}
	
	//utility method to explicit wait for web element to be click able
	public void waitForWebElementToBeClickable(WebElement webElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	//utility method to drag the element to view
	public void dragToViewWebElement(WebDriver driver,WebElement webelement) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView", webelement);
	}

}
