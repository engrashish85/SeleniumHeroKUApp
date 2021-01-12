package Module9_PageFactoryImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppDynamicLoading extends Selenium_WorkingWithDriver {
	
	By oDynamicLoadingLinkText = By.linkText("Dynamic Loading");
	By oHiddenElementLinkText = By.xpath("//a[@href='/dynamic_loading/1']");
	By oNewElementLinkText = By.xpath("//a[@href='/dynamic_loading/2']");
	By oHiddenStartElementxPath = By.xpath("//div[@class='example']/div/button[text()='Start']");
	By oNewStartElementxPath = By.xpath("//button[text()='Start']");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Creating object of HeroKUAppDynamicLoading class
		HeroKUAppDynamicLoading obHeroKUAppDynamicLoading = new HeroKUAppDynamicLoading();
		
		//Instantiating element
		WebElement oDynamicLoadingLink = driver.findElement(obHeroKUAppDynamicLoading.oDynamicLoadingLinkText);
		
		//Clicking on Dynamic Loading link
		oDynamicLoadingLink.click();
		
		//Instantiating hidden element
		WebElement oHiddenElementLink = driver.findElement(obHeroKUAppDynamicLoading.oHiddenElementLinkText);
		
		//Clicking on hidden element link
		oHiddenElementLink.click();
		
		//Instantiating Hidden start button
		WebElement oHiddenStartElement = driver.findElement(obHeroKUAppDynamicLoading.oHiddenStartElementxPath);
		
		//Creating JavaScript object
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", oHiddenStartElement);
		
		//Clicking on back object
		System.out.println("Clicked on hidden start element");
		oHiddenStartElement.click();
		
		//Validating 'Hello World!' text on page
		obHeroKUAppDynamicLoading.validateTextOnPage("Hello World!");
				
		//Going to back button in browser history
		driver.navigate().back();
		
		//Instantiating new element link
		System.out.println("Clicking on New Element link");
		WebElement oNewElementLink = driver.findElement(obHeroKUAppDynamicLoading.oNewElementLinkText);
		oNewElementLink.click();
		
		//Clicking on Start object
		System.out.println("Clicking on Start button");
		WebElement oNewStartButton = driver.findElement(obHeroKUAppDynamicLoading.oNewStartElementxPath);
		oNewStartButton.click();
		
		//Validating 'Hello World!' text on page
		obHeroKUAppDynamicLoading.validateTextOnPage("Hello World!");		
			
	}

}
