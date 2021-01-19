package Module9_PageObjectModel;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;

public class HeroKUAppInfiniteScrollsPage extends Selenium_WorkingWithDriver_TestNG {
	
	@FindBy (how=How.XPATH, using="//img[@alt='User Avatar'][contains(@src, 'avatar')]")
	private List <WebElement> oHoverImageList;
	
	@FindBy (how=How.LINK_TEXT, using = "View profile")
	private WebElement oViewProfileLink;
	
	
	public void scrollInfinite (int scrollNumbers) throws IOException {
		
		//Retrieving current class name
		sCurrentClassName = this.getClass().getName();
		
		//Scrolling the page to the times as mentioned in the excel sheet
		for (int i = 0; i < scrollNumbers; i ++) {
			
			//Scrolling to 0, 50 coordinates
			Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG ();
			obSelenium_WorkingWithDriver_TestNG.scrollPage(0, 100);
			
			//Reporting results to extent reports
			test.log(LogStatus.INFO, obSelenium_WorkingWithDriver_TestNG.screenCapture(driver, sCurrentClassName) + 
					"Executing scrollBy statement with the corresponding x and y coordinates");

		}
				
	}

}
