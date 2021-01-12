package Module9_PageFactoryImplementation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Module9.Selenium_InvokeChromeBrowser;

public class HeroKUAppExitAd extends Selenium_InvokeChromeBrowser{

	@FindBy (how=How.CSS, using="h3")
	public WebElement oTopHeader;
	
	@FindBy (how = How.LINK_TEXT, using = "Exit Intent")
	public WebElement oExitIntentLink;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
	
		//Instantiating page factory for HeroKUAppExitAd class
		HeroKUAppExitAd obHeroKUAppExitAd = PageFactory.initElements(driver, HeroKUAppExitAd.class);
		
		//Clicking on Exit Intent link
		obHeroKUAppExitAd.oExitIntentLink.click();
		
		//Waiting for 3 seconds
		Thread.sleep(3000);
		//WebElement e = driver.findElement(By.cssSelector("h3"));
		
//		//Instantiating Actions
//		Actions action = new Actions (driver);
//		
//		//Moving the mouse to top header
//		action.moveByOffset(600, -1).build().perform();
//		System.out.println("Moved to the corresponding element");
//		
//		//driver.//*[@id='ouibounce-modal']/div[2]/div[3]/p
		
		//Instantiating an object of robot class
		Robot robot = new Robot ();
		
		//Pressing left mouse button
		robot.mousePress(InputEvent.BUTTON2_MASK);
		
		//Moving mouse out of the viewport
		robot.mouseMove(600, 5);
		
		//Releasing left mouse button
		robot.mouseRelease(InputEvent.BUTTON2_MASK);
		
		//Waiting for 3 seconds
		Thread.sleep(3000);
		
		//Printing message in console
		System.out.println("Window has been invoked");
		
		//Clicking on console button
		driver.findElement(By.xpath("//div[@id='ouibounce-modal']/div[2]/div[3]/p")).click();
		
		//Printing in console window
		System.out.println("Clicking on Close button");
		
	}

}
