package practiceTopics;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//Locators

	@FindBy(xpath="//a[text()='Form Fields']")
	public WebElement FormFieldsLink;
	
	@FindBy(xpath="//a[text()='JavaScript Delays']")
	public WebElement JavaScriptDelaysLink;

	@FindBy(xpath = "//a[text()='Popups']")
	private WebElement PopupsLink;
	
	@FindBy(xpath = "//a[text()='Sliders']")
	private WebElement SlidersLink;
	
	@FindBy(xpath = "//a[text()='Calendars']")
	private WebElement CalendarsLink;
	
	@FindBy(xpath = "//a[text()='Modals']")
	private WebElement ModalsLink;
	
	@FindBy(xpath = "//a[text()='Tables']")
	private WebElement tableLink; 
	
	@FindBy(xpath = "//a[text()='Window Operations']")
	private WebElement WindowOperationsLink;
	
	@FindBy(xpath = "//a[text()='Hover']")
	private WebElement HoverLink;
	
	@FindBy(xpath = "//a[text()='Ads']")
	private WebElement AdsLink;
	
	@FindBy(xpath = "//a[text()='Gestures']")
	private WebElement GesturesLink;
	
	@FindBy(xpath = "//a[text()='File Download']")
	private WebElement FileDownloadLink;
	
	@FindBy(xpath = "//a[text()='Click Events']")
	private WebElement ClickEventsLink;
	
	@FindBy(xpath = "//a[text()='Spinners']")
	private WebElement SpinnersLink;

	@FindBy(xpath = "//a[text()='Iframes']")
	private WebElement IframesLink;
	
	@FindBy(xpath = "//a[text()='Broken Images']")
	private WebElement BrokenImagesLink;

	@FindBy(xpath = "//a[text()='Broken Links']")
	private WebElement BrokenLinksLink;
	
	@FindBy(xpath = "//a[text()='Accordions']")
	private WebElement AccordionsLink;
	
//Methods

	public void clickFormFieldsLink(WebDriver driver) {
		try{
			FormFieldsLink.click();
		}
		catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, FormFieldsLink);
		}
	}
	
	public void clickJavaScriptDelaysLink(WebDriver driver) {
		try{
			JavaScriptDelaysLink.click();
		}
		catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, JavaScriptDelaysLink);
		}
	}
	
	public void clickPopupsLink() {
		try {
			PopupsLink.click();
		} catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, PopupsLink);
		}	
	}
	
	public void clickSlidersLink() {
		try {
			//ScrollToViewWebElement(driver, SlidersLink);
			//SlidersLink.click();
			
			mouseClick(driver, SlidersLink);

			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript(
					    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", SlidersLink);	
			WaitForClickableOfWebElementAndClick(driver, SlidersLink);
		}
		}

	public void clickCalendarsLink() {
		try {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", SlidersLink);
			CalendarsLink.click();
		} catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, CalendarsLink);
		}	
	}

	public void clickModalsLink() {
		try {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ModalsLink);
			mouseClick(driver, ModalsLink);
		} catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, ModalsLink);
		}	
	}
	
	public void clickTablesLink() {
		try {

			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", tableLink);
			tableLink.click();
		} catch (Exception e) {
			WaitForClickableOfWebElementAndClick(driver, tableLink);
			
		}
		
	}
	
	public void clickWindowOperationsLink() {
		try {
			ScrollToViewWebElement(driver, WindowOperationsLink);
			WindowOperationsLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", WindowOperationsLink);
			WaitForClickableOfWebElementAndClick(driver, WindowOperationsLink);
		}

	}
	
	public void clickHoverLink() {
		try {
			ScrollToViewWebElement(driver, HoverLink);
			HoverLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", HoverLink);
			WaitForClickableOfWebElementAndClick(driver, HoverLink);
		}

	}
	
	public void clickAdsLink() {
		try {
			ScrollToViewWebElement(driver, AdsLink);
			AdsLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", AdsLink);
			WaitForClickableOfWebElementAndClick(driver, AdsLink);
		}

	}
	
	public void clickGesturesLink() {
		try {
			GesturesLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", GesturesLink);
			WaitForClickableOfWebElementAndClick(driver, GesturesLink);
		}

	}
	
	public void clickFileDownloadLink() {
		try {
			FileDownloadLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", FileDownloadLink);
			WaitForClickableOfWebElementAndClick(driver, FileDownloadLink);
		}

	}
	
	public void clickClickEventsLink() {
		try {
			ClickEventsLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ClickEventsLink);
			WaitForClickableOfWebElementAndClick(driver, ClickEventsLink);
		}

	}
	
	public void clickSpinnersLink() {
		try {
			SpinnersLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", SpinnersLink);
			WaitForClickableOfWebElementAndClick(driver, SpinnersLink);
		}

	}

	public void clickIframesLink() {
		try {
			IframesLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", IframesLink);
			WaitForClickableOfWebElementAndClick(driver, IframesLink);
		}

	}
	
	public void clickBrokenImagesLink() {
		try {
			BrokenImagesLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", BrokenImagesLink);
			WaitForClickableOfWebElementAndClick(driver, BrokenImagesLink);
		}

	}
	
	public void clickBrokenLinksLink() {
		try {
			BrokenImagesLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", BrokenLinksLink);
			WaitForClickableOfWebElementAndClick(driver, BrokenLinksLink);
		}

	}
	
	public void clickAccordionsLink() {
		try {
			BrokenImagesLink.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript(
				    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", AccordionsLink);
			WaitForClickableOfWebElementAndClick(driver, AccordionsLink);
		}

	}
	
	
}
