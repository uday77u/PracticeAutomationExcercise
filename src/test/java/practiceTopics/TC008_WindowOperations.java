package practiceTopics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC008_WindowOperations extends BaseTest {

	@Test
	public void windowOperations() throws InterruptedException {
		HomePage homePage= new HomePage(driver);
		WindowOperationsPage windowOperationsPage=new WindowOperationsPage(driver); 
		
		homePage.clickWindowOperationsLink();
		System.out.println("clicked on the WindowOperationsLink");
		
		String DefaultWindow = driver.getWindowHandle();
		System.out.println("--Default tab window handle: "+DefaultWindow);
		
		windowOperationsPage.clickNewTabBtn();
		System.out.print("Clicked on NewTabBtn");
		Thread.sleep(2000);
		
		String NewTabWindowHandle = driver.getWindowHandle();
		System.out.println("--New tab window handle: "+NewTabWindowHandle);
		
		
		//assertTrue(driver.getCurrentUrl().contains("automatenow"),"New tab is not opened,actual:"+driver.getCurrentUrl());
		driver.switchTo().window(DefaultWindow);
		System.out.println("Switch to the default tab"+DefaultWindow);
		
		windowOperationsPage.clickNewWindowBtn();
		System.out.println("clicked on NewWindowBtn");
		
		String NewWindowHandle = driver.getWindowHandle();
		System.out.println("--New window handle: "+NewWindowHandle);
		
		driver.switchTo().window(DefaultWindow);
		System.out.println("Switch to the default tab");
		
		windowOperationsPage.clickReplaceWindowBtn();
		System.out.println("clicked on ReplaceWindowBtn");
		Thread.sleep(5000);
		
		driver.switchTo().newWindow(WindowType.WINDOW.TAB);
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		System.out.println("New tab is opened:url--"+driver.getCurrentUrl());
		
		driver.switchTo().newWindow(WindowType.WINDOW.WINDOW);
		Thread.sleep(5000);
		driver.get("https://www.amazon.in/");
		System.out.println("New window is opened:url--"+driver.getCurrentUrl());
		
		Set<String> winIds = driver.getWindowHandles();
		System.out.println(winIds);
		for(String id:winIds) {
			driver.switchTo().window(id);
			System.out.println(id+" is openened"+" url:"+driver.getCurrentUrl());
		}

	}
}
