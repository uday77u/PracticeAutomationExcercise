package com.automationExcercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//-------------------------------------------Locators-----------------------------------------
	@FindBy(xpath = "//a[text()='Stylish Dress']")
	WebElement StylishDress;
	@FindBy(xpath = "//a[text()='Men Tshirt']")
	WebElement Tshirt;
	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	WebElement btnProceedToCheckout;
	@FindBy(xpath = "//u[text()='Register / Login']")
	WebElement btnRegisterOrLogin;
	
	
	
	
	
//------------------------------------------Method--------------------------------------------
	public boolean StylishDressExist() {
		return StylishDress.isDisplayed();
	}
	public boolean TshirtExist() {
		return Tshirt.isDisplayed();
	}
	public void clickBtnProceedToCheckout() {
		btnProceedToCheckout.click();
	}
	public void clickBtnRegisterOrLogin() {
		btnRegisterOrLogin.click();
	}
	
	
	
}
