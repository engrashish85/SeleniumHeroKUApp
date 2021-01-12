package Module9_PageFactoryImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppDynamicControls extends Selenium_WorkingWithDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Instantiating object of HeroKUAppDynamicControls
		HeroKUAppDynamicControls obHeroKUAppDynamicControls = new HeroKUAppDynamicControls ();
		
		//Retrieving attributes of objects from properties file
		String sDynamicControlsLinkText = obDriver.returnValueFromPropertiesFile("sDynamicControls_LinkText");
		String sDynamicControlsCheckBoxxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsCheckBox_xPath");
		String sDynamicControlsRemoveButtonxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsRemoveButton_xPath");
		String sDynamicControlsAddButtonxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsAddButton_xPath");
		String sDynamicControlsEnableDisableTextxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsEnableDisableText_xPath");
		String sDynamicControlsEnableButtonxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsEnableButton_xPath");
		String sDynamicControlsInputTextxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsInputText_xPath");
		
		//Clicking on Dynamic Controls link
		obDriver.clickElementOnPage(By.linkText(sDynamicControlsLinkText));
		
		//Instantiating Elements out of xpaths retrieved from properties file
		WebElement sDynamicControlsCheckBox = driver.findElement(By.xpath(sDynamicControlsCheckBoxxPath));
		WebElement sDynamicControlsEnableDisableText = driver.findElement(By.xpath(sDynamicControlsEnableDisableTextxPath));
		WebElement sDynamicControlsInputText = driver.findElement(By.xpath(sDynamicControlsInputTextxPath));
		WebElement sDynamicControlsRemoveButton = driver.findElement(By.xpath(sDynamicControlsRemoveButtonxPath));
		WebElement sDynamicControlsEnableButton = driver.findElement(By.xpath(sDynamicControlsEnableButtonxPath));
		
		//Validating whether elements exist on page
		obDriver.validateElementOnPage(sDynamicControlsCheckBox);
		obDriver.validateElementOnPage(sDynamicControlsEnableDisableText);
		obDriver.validateElementOnPage(sDynamicControlsRemoveButton);
		obDriver.validateElementOnPage(sDynamicControlsEnableButton);
		obHeroKUAppDynamicControls.validateDisabledObjectOnPage(sDynamicControlsInputText);
		
		//Checking the check box and clicking on Remove button
		sDynamicControlsCheckBox.click();
		sDynamicControlsRemoveButton.click();
		
		//Validating whether text labeled - 'It's gone!' is displayed on the page
		obHeroKUAppDynamicControls.validateTextOnPage("s gone!");
		
		//Instantiating driver
		WebElement sDynamicControlsAddButton = driver.findElement(By.xpath(sDynamicControlsAddButtonxPath));
		
		//Validating whether Add button is present back on the page
		obDriver.validateElementOnPage(sDynamicControlsAddButton);
				
		//Clicking on Add Button
		sDynamicControlsAddButton.click();
		
		//Validating whether text labeled - 'It's back!' is displayed on the page
		obHeroKUAppDynamicControls.validateTextOnPage("s back!");
		
		//Validating whether Remove button is present back on the page
		obDriver.validateElementOnPage(sDynamicControlsRemoveButton);
		
		//Clicking on Enable Button
		sDynamicControlsEnableButton.click();
		
		//Instantiating image
		String sDynamicControlsWaitImagexPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsWaitImage_xPath");
		WebElement sDynamicControlsWaitImage = driver.findElement(By.xpath(sDynamicControlsWaitImagexPath));
		
		//Validating whether wait image is present or not
		obDriver.validateElementOnPage(sDynamicControlsWaitImage);
		
		//Validating whether text labeled - 'It's back!' is displayed on the page
		obHeroKUAppDynamicControls.validateTextOnPage("s enabled!");
		
		//Instantiating Disable button xpath
		String sDynamicControlsDisableButtonxPath = obDriver.returnValueFromPropertiesFile("sDynamicControlsDisableButton_xPath");
		WebElement sDynamicControlsDisableButton = driver.findElement(By.xpath(sDynamicControlsDisableButtonxPath));
		
		//Validating Disable button on Page
		obDriver.validateElementOnPage(sDynamicControlsDisableButton);
				
		//Clicking on Disable button
		sDynamicControlsDisableButton.click();
		
		//Validating whether wait image is present or not
		obDriver.validateElementOnPage(sDynamicControlsWaitImage);
		
		//Validating whether text labeled - 'It's back!' is displayed on the page
		obHeroKUAppDynamicControls.validateTextOnPage("s disabled!");
		
		//Validating whether wait image is present or not
		obDriver.validateElementOnPage(sDynamicControlsEnableButton);
		
	}
	
	public void validateDisabledObjectOnPage (WebElement element) {
		
		//Instantiating driver
		driver = getChromeDriver ();
		
		//Initializing bFlag to False
		boolean bFlag = false;
		
		//Validating that whether the object is displayed or not
		if (element.isDisplayed()) {
			if (!(element.isEnabled())) {
				System.out.println("Element - " +element+ " is disabled and present on the page");
				bFlag = true;
			}
		}
		
		if (bFlag == false) {
			System.out.println("Element - " +element+ " is NOT disabled and NOT present on the page");
		}
	
	}
	
}
