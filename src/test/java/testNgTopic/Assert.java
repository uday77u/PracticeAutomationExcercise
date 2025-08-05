package testNgTopic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {

	@Test(priority = 1)
	void homePage()
	{
		String expTitle="Home page";
		String actTitle="Login page";
		/*if(actTitle==expTitle)
		{
			System.out.println("test passed");
			assertTrue(true);
		}
		else
		{
			System.out.println("test is failed");
			assertTrue(false);
		}
		*/
		//assertEquals(expTitle, actTitle,"mis-match title");
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(expTitle, actTitle,"mis match titles:-");
		System.out.println("after assert statement");
		sa.assertAll();
		System.out.println("after assert all statement");
	}
	
	@Test(priority = 2)
	void MyApp() 
	{
		System.out.println("login is tested");
	}

	@Test(priority = 3)
	void purchase() 
	{
		System.out.println("purchase the product");
	}
}
