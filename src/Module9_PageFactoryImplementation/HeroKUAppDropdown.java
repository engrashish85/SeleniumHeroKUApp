package Module9_PageFactoryImplementation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppDropdown extends Selenium_WorkingWithDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
		
		//Creating an object of Selenium_WorkingWithDriver class
		Selenium_WorkingWithDriver obSeleniumDriver = new Selenium_WorkingWithDriver();
		
		//Retrieving values from properties file
		String sDropDownLinkText = obSeleniumDriver.returnValueFromPropertiesFile("sDropDown_LinkText");
		String sDropDownListID = obSeleniumDriver.returnValueFromPropertiesFile("sDropDownList_id");
		
		//Clicking on DropDown link
		driver.findElement(By.linkText(sDropDownLinkText)).click();
		
		//Selecting values through drop down list
		WebElement sDropDownList = driver.findElement(By.id(sDropDownListID));
		Select sDropList = new Select (sDropDownList);
		sDropList.selectByValue("1");
		sDropList.selectByVisibleText("Option 2");
		sDropList.selectByIndex(1);
	}

}
