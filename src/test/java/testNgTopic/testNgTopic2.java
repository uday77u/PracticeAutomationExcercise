package testNgTopic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @BeforeMethod
 * @AfterMethod
 * 
 * 
 * @BeforeClass
 * @AfterClass
 * 
 * 
 * @BeforeTest
 * @AfterTest
 */
public class testNgTopic2 {
	@BeforeClass
	//@BeforeMethod
	void setup()
	{
		System.out.println("1.Browser setup");
	}
	
	@Test()
	void MyApp() 
	{
		System.out.println("login is tested");
	}

	@Test
	void purchase() 
	{
		System.out.println("purchase the product");
	}
	@AfterClass
	//@AfterMethod
	void tearDown() 
	{
		System.out.println("2.close the App");
	}
}
