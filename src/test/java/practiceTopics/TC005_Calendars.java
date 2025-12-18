package practiceTopics;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC005_Calendars extends BaseTest {
	@Test
public void Calendar() throws InterruptedException {
		
	try {
		String Date="2021-12-06";
		logger.debug("Started Logging");
		logger.info("starting TC005_Calendars-Calendar");
			
		HomePage homePage=new HomePage(driver);
		CalendarsPage calendarsPage=new CalendarsPage(driver);
		
		homePage.clickCalendarsLink();
		logger.info("Step 1: Clicked on the Calendar link");

		calendarsPage.EnterDateInput(Date);	
		logger.info("Step 2: Entered the date");
		Thread.sleep(3000);
		
		calendarsPage.clickSubmitButton();
		logger.info("Step 3: clicked on submit");
		Thread.sleep(3000);
		
		assertEquals(calendarsPage.getEnteredDate(), Date, "Mis-match in Date entered" ); 
		logger.info("Step 4: date entered is matched: "+Date);
		Thread.sleep(3000);

		logger.debug("Application logging ends");
		logger.info("Finished *** TC005_Calendars-Calendar ***");
		
		
		
		
		
		
		
		
		
			
		} catch (Exception e) {
			logger.error("Exception (waitForLiftOffText):"+e.getMessage());
			throw e;
		}
		catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
		}
		
	
	
	
}
	@Test
	public void calendar2() throws InterruptedException{
try {
	String year="2021",month="February",day="1",calDate=year+"-02-0"+day;
	
	logger.debug("Started Logging");
	logger.info("starting TC005_Calendars-Calendar2");
	
	HomePage homePage=new HomePage(driver);
	CalendarsPage calendarsPage=new CalendarsPage(driver);
	
	System.out.println("TC005_Calendars2");
	
	homePage.clickCalendarsLink();
	logger.info("Step 1: Clicked on the Calendar link");
	
	calendarsPage.clickDateInput();
	logger.info("Step 2: Clicked on the DateInput ");
	Thread.sleep(3000);
	
	calendarsPage.clickYearSelector();
	logger.info("Step 3: Clicked on the Year");
	Thread.sleep(3000);
	
	calendarsPage.EnterYear(year);
	logger.info("Step 4: Entered year");
	Thread.sleep(3000);
	
	calendarsPage.clickMonthSelector();
	logger.info("Step 4: Clicked on the month");
	
	calendarsPage.EnterMonth(month);
	logger.info("Step 5: Entered month");
	Thread.sleep(3000);
	
	calendarsPage.EnterDay(day);
	logger.info("Step 6: Entered day");
	Thread.sleep(3000);
	
	calendarsPage.clickSubmitButton();
	logger.info("Step 7: clicked on submit");
	Thread.sleep(3000);
	
	assertEquals(calendarsPage.getEnteredDate(), calDate, "Mis-match in Date entered" ); 
	logger.info("Step 8:Verified date entered is matched: "+calDate);
	Thread.sleep(3000);
	
	logger.debug("Application logging ends");
	logger.info("Finished ***  TC005_Calendars-Calendar2 ***");
			
		} catch (Exception e) {
			logger.error("Exception (waitForLiftOffText):"+e.getMessage());
			throw e;
		}
		catch (AssertionError ae) {
			logger.error("AssertionError (waitForLiftOffText):"+ae.getMessage());
			throw ae;
		}
		
	}
}
