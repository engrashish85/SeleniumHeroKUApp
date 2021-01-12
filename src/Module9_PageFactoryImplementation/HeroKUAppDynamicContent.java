package Module9_PageFactoryImplementation;

import Module9.Selenium_WorkingWithDriver;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;

import java.util.HashMap;

public class HeroKUAppDynamicContent extends Selenium_WorkingWithDriver {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Returning driver
		driver = obDriver.getChromeDriver();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Creating an object of class
		HeroKUAppDynamicContent obHeroKUAppDynamicContent = new HeroKUAppDynamicContent ();
		
		//Retrieving values from xml file
		String sDynamicContentLinkText1 = obHeroKUAppDynamicContent.returnValueFromXMLReader("//Objects/DynamicContent/DynamicContentLinkText");
		String sDynamicContentText1 = obHeroKUAppDynamicContent.returnValueFromXMLReader("//Objects/DynamicContent/DynamicContentText");
		String sClickHereLinkText1 = obHeroKUAppDynamicContent.returnValueFromXMLReader("//Objects/DynamicContent/ClickHereLinkText");
		
		By sDynamicContentText = By.xpath(sDynamicContentText1);
		By sDynamicContentTextLink = By.linkText(sDynamicContentLinkText1);
		By sClickHereLinkText = By.linkText(sClickHereLinkText1);
		
		//Clicking on Dynamic Text Link
		obDriver.clickElementOnPage(sDynamicContentTextLink);
		
		//Retrieving text of all Dynamic elements in hash map
		HeroKUAppChallengingDOM obHeroKUAppChallengingDOM = new HeroKUAppChallengingDOM ();
		HashMap <Integer, String> dynamicContentsElementsHashMap = obHeroKUAppChallengingDOM.returnAttributesOfTheElementsBasedOnAncestor(sDynamicContentText);
		
		//Printing hash map in console
		System.out.println(dynamicContentsElementsHashMap);
		
		//Clicking on Dynamic Text Link
		obDriver.clickElementOnPage(sClickHereLinkText);
		
		//Retrieving text of all Dynamic elements in hash map
		HashMap <Integer, String> dynamicContentsElementsHashMap1 = obHeroKUAppChallengingDOM.returnAttributesOfTheElementsBasedOnAncestor(sDynamicContentText);
		
		//Printing hash map in console
		System.out.println(dynamicContentsElementsHashMap1);
		
		//Closing browser
		//driver.quit();
		
	}

}
