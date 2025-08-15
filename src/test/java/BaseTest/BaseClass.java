package BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import utilities.ReadConfig;

public class BaseClass {
	//read configuration values
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getBaseURL();
	public String userName=readConfig.getUsername();
	public String userEmail="User1New@gmail.com";
	public String password=readConfig.getPassword();
	
	public static WebDriver driver;
	public Logger logger;
	@BeforeClass
	@Parameters({"Browser"})
	public void setup(String Br)
	{
		logger=LogManager.getLogger(this.getClass());
		
		if (Br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("Chrome browser is Launched.", true);
		}
		else if (Br.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Reporter.log("Firefox browser is Launched.", true);
		}
		else if(Br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("Edge Browser is Launched.", true);
		}
		else
		{
			Reporter.log("Enter Proper Browser name.", true);return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().getImplicitWaitTimeout();
		Reporter.log("Browser Window is maximized.", true);
		
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Browser is closed.\n",true);
	}
	
	
public String getScreenshot(String tname) throws IOException {
		
		if (driver == null)
			System.out.println("driver is null");
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		//source.renameTo(targetFile);
		FileUtils.copyFile(source, targetFile);
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

	//utility wait for visibility of an element
		public void waitForVisibilityOfWebelement(WebElement webelement) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(webelement));
		}
}
