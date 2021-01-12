package Module9_TestNG;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HeroKUAppIFrames_Parameters extends Selenium_WorkingWithDriver_TestNG {
	
//	@FindBy(how=How.LINK_TEXT, using = "Frames")
//	public WebElement oFrameLink;
//	
//	@FindBy(how=How.LINK_TEXT, using = "iFrame")
//	public WebElement oIFrameLink;
//	
//	@FindBy(how=How.XPATH, using = "//iFrame[@id='mce_0_ifr']")
//	public WebElement oIFrame;
	
	By oFrameLinkText = By.linkText("Frames");
	By oIFrameLinkText = By.linkText("iFrame");
	By oIFrameXPath = By.xpath("//body[@id='tinymce'][@contenteditable='true']");
	
	@BeforeTest
	public void setPrerequisitesforTestNG () {
		System.out.println("Entered BeforeTest");	
	}
	
	@BeforeMethod
	public void RefreshPage () throws InterruptedException {
		
		WebElement oFrameLink = driver.findElement(oFrameLinkText);
		if (!oFrameLink.isDisplayed()) {
			driver.navigate().refresh();
		}
		else {
			oFrameLink.click();			
			WebElement oIFrameLink = driver.findElement(oIFrameLinkText);
			oIFrameLink.click();
		}
	}
	
	@Test
	@Parameters ({"sTextToType", "sSpecialEffects"})
	public void typeInEditor (int sTextToType, @Optional("Justify") String sSpecialEffects) throws IOException {
		
		String sSpecialEffectsXPath = returnValueFromPropertiesFile("sIFramesSpecialEffectsXPath");
		driver.switchTo().frame(0);
		WebElement oIFrame = driver.findElement(oIFrameXPath);
		
		driver = getChromeDriver();
//		PageFactory.initElements(driver, HeroKUAppIFrames.class);
		oIFrame.clear();
		
		driver.switchTo().defaultContent();
		switch (sSpecialEffects)
		{
			case "B" :
				By oBoldButtonXPath = By.xpath(sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-bold"));
				WebElement oBoldButton = driver.findElement(oBoldButtonXPath);
				oBoldButton.click();
				break;
			case "I" :
				By oItalicButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-italic"));
				WebElement oItalicButton = driver.findElement(oItalicButtonXPath);
				oItalicButton.click();
				break;
			case "Align-left" :
				By oAlignLeftButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignleft"));
				WebElement oAlignLeftButton = driver.findElement(oAlignLeftButtonXPath);
				oAlignLeftButton.click();
				break;
			case "Align-center" :
				By oAlignCenterButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-aligncenter"));
				WebElement oAlignCenterButton = driver.findElement(oAlignCenterButtonXPath);
				oAlignCenterButton.click();
				break;
			case "Align-right" :
				By oAlignRightButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignright"));
				WebElement oAlignRightButton = driver.findElement(oAlignRightButtonXPath);
				oAlignRightButton.click();
				break;
			case "Justify" :
				By oJustifyButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignjustify"));
				WebElement oJustifyButton = driver.findElement(oJustifyButtonXPath);
				oJustifyButton.click();
				break;
			case "Bullet-List" :
				By oBulletListButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-bullist"));
				WebElement oBulletListButton = driver.findElement(oBulletListButtonXPath);
				oBulletListButton.click();
				break;
			case "Numbered-List" :
				By oNumberedListButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-numlist"));
				WebElement oNumberedListButton = driver.findElement(oNumberedListButtonXPath);
				oNumberedListButton.click();
				break;
			case "Decrease-Indent" :
				By oDecreaseIndentButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-outdent"));
				WebElement oDecreaseIndentButton = driver.findElement(oDecreaseIndentButtonXPath);
				oDecreaseIndentButton.click();
				break;
			case "Increase-Indent" :
				By oInreaseIndentButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-indent"));
				WebElement oInreaseIndentButton = driver.findElement(oInreaseIndentButtonXPath);
				oInreaseIndentButton.click();
				break;
			default :
				System.out.println("Invalid value found in speciel effects");
				break;
		}
		System.out.println("Special Effects Parameter called is - "+sSpecialEffects);
		driver.switchTo().frame(0);
		for (int i = 1; i<=5; i ++) {
			oIFrame.sendKeys(Integer.toString(sTextToType));
			oIFrame.sendKeys(Keys.RETURN);
		}
		
	}
	
//	@AfterMethod
//	public void RefreshPage1 () throws InterruptedException {
//		
//		List<WebElement> oFrameLinkList = driver.findElements(oFrameLinkText);
//		int oFrameLinkListNumber = oFrameLinkList.size();
//		System.out.println(oFrameLinkListNumber);
//		//WebElement oFrameLink = driver.findElement(oFrameLinkText);
//		//if (!oFrameLink.isDisplayed()) {
//		if (oFrameLinkListNumber == 0) {
//			driver.navigate().refresh();
//		}
//		else {
//			WebElement oFrameLink = driver.findElement(oFrameLinkText);
//			oFrameLink.click();			
//			WebElement oIFrameLink = driver.findElement(oIFrameLinkText);
//			oIFrameLink.click();
//		}
//	}
	
	@AfterTest
	public void afterTest () {
		System.out.println("This is a test");
	}
}
