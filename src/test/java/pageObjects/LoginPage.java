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
	WebElement loginAs;
	@FindBy(xpath = "//a[text()=' Delete Account']")
	WebElement Deletelogin;
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	WebElement DeleteAccount;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement ContinueAfterDelete;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement Logout;
	
	
	
//----------------------------------------------Methods-------------------------------------------------------------------		
public boolean msgLoginAs() {return loginAs.isDisplayed();}
public String msgLoginAsUserName() {return loginAs.getText();}
public void clickDeletelogin() {Deletelogin.click();}
public String msgDeleteAccount() {return DeleteAccount.getText();}	
public void clickContinueBtnAfterDelete() {ContinueAfterDelete.click();}	
public void clickLogout() {Logout.click();}	

}
