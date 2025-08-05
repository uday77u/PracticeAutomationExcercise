package testNgTopic;

import org.testng.annotations.Test;

public class SignupTests {
	@Test(groups = {"sanity"})
	void signupByEmail()
	{
		System.out.println("this is signed in by Email");
	}
	
	@Test(groups = {"sanity"})
	void signupByFb()
	{
		System.out.println("this is signed in by FB");
	}
	
	@Test(groups = {"sanity"})
	void signupByInsta()
	{
		System.out.println("this is signed in by Insta");
	}

}
