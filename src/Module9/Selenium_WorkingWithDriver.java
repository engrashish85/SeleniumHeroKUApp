package Module9;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Selenium_WorkingWithDriver extends Selenium_InvokeChromeBrowser {
	public static void main(String[] args) throws Exception, IOException, DocumentException {
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Validating whether text "Welcome to the-internet" is displayed on the page or not
		obDriver.validateTextOnPage("Welcome to the-internet");
		
		//Retrieving all Links into Elements List
		List <WebElement> sLinkList = obDriver.assembleObjectsIntoArrayList("a");
		
		//Retrieving the size of sLinkList
		int sSizeOfLinkList = sLinkList.size();
		
		//Initializing array and putting all text of links into an array
		String[] arrayLinksText = new String[sSizeOfLinkList];
		int i = 0;
		for (WebElement e:sLinkList) {
			String sLinkText = e.getText();
			arrayLinksText [i] = sLinkText;
			i = i + 1;
		}
		
		//Retrieving text of all links from array and printing the same in console
		for (int j = 1; j < arrayLinksText.length+1; j ++) {
			System.out.println("Link " +j+ " is - "+arrayLinksText[j-1]);
		}
		
		//Retrieving A/B Testing link value from properties file
		String sABTestingLink = obDriver.returnValueFromPropertiesFile ("sABTesting_LinkText");
		
		//Initializing object
		By oABTestingLink = By.linkText(sABTestingLink);
		
		//Clicking A/B Testing testing link on the page
		obDriver.clickElementOnPage (oABTestingLink);
		
		//Retrieving Elemental Selenium link properties from XML File (ObjectRepository.xml)
		String sElementalSeleniumLinkText = obDriver.returnValueFromXMLReader("//Objects/ABTesting/ElementalSelenium");
		
		//Initializing Object
		By sElementalSeleniumLink = By.linkText(sElementalSeleniumLinkText);
		
		//Clicking on Elemental Selenium Link
		obDriver.clickElementOnPage(sElementalSeleniumLink);
		
		//Closing browser by quitting driver
		obDriver.quitDriver();
		
	}
	
	
	public void validateTextOnPage (String sText) {
		
		//Returning driver
		driver = getChromeDriver();
		
		//Creating a list of elements matching with the xpath containing corresponding text on page given as argument
		List <WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(), '" + sText + "')]"));
		
//		//Making a wait object (Explicit wait)
//		WebDriverWait wait =  new WebDriverWait (driver, 20);
//		
//		//Waiting for 20 seconds to check if the element is available inside 20 seconds
//		wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
//				
		//Printing that element is contained if list size is !=0 else printing that element is not contained in the page
		if (elementList.size()!= 0) {
			System.out.println("The text - "+sText+ " is contained in the page");
		}
		else {
			System.out.println("The text - "+sText+ " is NOT contained in the page");
		}	
	}
	
	
	public List <WebElement> assembleObjectsIntoArrayList (String sObjectType){
		
		//Returning driver
		driver = getChromeDriver();
		
		//Retrieving list of elements containing tag name as sObjectType given as an argument
		List <WebElement> elementList = driver.findElements(By.tagName(sObjectType));
		
		//Retrieving size of elements in a variable
		int iElementListSize = elementList.size();
		
		//Printing size of elements in console
		System.out.println("Size of list is - "+iElementListSize);
		
		//Printing on console that list is not empty is iElementListSize is >0 else printing that list is empty
		if (iElementListSize > 0) {
			System.out.println("Element List is NOT empty");
		}
		else {
			System.out.println("Element List is empty");
		}
		
		//Returning list of elements through the method
		return elementList;
	 }
	
	public void clickElementOnPage (By elementObject) {
		
		//Retrieving driver
		driver = getChromeDriver();
		
		//Initializing bElementFlag to False
		boolean bElementFlag = false;
		
		//Validate whether the element is present on the page or not
		if ((driver.findElements(elementObject).size()) > 0) {
			
			//Validate whether the element is displayed on the page or not
			if (driver.findElement(elementObject).isDisplayed()) {
				
				//Validate whether the object is enabled or disabled
				if (driver.findElement(elementObject).isEnabled()) {
					System.out.println("Object is visible on page and enabled");
					bElementFlag = true;
					driver.findElement(elementObject).click();
				}
					
			}
		
		}
		
		if (bElementFlag == false) {
			System.out.println("Object is either NOT found or NOT enabled or NOT visible on the page");
		}
	
	}
	
	
	public void validateElementOnPage (WebElement elementObject) {
		
		//Retrieving driver
		driver = getChromeDriver();
		
		//Making a wait object (Explicit wait)
		WebDriverWait wait =  new WebDriverWait (driver, 20);
		
		//Initializing bElementFlag to False
		boolean bElementFlag = false;
		
		//Waiting for 20 seconds to check if the element is available inside 20 seconds
		wait.until(ExpectedConditions.visibilityOf(elementObject));
		
		//Validate whether the element is displayed on the page or not
		if (elementObject.isDisplayed()) {
			
			System.out.println("Element " + elementObject + " is displayed on the page");
				
			//Validate whether the object is enabled or disabled
			if (elementObject.isEnabled()) {
				System.out.println("Object " + elementObject + " is enabled here");
				bElementFlag = true;
			}
					
		}
		
		if (bElementFlag == false) {
			System.out.println("Object " + elementObject + "is either NOT found or NOT enabled or NOT visible on the page");
		}
	
	}
	
	public String returnValueFromPropertiesFile (String key) throws IOException {
		Properties prop = new Properties ();
		FileInputStream oFile = new FileInputStream("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9\\Config\\ObjectRepository.Properties");
		prop.load(oFile);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String returnValueFromPropertiesFile (String sLocation, String key) throws IOException {
		Properties prop = new Properties ();
		FileInputStream oFile = new FileInputStream(sLocation);
		prop.load(oFile);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String returnValueFromXMLReader (String key) throws DocumentException {
		File InputFile = new File ("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9\\Config\\ObjectRepository.xml");
		SAXReader saxReader = new SAXReader ();
		Document document = saxReader.read(InputFile);
		String sValue = document.selectSingleNode(key).getText();
		System.out.println("Value from xml reader is - "+sValue);
		return sValue;
	}
	
	public <Key, Value> Key getKey(HashMap<Key, Value> hashmap, Value value) {
		for (Key key:hashmap.keySet()) {
			if (value.equals(hashmap.get(key))) {
				return key;
			}
		}
		return null;
	}

}
