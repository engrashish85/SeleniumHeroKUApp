package Module9_PageObjectModel;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;

public class HeroKUAppGeoLocationPage extends Selenium_WorkingWithDriver_TestNG {
	
	@FindBy (how=How.XPATH, using="//button[contains(text(),'Where am I?')]")
	public WebElement oWhereAmIButton;
	
	@FindBy (how=How.XPATH, using="//h3[text()='Geolocation']//following-sibling::p//child::div")
	public List<WebElement> oGeoLocationValues;
	
	@FindBy (how = How.XPATH, using = "//div[@id='map-link']/a")
	private WebElement oShowOnGoogle;
	
	@FindBy (how = How.ID, using = "searchboxinput")
	private WebElement oGoogleMapsSearchTextBox;
	
	@FindBy (how = How.XPATH, using = 
		"//h1[contains(@class, 'section-hero-header-title') and contains(@jsan, 'section-hero-header-title')]")
	private WebElement oGoogleMapsGeolocationSearchHeaderText;
	
	@FindBy (how = How.XPATH, using = "//div[@class='section-hero-header-description']//span")
	private WebElement oGoogleMapsGeoLocationDescriptionText;
	
	public String[] retrieveGeoLocationValues() {
		
		
		//Printing message to console
		System.out.println("Entering retrieveGeoLocationValues");
		
		//Clicking on "Where Am I" button
		oWhereAmIButton.click();
		
		System.out.println("Clicked on Where Am I button");
		
		//Initializing array
		String[] geoLocationValues = new String[2];
		
		//Retrieving GeoLocation values and putting the same in an array
		for (int i=0; i<2; i++) {
			geoLocationValues[i] = oGeoLocationValues.get(i).getText();
			System.out.println("Geolocation values - "+geoLocationValues[i]);
		}
		
		//Returning array through the function
		return geoLocationValues;
		
	}
	
	public void ValidateGeolocationValues (String[] geoLocationValues) {
		
		//Clicking on "See it on Google" link
		oShowOnGoogle.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Retrieving the values on google search textbox page and search header text and printing the same in console
		String sGeoLocationText = oGoogleMapsSearchTextBox.getAttribute("value");
		System.out.println("sGeoLocationText - "+sGeoLocationText);
		String sGeolocationSearchHeaderText = oGoogleMapsGeolocationSearchHeaderText.getText();
		System.out.println("sGeolocationSearchHeaderText - "+sGeolocationSearchHeaderText);
		String sGeoLocationDescriptionText = oGoogleMapsGeoLocationDescriptionText.getText();
		System.out.println("sGeoLocationDescriptionText - "+sGeoLocationDescriptionText);
		
		String[] arrayGeoLocationSearchBoxDisplayedText = sGeoLocationText.split(",");
		String[] arrayGeolocationSearchHeaderText = sGeolocationSearchHeaderText.split(" ");
		String[] arrayGeoLocationDescriptionText = sGeoLocationDescriptionText.split(",");
		for (int i = 0; i < geoLocationValues.length; i ++) {
			if ((geoLocationValues[i].trim()).equals((arrayGeoLocationSearchBoxDisplayedText[i].trim()))) {
				System.out.println(geoLocationValues[i] + " is matching with - "
						+arrayGeoLocationSearchBoxDisplayedText[i]);
			}
			else {
				System.out.println(geoLocationValues[i] + " is NOT matching with - "
						+arrayGeoLocationSearchBoxDisplayedText[i]);
			}
			
			if ((geoLocationValues[i].trim()).equals((arrayGeolocationSearchHeaderText[i].trim()))) {
				System.out.println(geoLocationValues[i] + " is matching with - "
						+arrayGeolocationSearchHeaderText[i]);
			}
			else {
				System.out.println(geoLocationValues[i] + " is NOT matching with - "
						+arrayGeolocationSearchHeaderText[i]);
			}
			
			if (((geoLocationValues[i].trim()).substring(0, 9)).equals((arrayGeoLocationDescriptionText[i].trim()).substring(0, 9))) {
				System.out.println((geoLocationValues[i].substring(0, 9)) + " is matching with - " 
						+(arrayGeoLocationDescriptionText[i].substring(0, 9))) ;
			}
			else {
				System.out.println((geoLocationValues[i].substring(0, 9)) + " is NOT matching with - " 
						+(arrayGeoLocationDescriptionText[i].substring(0, 9))) ;
			}
		}
		
	}
}
