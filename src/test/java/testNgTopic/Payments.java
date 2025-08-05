package testNgTopic;

import org.testng.annotations.Test;

public class Payments {
	@Test(groups = {"sanity","regression","(functional)"})
	void paymentInDollar()
	{
		System.out.println("this is payed in dollar");
	}
	
	@Test(groups = {"sanity","regression","(functional)"})
	void paymentInRupee()
	{
		System.out.println("this is payed in rupees");
	}

}
