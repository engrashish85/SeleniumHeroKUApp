package Module9_PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;

public class HeroKUAppInputsPage {
	
	@FindBy (how = How.XPATH, using = "//h3[text()='Inputs']/parent::div//input[@type='number']")
	public WebElement oInputDropdownTextBox;
	
	public void validateVisibilityOfDropDownTextBox () {
		
		//Validating visibility of input drop down box
		Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG ();
		Boolean bcheckVisible = obSelenium_WorkingWithDriver_TestNG.checkVisibilityOfElement(oInputDropdownTextBox);
		
		//Printing output of validation to console
		if (bcheckVisible == true) {
			System.out.println("Input dropdown textbox is visible");
		}
		else {
			System.out.println("Input dropdown textbox is NOT visible");
		}
	}
}
