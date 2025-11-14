package practiceTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarsPage extends BasePage{

	public CalendarsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(css = "	input[data-format='yy-mm-dd']\r\n")
	private WebElement DateInput;
	
	@FindBy(xpath = "//button[text()='Submit' and @type='submit']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//div[text()='Select or enter a date:']/../div[2]")
	private WebElement enteredDate;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Year')]")
	private WebElement YearSelector;

	@FindBy(xpath = "//button[contains(@aria-label,'Month')]")
	private WebElement MonthSelector;
	
	@FindBy(xpath = "//button[contains(@class,'dp-next')]")
	private WebElement NextMonthNavigator;
	
	@FindBy(xpath = "//button[contains(@class,'dp-prev')]")
	private WebElement PrevMonthNavigator;
	
	@FindBy(xpath = "//button[contains(@class,'dp-year')]")
	private WebElement YearDrop;
	
	
	
	
	
	
	//methods
	public void EnterDateInput(String date) {
		DateInput.sendKeys(date);
	}
	
	public void clickSubmitButton() {
		SubmitButton.click();

	}
	
	public String getEnteredDate() {
		return enteredDate.getText();
	}
	
	public void clickYearSelector() {
		YearSelector.click();
	}
	
	public void clickMonthSelector() {
		MonthSelector.click();
	}

	public void clickNextMonthNavigator() {
		NextMonthNavigator.click();
	}

	public void clickPrevMonthNavigator() {
		PrevMonthNavigator.click();
	}
	
	public void EnterYear(String year) {
	WebElement	yr=driver.findElement(By.xpath("//button[contains(@class,'dp-year') and @data-year='"+year+"']"));
	try {
		yr.click();
	} catch (Exception e) {
		mouseClick(driver, yr);
	}

	}
	
	public void EnterMonth(String month) {
		WebElement	mnth=driver.findElement(By.xpath("//button[contains(@class,'dp-month') and text()='"+month+"']"));
		try {
			mnth.click();
		} catch (Exception e) {
			mouseClick(driver, mnth);
		}
	}
	
	public void clickDateInput() {
		DateInput.click();
	}

	public void EnterDay(String day) {
		WebElement	daySel=driver.findElement(By.xpath("//button[contains(@class,'dp-day') and text()='"+day+"']"));
		try {
			daySel.click();
		} catch (Exception e) {
			mouseClick(driver, daySel);
		}
	}
	
	
	

}
