package com.automationExcercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDonePage extends BasePage{

	public PaymentDonePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//b[normalize-space()='Order Placed!']") private WebElement msgOrderPlaced;
@FindBy(xpath="//p[normalize-space()='Congratulations! Your order has been confirmed!']") private WebElement msgYourOrderConformed;
@FindBy(xpath="//a[normalize-space()='Download Invoice']") private WebElement btnDownloadInvoice;
@FindBy(xpath="//a[normalize-space()='Continue']") private WebElement btnContinue;
	
public boolean msgYourOrderConformedExist() {
	return msgYourOrderConformed.isDisplayed();
}
public String getMsgYourOrderConformed() {
	return msgYourOrderConformed.getText();
}

public void clickBtnContinue() {
	btnContinue.click();
}
}
