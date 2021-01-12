package Module9_PageFactoryImplementation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import Module9.Selenium_WorkingWithDriver;

public class Guru99popup extends Selenium_WorkingWithDriver {
	
	//Initializing objects
	By oClickHereLinkText = By.linkText("Click Here");
	By oEmailIDInput = By.name("emailid");
	By oSubmitButton = By.xpath("//input[@type='submit'][@name='btnLogin'][@value='Submit']");
	String sMainWindowHandle;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Instantiating object of Guru99popup
		Guru99popup obGuru99popup = new Guru99popup();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sGuru99URL);
		
		//Clicking on Challenging DOM Link
		obDriver.clickElementOnPage(obGuru99popup.oClickHereLinkText);
		
		//Switching to child Window
		obGuru99popup.switchToChildWindow ();
		
		//Entering email id and click on Submit button
		driver.findElement(obGuru99popup.oEmailIDInput).sendKeys("engr.ashish@gmail.com");
		obDriver.clickElementOnPage(obGuru99popup.oSubmitButton);
		
		//Closing child window
		driver.close();
		
		//Switching to main window
		driver.switchTo().window(obGuru99popup.sMainWindowHandle);
		
		//Closing main window and quitting driver
		driver.close();
		driver.quit();
	
	}
	
	public void switchToChildWindow () {
		
		//Retrieving window handles
		sMainWindowHandle = driver.getWindowHandle();
		
		//To handle all new opened windows
		Set <String> allWindowHandles = driver.getWindowHandles();
		Iterator <String> windowIterator = allWindowHandles.iterator();
		
		while (windowIterator.hasNext()) {
			
			//Iterating through the child window handle
			String childWindowHandle = windowIterator.next();
			
			if (!sMainWindowHandle.equals(childWindowHandle)) {
				
				//Switching to child window
				driver.switchTo().window(childWindowHandle);
				
				//Exiting while loop
				break;
				
			}
		
		}
	
	}

}