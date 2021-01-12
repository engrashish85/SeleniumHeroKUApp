package Module9_TestNG;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Module9_PageObjectModel.HeroKUAppGeoLocationPage;
import Module9_PageObjectModel.HeroKUAppHorizontalSliderPage;
import Module9_PageObjectModel.HeroKUAppMainPage;

public class HeroKUAppHorizontalSlider_DataProvider extends Selenium_WorkingWithDriver_TestNG  {
	
	//Initializing extent Reports objects
	public static ExtentReports extentReport;
	public static ExtentTest test;
	
	//Retrieving current class name
	String sCurrentClassName = this.getClass().getName();
	
	@BeforeTest
	public void setPrerequisitesforTestNG () {
		System.out.println("Entered BeforeTest");	
	}
	
	@BeforeMethod
	public void clickHorizontalSliderLink () throws IOException {
		
		//Retrieving the date in the format of yyyyMMdd
		DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Date date = new Date ();
		String sDate = dateFormat.format(date);
		System.out.println("Date is - "+sDate);
		
		//Retrieving Framework path
		Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG();
		String sProjectPath = obSelenium_WorkingWithDriver_TestNG.retrieveFrameworkPath();
		
		//Making Extent Reports object and giving the input as the path where reports are to be stored
		extentReport = new ExtentReports (sProjectPath + "\\test-output\\Extent Reports\\" + sDate + "\\" + 
				sCurrentClassName + ".html", false);
		
		//Printing path of extent report results in console
		System.out.println("Starting extent reports and reports stored in - "
				+sProjectPath + "\\test-output\\Extent Reports\\" + sDate);
		
		//Starting test with name of report as class name
		test = extentReport.startTest(String.valueOf(this.getClass().getName()));
		
		//Printing to console
		System.out.println("Entered Before Method");
		
		//Clicking on Horizontal Slider link
		HeroKUAppMainPage obHeroKUAppMainPage = PageFactory.initElements(driver, HeroKUAppMainPage.class);
				
		//Retrieving the list size and printing the same to extent report and console
		int iHorizontalSliderSize = obHeroKUAppMainPage.retrieveListSize (obHeroKUAppMainPage.oHorizontalSliders);
		test.log(LogStatus.INFO, "Horizontal Slider links size is - "+iHorizontalSliderSize);
		System.out.println("oHorizontalSliderSize - "+iHorizontalSliderSize);
		
		//Clicking on the link if present else refreshing the page
		if (iHorizontalSliderSize > 0) {
			obHeroKUAppMainPage.oHorizontalSliders.get(0).click();
			test.log(LogStatus.INFO, test.addScreenCapture(obSelenium_WorkingWithDriver_TestNG.screenCapture(driver, sCurrentClassName)) + "Clicked on Horizontal Slider link");
		}
		else {
			
			//Refreshing the page
			driver.navigate().refresh();
			
			//Reporting event in extent report
			test.log(LogStatus.INFO, "Refreshing the Page");
			
			//Reporting to console
			System.out.println("Horizontal Slider link not found");
		
		}
	
	}
	
	@Test(dataProvider="returnDataThroughDataProvider")
	public void clickHorizontalSlider (String sTestCaseID, String sRun, String sHorizontalSliderValue) throws IOException {
		
		Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG();
		
		//Printing data to console
		System.out.println("Entered test method");
		
		//Initializing elements though page factory
		HeroKUAppHorizontalSliderPage obHeroKUAppHorizontalSliderPage = PageFactory.initElements(driver, 
				HeroKUAppHorizontalSliderPage.class);
		
		//Setting the slider value as the value given in excel and capturing results in extent reports
		obHeroKUAppHorizontalSliderPage.setHorizontalSliderRange(sHorizontalSliderValue);
		test.log(LogStatus.PASS, test.addScreenCapture(obSelenium_WorkingWithDriver_TestNG.screenCapture(driver, sCurrentClassName)) + "Setting horizontal Slider range as - "+sHorizontalSliderValue);
		
	}
	
	@DataProvider
	public Object[][] returnDataThroughDataProvider () {
		
		//Retrieving framework path and concatenating the same with data provider excel path
		Selenium_WorkingWithDriver_TestNG obSelenium_WorkingWithDriver_TestNG = new Selenium_WorkingWithDriver_TestNG();
		String sProjectPath = obSelenium_WorkingWithDriver_TestNG.retrieveFrameworkPath();
		
		//Retrieving data into two dimensional array from data provider function
		GetDataFromDataProvider obGetDataFromDataProvider = new GetDataFromDataProvider ();
		Object[][] rowDataArray = obGetDataFromDataProvider.returnDataFromDataProvider (sProjectPath +
			"\\src\\Module9_TestNG\\DataDriver\\DataDriver_IFrame_TinyMCE_WYSIWYG_Editor.xlsx", "Horizontal_Slider");
		
		//Printing data retrieved into console
		for (int i = 0; i < rowDataArray.length; i ++) {
			for (int j = 0; j < rowDataArray [i].length; j ++) {
				System.out.println(rowDataArray[i][j] + "	");
			}
		}
		
		//Returning data through the function
		return rowDataArray;
	
	}
	
	@AfterMethod
	public void saveExtentReport () {
		extentReport.endTest(test);
		extentReport.flush();
	}
	
	@AfterTest
	public void afterTest () {
		
		//Printing data to console
		System.out.println("This is a test");
	}
	
}
