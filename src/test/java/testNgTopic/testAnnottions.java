package testNgTopic;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class testAnnottions {
	@Test()
	void openApp()
	{
		System.out.println("open the applicatyion");
		assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"openApp"})
	void loginApp() 
	{
		System.out.println("login the app");
	}
	
	@Test(dependsOnMethods = {"openApp","loginApp"})
	void closeApp()
	{
		System.out.println("close the app");
	}
}
