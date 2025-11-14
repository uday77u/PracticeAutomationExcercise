package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickEventsPage extends BasePage {

	public ClickEventsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locator
	@FindBy(xpath = "//b[text()='Cat']")
	private WebElement CatBtn;
	
	@FindBy(xpath = "//b[text()='Dog']")
	private WebElement DogBtn;
	
	@FindBy(xpath = "//b[text()='Pig']")
	private WebElement PigBtn;
	
	@FindBy(xpath = "//b[text()='Cow']")
	private WebElement CowBtn;
	
	@FindBy(xpath = "//h2[@id='demo']")
	private WebElement AnimalSoundTxt;
	
	
	//Methods
	public void clickCatBtn() {
		CatBtn.click();
	}
	
	public void clickDogBtn() {
		DogBtn.click();
	}
	
	public void clickPigBtn() {
		PigBtn.click();
	}
	
	public void clickCowBtn() {
		CowBtn.click();
	}
	
	public String getAnimalSoundTxt() {
		return AnimalSoundTxt.getText();
	}
}
