package practiceTopics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		System.out.println("Browser is opened");
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Entered URL--https://practice-automation.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			driver.quit();
		System.out.println("Browser is closed\n");
	}
	
}
