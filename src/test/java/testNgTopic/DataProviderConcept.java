package testNgTopic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {

	@Test(dataProvider = "dp")
	void dispNamePwd(String name, String pwd) 
	{
		
		System.out.println("Name:"+name+"\tpwd:"+pwd);
	}
	
	@DataProvider(name="dp")
	String[][] LoginData(){
		String data[][]= {{"name1","pwd1"},
				          {"name2","pwd2"}};
				                           
		return data;
	}
	
}
