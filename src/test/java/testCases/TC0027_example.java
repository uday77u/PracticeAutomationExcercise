package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC0027_example {
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement signupText;
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void RegisterExamp() throws InterruptedException {
	System.out.println("Browser is launched and maximized");
	
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	Actions action=new Actions(driver);
	WebElement loginBtn=driver.findElement(By.xpath("//span[text()='Login']"));
	action.moveToElement(loginBtn).perform();
	driver.findElement(By.xpath("//span[text()='Sign Up']")).click();
	Thread.sleep(3000);

}
	@AfterMethod
	public void teardown() {
		driver.quit();
		System.out.println("browser is closed");
	}
}
