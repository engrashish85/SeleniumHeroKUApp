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

public class HeroKUAppHoversPage extends Selenium_WorkingWithDriver_TestNG {
	
	@FindBy (how=How.XPATH, using="//img[@alt='User Avatar'][contains(@src, 'avatar')]")
	private List <WebElement> oHoverImageList;
	
	@FindBy (how=How.LINK_TEXT, using = "View profile")
	private WebElement oViewProfileLink;
	
	
	public void ValidateUserID (int iUserID) throws IOException {
		
		//Retrieving current class name
		sCurrentClassName = this.getClass().getName();
		
		//Doing mouse hover on element
		Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG ();
		obSelenium_WorkingWithDriver_TestNG.onMouseHoverOnElement(oHoverImageList.get(iUserID-1));
		
		//Setting dynamic xpath at runtime to get user id of the text on which mouse hover is done
		WebElement sImageNameXPath = oHoverImageList.get(iUserID-1).findElement(By.xpath("//ancestor::div/following::h5"));
		
		//Retrieving the text of the userID and printing the same in console
		String sUserIDMouseHoverText = sImageNameXPath.getText();
		System.out.println("sImageNameXPath is - " + sUserIDMouseHoverText);
		
		//Retrieving the userID
		String sUserIDText = sUserIDMouseHoverText.replace("name:", "").trim();
		System.out.println("sUserIDText - "+sUserIDText);
		
		String sUserIDText1 = "name: user"+String.valueOf(iUserID);
		System.out.println("sUserIDText1 - "+sUserIDText1);
		
		//if (("user"+String.valueOf(iUserID)).equals(sUserIDText)) {
		if (driver.getPageSource().contains(sUserIDText1)) {
			
			//Reporting to extent reports
			test.log(LogStatus.PASS, test.addScreenCapture(obSelenium_WorkingWithDriver_TestNG.screenCapture
					(driver, sCurrentClassName)) + "UserID - " + "user"+String.valueOf(iUserID) + 
					" is matching with - "+ sUserIDText1);
			
		}
		
		else {
			
			//Reporting to extent reports
			test.log(LogStatus.FAIL, test.addScreenCapture(obSelenium_WorkingWithDriver_TestNG.screenCapture
					(driver, sCurrentClassName)) + "UserID - " + "user"+String.valueOf(iUserID) + 
					" is NOT matching with - "+ sUserIDText1);
		
		}
		
		//Clicking on View profile link
		oViewProfileLink.click();
		
		//Waiting for 1 second
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reporting to extent reports
		test.log(LogStatus.INFO, test.addScreenCapture(obSelenium_WorkingWithDriver_TestNG.screenCapture
				(driver, sCurrentClassName)) + "Naivgated to user"+String.valueOf(iUserID)+ " page");
		
		//Navigating to the back page in browser
		driver.navigate().back();
		
	}

}
