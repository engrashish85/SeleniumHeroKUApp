package Module9_TestNG;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HeroKUAppIFrames_DataDriver extends Selenium_WorkingWithDriver_TestNG {

	By oFrameLinkText = By.linkText("Frames");
	By oIFrameLinkText = By.linkText("iFrame");
	By oIFrameXPath = By.xpath("//body[@id='tinymce'][@contenteditable='true']");

	@BeforeTest
	public void setPrerequisitesForTestNG () {
		System.out.println("Entered BeforeTest");
	}

	@BeforeMethod
	public void RefreshPage () {
		List<WebElement> oFrameLinks = driver.findElements(oFrameLinkText);
		if (oFrameLinks.isEmpty()) {
			driver.navigate().refresh();
		}
		else {
			WebElement oFrameLink = driver.findElement(oFrameLinkText);
			oFrameLink.click();
			WebElement oIFrameLink = driver.findElement(oIFrameLinkText);
			oIFrameLink.click();
		}
	}

	//	@Test(dataProvider="returnDataFromDataProvider", dataProviderClass = GetDataFromDataProvider.class)
	@Test(dataProvider = "returnDataThroughDataProvider")
	public void typeInEditor (String sTestCaseID, String sRun, String sTextToType, String sSpecialEffects) {

		//Retrieving generic value from Properties file for special effects xPath
//		String sSpecialEffectsXPath = "";
		String sSpecialEffectsCSS = "";

		try {
//			sSpecialEffectsXPath = returnValueFromPropertiesFile("sIFramesSpecialEffectsXPath");
			sSpecialEffectsCSS = returnValueFromPropertiesFile("sIframesSpecialEffectsCSS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Properties File not found");
			e.printStackTrace();
		}

		//Clearing the text in frame
		driver.switchTo().frame(0);
		WebElement oIFrame = driver.findElement(oIFrameXPath);
		oIFrame.clear();

		//Splitting sTextToType and sSpecialEffects to type text in Editor with different special effects
		String[] arrTextToType = sTextToType.split(";");
		String[] arrSpecialEffects = sSpecialEffects.split(";");

		//Initializing oButton
		WebElement oButton;

		for (int i = 0; i < arrTextToType.length; i ++) {

			//Selecting text special effects
			driver.switchTo().defaultContent();
//			switch (arrSpecialEffects [i])
//			{
//				case "B" :
//					By oBoldButtonXPath = By.xpath(sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-bold"));
//					WebElement oBoldButton = driver.findElement(oBoldButtonXPath);
//					oBoldButton.click();
//					oButton = oBoldButton;
//					break;
//				case "I" :
//					By oItalicButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-italic"));
//					WebElement oItalicButton = driver.findElement(oItalicButtonXPath);
//					oItalicButton.click();
//					oButton = oItalicButton;
//					break;
//				case "Align-left" :
//					By oAlignLeftButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignleft"));
//					WebElement oAlignLeftButton = driver.findElement(oAlignLeftButtonXPath);
//					oAlignLeftButton.click();
//					oButton = oAlignLeftButton;
//					break;
//				case "Align-center" :
//					By oAlignCenterButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-aligncenter"));
//					WebElement oAlignCenterButton = driver.findElement(oAlignCenterButtonXPath);
//					oAlignCenterButton.click();
//					oButton = oAlignCenterButton;
//					break;
//				case "Align-right" :
//					By oAlignRightButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignright"));
//					WebElement oAlignRightButton = driver.findElement(oAlignRightButtonXPath);
//					oAlignRightButton.click();
//					oButton = oAlignRightButton;
//					break;
//				case "Justify" :
//					By oJustifyButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-alignjustify"));
//					WebElement oJustifyButton = driver.findElement(oJustifyButtonXPath);
//					oJustifyButton.click();
//					oButton = oJustifyButton;
//					break;
//				case "Bullet-List" :
//					By oBulletListButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-bullist"));
//					WebElement oBulletListButton = driver.findElement(oBulletListButtonXPath);
//					oBulletListButton.click();
//					oButton = oBulletListButton;
//					break;
//				case "Numbered-List" :
//					By oNumberedListButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-numlist"));
//					WebElement oNumberedListButton = driver.findElement(oNumberedListButtonXPath);
//					oNumberedListButton.click();
//					oButton = oNumberedListButton;
//					break;
//				case "Decrease-Indent" :
//					By oDecreaseIndentButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-outdent"));
//					WebElement oDecreaseIndentButton = driver.findElement(oDecreaseIndentButtonXPath);
//					oDecreaseIndentButton.click();
//					oButton = oDecreaseIndentButton;
//					break;
//				case "Increase-Indent" :
//					By oInreaseIndentButtonXPath = By.xpath (sSpecialEffectsXPath.replace("<#@>", "mce-ico mce-i-indent"));
//					WebElement oInreaseIndentButton = driver.findElement(oInreaseIndentButtonXPath);
//					oInreaseIndentButton.click();
//					oButton = oInreaseIndentButton;
//					break;
//				default :
//					System.out.println("Invalid value found in special effects");
//					break;
//			}

			By oButtonCSS = By.cssSelector(sSpecialEffectsCSS.replace("<#@>", arrSpecialEffects[i]));
			oButton = driver.findElement(oButtonCSS);
			oButton.click();

			//Printing in console
			System.out.println("Special Effects Parameter called is - "+arrSpecialEffects [i]);

			//Switching driver to iFrame
			driver.switchTo().frame(0);

			//Typing in WSIWYG editor
			oIFrame.sendKeys(arrTextToType [i]);
			oIFrame.sendKeys(Keys.RETURN);

			//Switching driver to default content
			driver.switchTo().defaultContent();

			//Clicking on special effects button
			oButton.click();
		}

		//Waiting for 5 seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] returnDataThroughDataProvider () {
		GetDataFromDataProvider obGetDataFromDataProvider = new GetDataFromDataProvider ();
		Object[][] rowDataArray = obGetDataFromDataProvider.returnDataFromDataProvider
				("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur" +
								"\\src\\Module9_TestNG\\DataDriver\\DataDriver_IFrame_TinyMCE_WYSIWYG_Editor.xlsx",
						"IFrames_WYSIWYGEditor");
		for (Object[] objects : rowDataArray) {
			for (Object object : objects) {
				System.out.println(object + "	");
			}
		}
		return rowDataArray;
	}

	@AfterMethod
	public void RefreshPage1 () {
		System.out.println("Entered after method");
		WebDriverWait wait = new WebDriverWait (driver, 4);
		Boolean isNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(oFrameLinkText));
		if (isNotVisible) {
			System.out.println("Element not found");
			driver.navigate().refresh();
		}
		else {
			WebElement oFrameLink = driver.findElement(oFrameLinkText);
			oFrameLink.click();
			WebElement oIFrameLink = driver.findElement(oIFrameLinkText);
			oIFrameLink.click();
		}
	}

	@AfterTest
	public void afterTest () {
		System.out.println("This is a test");
	}
}
