package Module9_PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import Module9_TestNG.HeroKUAppHorizontalSlider_DataProvider;
import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;

public class HeroKUAppHorizontalSliderPage extends Selenium_WorkingWithDriver_TestNG{
	
	@FindBy (how = How.XPATH, using = "//div[@class='sliderContainer']/input")
	private WebElement oHorizontalSlider;
	
	public void setHorizontalSliderRange (String dHorizontalRange) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creating object of Actions class
		Actions actions = new Actions(driver);
		int width = oHorizontalSlider.getSize().getWidth();
		System.out.println("width of slider is - "+width);
		//actions.moveToElement(oHorizontalSlider, (int) ((width*dHorizontalRange)/100), 0).click();
		int dHorizontalRange1 = Integer.valueOf(dHorizontalRange);
		System.out.println("Setting range as - "+dHorizontalRange1);
		actions.moveToElement(oHorizontalSlider, dHorizontalRange1, 0).click();
		HeroKUAppHorizontalSlider_DataProvider.test.log(LogStatus.PASS, "Set the slider to " +dHorizontalRange1+ 
				" value");
		actions.build().perform();
		//Action action = (Action) actions.dragAndDropBy(oHorizontalSlider, 0, (int) dHorizontalRange).build();
		//action.perform();
		
//		actions.clickAndHold(oHorizontalSlider);
//		actions.moveByOffset(10, 0);
//		actions.release().build();
	}
}
