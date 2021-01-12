package Module9_PageFactoryImplementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Module9.Selenium_InvokeChromeBrowser;

public class HeroKUAppDragAndDrop extends Selenium_InvokeChromeBrowser {
	
	@FindBy (how = How.LINK_TEXT, using = "Drag and Drop")
	public WebElement oLinkDragAndDrop;
	
	@FindBy (how = How.ID, using = "column-a")
	public WebElement oElementA;
	
	@FindBy (how = How.ID, using = "column-b")
	public WebElement oElementB;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
		
		//Instantiating page factory elements for drag and drop page
		HeroKUAppDragAndDrop obHeroKUAppDragAndDrop = PageFactory.initElements(driver, HeroKUAppDragAndDrop.class);
		obHeroKUAppDragAndDrop.oLinkDragAndDrop.click();
		
		//ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)
		
		//Creating an object of actions class
		Actions act1 = new Actions (driver);
		
		//Dragging and Dropping through actions class
		//act1.dragAndDrop(obHeroKUAppDragAndDrop.oElementA, obHeroKUAppDragAndDrop.oElementB).build().perform();;
		act1.clickAndHold(obHeroKUAppDragAndDrop.oElementB);
		act1.moveToElement(obHeroKUAppDragAndDrop.oElementA);
		act1.release();
		act1.build();
		act1.perform();
		
		System.out.println("Dragged and dropped");
	}

}
