package practiceTopics;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.RetryAnalyzer;

import utilities.RetryListener;

@Listeners(RetryListener.class)
public class BaseTest {
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeMethod
	public void setup() {
		logger=LogManager.getLogger(getClass());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		driver=new ChromeDriver(options);
		logger.info("\tBrowser is opened");
		
		driver.manage().window().maximize();
		logger.info("Browser is launch");
		
		driver.get("https://practice-automation.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Navigated to URL: https://practice-automation.com/");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
		logger.info("Browser is closed\n");
	}
	
}
