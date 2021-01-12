package Module9_PageFactoryImplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppFloatingMenu extends Selenium_WorkingWithDriver {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		
		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		
		//Returning driver
		driver = obDriver.getChromeDriver();
		
		//Retrieving values from properties file
		String sFloatingMenuParagraphTextxPath = obDriver.returnValueFromPropertiesFile("sFloatingMenuParagraphText_xPath");
		String sFloatingMenuxPath = obDriver.returnValueFromPropertiesFile("sFloatingMenuLink_xPath");
		String sFloatingMenuGenericLinkText = obDriver.returnValueFromPropertiesFile("sFloatingMenuGenericLink_LinkText");
		String sMenuLinksxPath = obDriver.returnValueFromPropertiesFile("sMenuLinks_xPath");
		
		//Instantiating WebElements
		WebElement oFloatingMenuLink = driver.findElement(By.xpath(sFloatingMenuxPath));
		
		//Clicking on Floating Menu Link
		oFloatingMenuLink.click();
		
		//Retrieving paragraph elements on the page
		List <WebElement> sFloatingMenuParagraph = driver.findElements(By.xpath(sFloatingMenuParagraphTextxPath));
		
		//Retrieving paragraphs in ArrayList
		ArrayList <String> arrayListFloatingMenuParagraph = new ArrayList <String> ();
		
		System.out.println("Size of webelements is - "+sFloatingMenuParagraph.size());
		
		//Initializing intCouter
		int intCouter = 0;
		
		//Retrieving paragraph text of web elements in array list
		for (WebElement floatingMenuParagraph : sFloatingMenuParagraph) {
			String sFloatingMenuParagraphText = floatingMenuParagraph.getText();
			arrayListFloatingMenuParagraph.add(sFloatingMenuParagraphText);
			System.out.println("Text present at - " +intCouter+ " position is - "+arrayListFloatingMenuParagraph.get(intCouter));
			intCouter = intCouter + 1;
		}
		
		System.out.println("ArrayList is - "+arrayListFloatingMenuParagraph);
		
		//Retrieving menu links in a List
		List <WebElement> oMenuLinks = driver.findElements(By.xpath(sMenuLinksxPath));
		
		//Retrieving the number of menu links
		int menuLinksSize = oMenuLinks.size();
		
		//Initializing array and putting the text of menu links in an array
		String[] arrayMenuLinksText = new String[menuLinksSize];
		System.out.println("Length of arrayMenuLinksText array is - " +arrayMenuLinksText.length);
		for (int iCounter = 0; iCounter < menuLinksSize; iCounter ++) {
			arrayMenuLinksText[iCounter] = oMenuLinks.get(iCounter).getText();
			System.out.println("The text of element is - " +arrayMenuLinksText[iCounter]);
			
			//Replacing the text stored in sFloatingMenuGenericLinkText variable with the corresponding link text
			String sLinkText = sFloatingMenuGenericLinkText.replace(sFloatingMenuGenericLinkText, arrayMenuLinksText[iCounter]);
			
			//Creating a WebElement at run time to point to the corresponding link and clicking on the same after wait of 5 seconds
			WebElement oMenuLink = driver.findElement(By.linkText(sLinkText));
			Thread.sleep(2000);
			oMenuLink.click();
		}
		
		//Closing browser by quitting driver
		driver.quit();
	
	}

}
