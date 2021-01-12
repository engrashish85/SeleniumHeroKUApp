package Module9_JUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Module9.Selenium_WorkingWithDriver;
import Module9_PageFactoryImplementation.HeroKUAppChallengingDOM;

public class NewToursSelectFlight extends Selenium_WorkingWithDriver {
	
	public String sURL = "http://www.newtours.demoaut.com/";
	
	@FindBy (how = How.NAME, using = "userName")
	WebElement UserName;
	
	@FindBy (how = How.NAME, using = "password")
	WebElement Password;
	
	@FindBy (how = How.NAME, using = "login")
	WebElement Login;
	
	@FindBy (how = How.NAME, using = "fromPort")
	WebElement departingFrom;
	
	@FindBy (how = How.NAME, using = "toPort")
	WebElement departingTo;
	
	@FindBy (how = How.NAME, using = "findFlights")
	WebElement findFlightsImage;
	
//	@FindBy (how = How.XPATH, using = "//b/font[contains(text(), 'DEPART')]/ancestor::TABLE[2]")
//	WebElement departTable;
	
	@FindBy (how = How.XPATH, using = "//b/font[contains(text(), 'RETURN')]/ancestor::TABLE[2]")
	WebElement returnTable;
	
	@Before
	public void openBrowserAndInitializeDriver () {
		
		//Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = getChromeDriver ();
		
		//Invoking URL in chrome browser
		InvokeChrome(sURL);
	}
	
	@Test
	public void selectFlight () throws InterruptedException {
		NewToursSelectFlight obNewToursSelectFlight = PageFactory.initElements(driver, NewToursSelectFlight.class);
		obNewToursSelectFlight.Login();
		obNewToursSelectFlight.selectFlight(1, 2);
		Thread.sleep(2000);
		obNewToursSelectFlight.retrieveFlightAttributesInArray(1);
	}
	
	public void Login () {		
		UserName.sendKeys("mercury");
		Password.sendKeys("mercury");
		Login.click();
	}
	
	public void selectFlight (int From, int To) {
		Select departingFromDropdown = new Select(departingFrom);
		departingFromDropdown.selectByIndex(From);
		Select departingToDropdown = new Select(departingFrom);
		departingToDropdown.selectByIndex(To);
		findFlightsImage.click();	
	}
	
	public void retrieveFlightAttributesInArray (int columnNumber) {
		HeroKUAppChallengingDOM obHeroKUAppChallengingDOM = new HeroKUAppChallengingDOM ();
		By departTable = By.xpath("//b/font[contains(text(), 'DEPART')]/ancestor::TABLE[2]");
		ArrayList <String> flightRowData = obHeroKUAppChallengingDOM.returnDataFromTable(departTable, "tr");
		System.out.println(flightRowData);
		HashMap <Integer, Integer> sPrice = new HashMap <Integer, Integer> ();
		for (int i = 5; i <= flightRowData.size(); i=i+2) {
			System.out.println(flightRowData.get(i));
			String sText = flightRowData.get(i).replace("Price: $", "");
			sText = sText.replace(" (based on round trip)", "");
			int iPrice = Integer.parseInt(sText);
			int j = i-2;
			sPrice.put(j, iPrice);
		}
		
		//Printing hashmap
		System.out.println("Price is - " +sPrice);
		
		//Finding the lowest number in the hashmap
		int iMin = Collections.max(sPrice.values());
		System.out.println("Minimum value is - "+iMin);
		
		int iRow = getKey(sPrice, iMin);
		System.out.println("Row having minimum value is - "+iRow);
		
		//Clicking on the radio button having minimum amount
		By radioButton = By.xpath("//b/font[contains(text(), 'DEPART')]/ancestor::TABLE[2]/tbody/tr["+iRow+"]/td/input[1]");
		driver.findElement(radioButton).click();
		
//		ArrayList <String> flightTableRoData = new ArrayList <String> ();
//		ArrayList<ArrayList<String>> flightPriceData = new ArrayList<ArrayList<String>> ();
//		for (int i=4; i<=flightRowData.size();i=i+2)
//		{
//			flightTableRowData = obHeroKUAppChallengingDOM.returnDataOfTableRow(departTable, i);
//			flightPriceData.add(flightTableRowData);
//			System.out.println("Data of row " +i+" is - "+flightTableRowData);
//		}
//		System.out.println("Flight price data arraylist is - "+flightPriceData);
	}
	
}
