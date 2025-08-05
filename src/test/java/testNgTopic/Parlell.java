package testNgTopic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Parlell {
	WebDriver driver;
	//@Parameter("")
	void setup(String br)
	{
		
		switch (br) {
		case "chrome":System.setProperty("webdriver.chrome.drive","./software/chromedriver.exe");
		driver=new ChromeDriver();
			break;

		default:
			break;
		}
		
		System.setProperty("webdriver.chrome.drive","./software/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	void fb() throws InterruptedException 
	{
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
	}
 void tearDown()
 {
	 driver.quit();
 }
}
