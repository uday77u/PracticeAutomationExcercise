package com.automationExcercise.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsFormPage extends BasePage {

	public ContactUsFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//------------------------------------Locators-----------------------------------------------------------
@FindBy(xpath="//h2[contains(text(),'Get In Touch')]") @CacheLookup private WebElement GetInTouch;
@FindBy(xpath="//input[@placeholder='Name']") @CacheLookup private WebElement Name;
@FindBy(xpath="//input[@placeholder='Email']") @CacheLookup private WebElement Email;
@FindBy(xpath="//input[@placeholder='Subject']") @CacheLookup private WebElement Subject;
@FindBy(xpath="//textarea[@id='message']") @CacheLookup private WebElement YourMessageHere;
@FindBy(xpath="//input[@name='upload_file']") @CacheLookup private WebElement UploadFile;
@FindBy(xpath="//input[@name='submit']") @CacheLookup private WebElement Submit;

@FindBy(xpath="//div[@class='status alert alert-success']") @CacheLookup private WebElement msgSuccess;
@FindBy(xpath="//span[normalize-space()='Home']") @CacheLookup private WebElement home;





//----------------------------------Methods--------------------------------------------------------------
public boolean msgGetInTouch() {return GetInTouch.isDisplayed();}

public void setName(String name1) {
	Name.sendKeys(name1);}

public void setemail(String email) {
	Email.sendKeys(email);}

public void setSubject(String sub) {
	Subject.sendKeys(sub);}

public void setYourMessageHere(String sub) {
	YourMessageHere.sendKeys(sub);}

public void clickUploadFile() {
	UploadFile.click();
}

public void clickSubmit() {
	Submit.click();
}

public WebElement locatorUploadFile() {
	return UploadFile;
}

public boolean msgSuccessExist() {
	return msgSuccess.isDisplayed();
}

public void clickHome() {
	home.click();
}





}
