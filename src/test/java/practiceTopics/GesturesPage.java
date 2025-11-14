package practiceTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GesturesPage extends BasePage {

	public GesturesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locator
	@FindBy(id = "moveMeHeader")
	private WebElement moveMeHeader;
	
	@FindBy(id = "div1")
	private WebElement DragAndDropBox1;
	
	@FindBy(id = "div2")
	private WebElement DragAndDropBox2;
	
	//Methods
	public void DragMoveMeHeader() {
		Actions act=new Actions(driver);
		act.dragAndDropBy(moveMeHeader, 500,100).perform();;
	}
	
	public void DragAndDropFromLeftToRightBox() {
		Actions act=new Actions(driver);
		act.dragAndDrop(DragAndDropBox1, DragAndDropBox2).perform();;
	}
	
	public void DragAndDropFromRightToLeftBox() {
		Actions act=new Actions(driver);
		act.dragAndDrop(DragAndDropBox2, DragAndDropBox1).perform();;
	}
	
}
