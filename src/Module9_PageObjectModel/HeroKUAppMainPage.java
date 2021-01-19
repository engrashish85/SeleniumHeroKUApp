package Module9_PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;

public class HeroKUAppMainPage extends Selenium_WorkingWithDriver_TestNG {
	
	@FindBy (how=How.LINK_TEXT, using="Geolocation")
	public WebElement oGeolocationLink;
	
	@FindBy (how = How.LINK_TEXT, using = "Horizontal Slider")
	public List<WebElement> oHorizontalSliders;
	
	@FindBy (how = How.LINK_TEXT, using = "Hovers")
	public WebElement oHoversLink;
	
	@FindBy (how = How.LINK_TEXT, using = "Infinite Scroll")
	public WebElement oInfiniteScroll;
	
	@FindBy (how = How.LINK_TEXT, using = "Inputs")
	public WebElement oInputsLink;

	@FindBy(how = How.LINK_TEXT, using = "JavaScript Alerts")
	public WebElement javaScriptAlertsLink;

	public void clickGeoLocationLink () {
		System.out.println("Entered clickGeoLocationLink");
		oGeolocationLink.click();
	}
	
	public int retrieveListSize (List<WebElement> elementList) {
		
		//Retrieving list size
		int listSize = elementList.size();
		
		//Returning value through the function
		return listSize;
	}
	
}
