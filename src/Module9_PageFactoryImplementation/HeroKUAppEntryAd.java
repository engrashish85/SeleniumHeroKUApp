package Module9_PageFactoryImplementation;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class HeroKUAppEntryAd extends Selenium_WorkingWithDriver{
	
	//Instantiating WebElements
	@FindBy(how=How.LINK_TEXT, using="Entry Ad")
	public WebElement oEntryAd;
	
	//Initializing childWindow
	String childWindow;
	
	//Instantiating attributes of objects
	@FindBy(how = How.XPATH, using = "//div[@class='modal-title']/h3")
	public WebElement oModalWindowTitle;
	
	@FindBy (how = How.XPATH, using = "//div[@class='modal-body']/p")
	public WebElement oModalWindowBody;
	
	@FindBy (how = How.XPATH, using = "//div[@id='modal']/div[2]/div[3]/p")
	public WebElement oModalWindowClose;
			
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
				
		//Instantiating elements
		HeroKUAppEntryAd obHeroKUAppEntryAd = PageFactory.initElements(driver, HeroKUAppEntryAd.class);
		obHeroKUAppEntryAd.oEntryAd.click();
		
		//Retrieving window handle in Selenium
		String sParentWindowHandle = driver.getWindowHandle();
		Set <String> sWindowHandles = driver.getWindowHandles();
		int sizeofWindows = sWindowHandles.size();
		System.out.println("size of windows is -"+sizeofWindows);
		System.out.println("Current parent window handle is - "+sParentWindowHandle);
		
		//Sleeping for 3 seconds
		//Thread.sleep (3000);
		
		//driver.switchTo().alert().accept();
		
		//Retrieving title and body of the modal window
		String sTitle = obHeroKUAppEntryAd.oModalWindowTitle.getText();
		String sBody = obHeroKUAppEntryAd.oModalWindowBody.getText();
		
		System.out.println("Title is -"+sTitle+ " and body is - "+sBody);
		
		//Clicking on Close Button
		obHeroKUAppEntryAd.oModalWindowClose.click();
		
	}
	
	public String switchToWindow () {
		
		//Initializing sTitle
		String sTitle = null;
		
		//Getting window Handles in Selenium
		Set <String> allWindows = driver.getWindowHandles();
		
		//Retrieving and printing size of windows
		int sizeofWindows = allWindows.size();
		System.out.println("size of windows is - "+sizeofWindows);
		
		Iterator <String> window1 = allWindows.iterator();
		while (window1.hasNext()) {
			childWindow = window1.next();
		}
		
		if (!allWindows.equals(childWindow)) {
			sTitle = driver.switchTo().window(childWindow).getTitle();
			System.out.println("Title of child window is - "+sTitle);	
		}	
		
		//Returning value through the function
		return sTitle;
	}
}
