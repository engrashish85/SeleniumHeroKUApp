package Module9_PageFactoryImplementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Module9.Selenium_InvokeChromeBrowser;


public class HeroKUAppCheckboxesPage extends Selenium_InvokeChromeBrowser {
	
	@FindBy(how=How.XPATH, using="//form[@id='checkboxes']//following-sibling::input")
	public List <WebElement> oCheckBoxes;
	
	@FindBy(how=How.LINK_TEXT, using = "Checkboxes")
	public WebElement oCheckBoxesLink;
	
	@FindBy (how=How.XPATH, using = "//form[@id='checkboxes']//following-sibling::input//following-sibling::text()")
	public List <String> oCheckBoxTextList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
				
		//Instantiating page objects using PageFactory
		HeroKUAppCheckboxesPage obHeroKUAppCheckBoxesPage = PageFactory.initElements(driver, HeroKUAppCheckboxesPage.class);
		obHeroKUAppCheckBoxesPage.oCheckBoxesLink.click();
		
		System.out.println("Size of checkboxes list is - "+obHeroKUAppCheckBoxesPage.oCheckBoxes.size());
		for (WebElement oCheckBox:obHeroKUAppCheckBoxesPage.oCheckBoxes) {
			System.out.println("Tag Name - "+oCheckBox.getTagName());
			Boolean scheckBoxSelectionStatus = oCheckBox.isSelected();
			if (!scheckBoxSelectionStatus) {
				oCheckBox.click();
			}
		}
		
	}

}
