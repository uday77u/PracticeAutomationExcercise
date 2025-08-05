package testNgTopic;

import org.testng.annotations.Test;

public class LoginTests {
	@Test(groups = {"regression"})
	void loginByEmail()
	{
		System.out.println("this is loged in in by Email");
	}
	
	@Test(groups = {"regression"})
	void loginByFb()
	{
		System.out.println("this is loged in in by FB");
	}
	
	@Test(groups = {"regression"})
	void loginByInsta()
	{
		System.out.println("this is loged in in by Insta");
	}

}
