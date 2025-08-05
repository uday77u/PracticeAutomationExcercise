package com.automationExcercise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//--------------------------Locators-------------------------------------------------------

	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement msgEnterAccInfo;
	
	@FindBy(xpath="//input[@id='id_gender1']") 
	private WebElement mr;

	@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement mrs;

	@FindBy(xpath="//input[@id='name']")  
	private WebElement name;

	@FindBy(xpath="//input[@id='password']") 
	private WebElement password;
	
@FindBy(xpath="//select[@id='days']")
private WebElement day;

@FindBy(xpath="//select[@id='months']") 
private WebElement month;

@FindBy(xpath="//select[@id='years']") 
private WebElement year;

@FindBy(xpath="//input[@id='newsletter']")
private WebElement signUpForOurNewsletter;

@FindBy(xpath="//input[@id='optin']") 
private WebElement receiveSpecialOffersFromOu;

@FindBy(xpath="//b[normalize-space()='Address Information']")
private WebElement addressInformation;

@FindBy(xpath="//input[@id='first_name']") 
private WebElement firstName;

@FindBy(xpath="//input[@id='last_name']") 
@CacheLookup private WebElement lastName;

@FindBy(xpath="//input[@id='company']")
@CacheLookup private WebElement company;

@FindBy(xpath="//input[@id='address1']")
private WebElement address;


@FindBy(xpath="//input[@id='address2']")
@CacheLookup private WebElement address2;


@FindBy(xpath="//select[@id='country']")
@CacheLookup private WebElement country;


@FindBy(xpath="//input[@id='state']")
@CacheLookup private WebElement state;

@FindBy(xpath="//input[@id='city']") @CacheLookup
private WebElement city;

@FindBy(xpath="//input[@id='zipcode']") @CacheLookup
private WebElement zipcode;

@FindBy(xpath="//input[@id='mobile_number']") @CacheLookup
private WebElement mobileNumber;

@FindBy(xpath="//button[normalize-space()='Create Account']") 
@CacheLookup private WebElement createAccount;
	


@FindBy(xpath="//b[normalize-space()='Account Created!']") 
@CacheLookup private WebElement accountCreated;

//@FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]") @CacheLookup private WebElement congratulationsYourNewAcco;
//@FindBy(xpath="//p[contains(text(),'You can now take advantage of member privileges to')]") @CacheLookup private WebElement youCanNowTakeAdvantageOf;

@FindBy(xpath="//a[normalize-space()='Continue']") 
@CacheLookup private WebElement Continue;

@FindBy(xpath="//li[10]//a[1]")
@CacheLookup private WebElement loggedInAs;


@FindBy(xpath="//a[normalize-space()='Delete Account']") 
@CacheLookup private WebElement deleteAccount;

@FindBy(xpath="//a[normalize-space()='Continue']") 
@CacheLookup private WebElement ContinueD;

@FindBy(xpath="//b[normalize-space()='Account Deleted!']")
@CacheLookup private WebElement accountDeleted;

//@FindBy(xpath="//p[normalize-space()='Your account has been permanently deleted!']") @CacheLookup private WebElement yourAccountHasBeenPermanen;
//@FindBy(xpath="//p[contains(text(),'You can create new account to take advantage of me')]") @CacheLookup private WebElement youCanCreateNewAccountTo;

	
//--------------------------------Methods of Locators--------------------------
	public Boolean msgEnterAccountInfo() {
		
		return msgEnterAccInfo.isDisplayed();
	}
	
	public void clickMr()
	{
		mr.click();
	}
	public void clickMrs()
	{
		mrs.click();
	}
	public void setName(String user) {
		name.sendKeys(user);
	}
	public void setPassword(String psw) {
		password.sendKeys(psw);
	}
	public void setDay(String Day) {
		Select sel=new Select(day);
		sel.selectByValue(Day);
	}
	
	public void setMonth(String Month1) {
		Select sel=new Select(month);
		sel.selectByVisibleText(Month1);
	}
	
	public void setYear(String Year) {
		Select sel=new Select(year);
		sel.selectByValue(Year);
	}
	
	public void clickSignUpForOurNewsletter()
	{
		signUpForOurNewsletter.click();
	}
	public void clickReceiveSpecialOffersFromOu()
	{
		receiveSpecialOffersFromOu.click();
	}
public Boolean msgAddressInformation() {
		
		return addressInformation.isDisplayed();
	}
	
public void setfirstName(String user) {
	firstName.sendKeys(user);
}
public void setlastName(String user) {
	lastName.sendKeys(user);
}
public void setcompany(String user) {
	company.sendKeys(user);
}
public void setaddress(String user) {
	address.sendKeys(user);
}
public void setaddress2(String user) {
	address2.sendKeys(user);
}
public void setcountry(String Year) {
	Select sel=new Select(country);
	sel.selectByValue(Year);
}	
public void setstate(String user) {
	state.sendKeys(user);
}
public void setcity(String user) {
	city.sendKeys(user);
}
public void setzipcode(String user) {
	zipcode.sendKeys(user);
}
public void setmobileNumber(String user) {
	mobileNumber.sendKeys(user);
}
public void clickcreateAccount()
{
	createAccount.click();
}
	
public Boolean msgAccountCreated() {
	
	return accountCreated.isDisplayed();
}

public void clickContinue()
{
	Continue.click();
}
	
public Boolean msgLoggedInAs(String username) {
	
	return loggedInAs.getText().contains(username);
}	
	
public void clickdeleteAccount()
{
	deleteAccount.click();
}	
	
	
public void clickContinueD()
{
	ContinueD.click();
}	
	

//Example additions in SignupPage.java
public By locatorEnterAccountInfo() {
 return By.xpath("//*[text()='Enter Account Information']"); // Replace with your actual locator
}

public By locatorAccountCreated() {
 return By.xpath("//*[text()='Account Created!']");
}

public By locatorLoggedInAs() {
 return By.xpath("//*[contains(text(),'Logged in as')]");
}

public By locatorAccountDeleted() {
 return By.xpath("//*[text()='Account Deleted!']");
}

public boolean msgAccountDeleted() {
 return driver.findElement(locatorAccountDeleted()).isDisplayed();
}
	

public Boolean msgaccountDeleted() {
	
	return accountDeleted.isDisplayed();
}
	
	
	
	
	
	
	
}
