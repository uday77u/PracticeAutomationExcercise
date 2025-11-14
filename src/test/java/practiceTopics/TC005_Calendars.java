package practiceTopics;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC005_Calendars extends BaseTest {
	@Test
public void Calendar() throws InterruptedException {
	HomePage homePage=new HomePage(driver);
	CalendarsPage calendarsPage=new CalendarsPage(driver);
	
	System.out.println("TC005_Calendars1");
	homePage.clickCalendarsLink();
	Reporter.log("Clicked on the Calendar link",true);
	
	String Date="2021-12-06";
	calendarsPage.EnterDateInput(Date);	
	Reporter.log("Entered the date",true);
	Thread.sleep(3000);
	
	calendarsPage.clickSubmitButton();
	Reporter.log("clicked on submit",true);
	Thread.sleep(3000);
	
	assertEquals(calendarsPage.getEnteredDate(), Date, "Mis-match in Date entered" ); 
	Reporter.log("date entered is matched: "+Date,true);
	Thread.sleep(3000);


	
	
	
}
	@Test
	public void calendar2() throws InterruptedException{
		HomePage homePage=new HomePage(driver);
		CalendarsPage calendarsPage=new CalendarsPage(driver);
		System.out.println("TC005_Calendars2");
		String year="2021",month="February",day="1",calDate=year+"-02-0"+day;
		homePage.clickCalendarsLink();
		Reporter.log("Clicked on the Calendar link",true);
		
		calendarsPage.clickDateInput();
		Reporter.log("Clicked on the DateInput ",true);
		Thread.sleep(3000);
		
		calendarsPage.clickYearSelector();
		Reporter.log("Clicked on the Year",true);
		Thread.sleep(3000);
		
		calendarsPage.EnterYear(year);
		Reporter.log("Entered year",true);
		Thread.sleep(3000);
		
		calendarsPage.clickMonthSelector();
		Reporter.log("Clicked on the month",true);
		
		calendarsPage.EnterMonth(month);
		Reporter.log("Entered month",true);
		Thread.sleep(3000);
		
		calendarsPage.EnterDay(day);
		Reporter.log("Entered day",true);
		Thread.sleep(3000);
		
		calendarsPage.clickSubmitButton();
		Reporter.log("clicked on submit",true);
		Thread.sleep(3000);
		
		assertEquals(calendarsPage.getEnteredDate(), calDate, "Mis-match in Date entered" ); 
		Reporter.log("date entered is matched: "+calDate,true);
		Thread.sleep(3000);
	}
}
