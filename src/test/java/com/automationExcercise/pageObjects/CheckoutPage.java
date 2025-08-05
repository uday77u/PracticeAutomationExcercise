package com.automationExcercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//------------------------------Locators----------------------------------------------
	@FindBy(css = "[name='message']") public WebElement txtCommentArea;
	@FindBy(xpath = "//a[text()='Place Order']") public WebElement btnPlaceOrder;	
	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[1]") public WebElement dispDeliveryAddressFirstLastname;
	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[2]") public WebElement dispBillingAddressFirstLastname;
	
	
	
	
	
			
	
			
			
			
			
//--------------------------------Methods---------------------------------------------
public void setTxtCommentArea(String comment) {
	txtCommentArea.sendKeys(comment);
}
public void clickBtnPlaceOrder() {
	btnPlaceOrder.click();
}	

public String getDispDeliveryAddressFirstLastname() {
	return dispDeliveryAddressFirstLastname.getText();
}
public String getDispBillingAddressFirstLastname() {
	return dispBillingAddressFirstLastname.getText();
}

	
}
