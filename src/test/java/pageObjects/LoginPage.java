package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
//-------------------------------------------------Locators-----------------------------------------------------------
	
	@FindBy(xpath = "//a[text()=' Logged in as ']")
	private WebElement loginAs;
	@FindBy(xpath = "//a[text()=' Delete Account']")
	private WebElement Deletelogin;
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement DeleteAccount;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement ContinueAfterDelete;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement Logout;
	
	
	
//----------------------------------------------Methods-------------------------------------------------------------------		
public boolean msgLoginAs() {return loginAs.isDisplayed();}
public String msgLoginAsUserName() {return loginAs.getText();}
public void clickDeletelogin() {Deletelogin.click();}
public String msgDeleteAccount() {return DeleteAccount.getText();}	
public void clickContinueBtnAfterDelete() {ContinueAfterDelete.click();}	
public void clickLogout() {Logout.click();}	

}
