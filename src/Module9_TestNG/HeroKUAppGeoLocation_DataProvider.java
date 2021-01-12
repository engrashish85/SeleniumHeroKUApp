package Module9_TestNG;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Module9_PageObjectModel.HeroKUAppGeoLocationPage;
import Module9_PageObjectModel.HeroKUAppMainPage;

public class HeroKUAppGeoLocation_DataProvider extends Selenium_WorkingWithDriver_TestNG  {
	
	@BeforeTest
	public void setPrerequisitesforTestNG () {
		System.out.println("Entered BeforeTest");	
	}
	
	@Test(dataProvider="returnDataThroughDataProvider")
	public void validateGeoLocationValues (String sTestCaseID, String sRun, String sTextToType, 
			String sSpecialEffects) {
		
		HeroKUAppMainPage obHeroKUAppMainPage = PageFactory.initElements(driver, HeroKUAppMainPage.class);
		obHeroKUAppMainPage.clickGeoLocationLink();
		
		HeroKUAppGeoLocationPage obHeroKUAppGeoLocationPage = PageFactory.initElements(driver, 
					HeroKUAppGeoLocationPage.class);
		String[] arrayGeoLocationValues = new String[2];
		arrayGeoLocationValues = obHeroKUAppGeoLocationPage.retrieveGeoLocationValues();
		for (int i = 0; i < arrayGeoLocationValues.length; i ++) {
			System.out.println("arrayGeoLocationValues - "+arrayGeoLocationValues[i]);
		}
		obHeroKUAppGeoLocationPage.ValidateGeolocationValues(arrayGeoLocationValues);	
	
	}
	
	@DataProvider
	public Object[][] returnDataThroughDataProvider () {
		GetDataFromDataProvider obGetDataFromDataProvider = new GetDataFromDataProvider ();
		Object[][] rowDataArray = obGetDataFromDataProvider.returnDataFromDataProvider 
			("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9_TestNG\\DataDriver\\DataDriver_IFrame_TinyMCE_WYSIWYG_Editor.xlsx", "IFrames_WYSIWYGEditor");
		for (int i = 0; i < rowDataArray.length; i ++) {
			for (int j = 0; j < rowDataArray [i].length; j ++) {
				System.out.println(rowDataArray[i][j] + "	");
			}
		}
		return rowDataArray;
	}
	
	@AfterTest
	public void afterTest () {
		System.out.println("This is a test");
	}
	
}
