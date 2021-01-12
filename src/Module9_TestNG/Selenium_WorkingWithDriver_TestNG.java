package Module9_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Test;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Selenium_WorkingWithDriver_TestNG {
	
	public static WebDriver driver;
	public String sChromeDriverPath = "C:\\ashish\\Training\\Selenium\\Software\\WebDriver\\ChromeDriver\\chromedriver.exe";
	public String sURL = "http://the-internet.herokuapp.com/";
	public String sURL_GeoLocation = "https://the-internet.herokuapp.com/geolocation";
	
	//Initializing extent Reports objects
	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static String sCurrentClassName;
	public static String sProjectPath;

	public void validateTextOnPage (String sText) {
		
		//Returning driver
		driver = getChromeDriver();
		
		//Creating a list of elements matching with the xpath containing corresponding text on page given as argument
		List <WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(), '" + sText + "')]"));
		
//		//Making a wait object (Explicit wait)
//		WebDriverWait wait =  new WebDriverWait (driver, 20);
//		
//		//Waiting for 20 seconds to check if the element is available inside 20 seconds
//		wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
//				
		//Printing that element is contained if list size is !=0 else printing that element is not contained in the page
		if (elementList.size()!= 0) {
			System.out.println("The text - "+sText+ " is contained in the page");
		}
		else {
			System.out.println("The text - "+sText+ " is NOT contained in the page");
		}	
	}
	
	
	public List <WebElement> assembleObjectsIntoArrayList (String sObjectType){
		
		//Returning driver
		driver = getChromeDriver();
		
		//Retrieving list of elements containing tag name as sObjectType given as an argument
		List <WebElement> elementList = driver.findElements(By.tagName(sObjectType));
		
		//Retrieving size of elements in a variable
		int iElementListSize = elementList.size();
		
		//Printing size of elements in console
		System.out.println("Size of list is - "+iElementListSize);
		
		//Printing on console that list is not empty is iElementListSize is >0 else printing that list is empty
		if (iElementListSize > 0) {
			System.out.println("Element List is NOT empty");
		}
		else {
			System.out.println("Element List is empty");
		}
		
		//Returning list of elements through the method
		return elementList;
	 }
	
	public void clickElementOnPage (By elementObject) {
		
		//Retrieving driver
		driver = getChromeDriver();
		
		//Initializing bElementFlag to False
		boolean bElementFlag = false;
		
		//Validate whether the element is present on the page or not
		if ((driver.findElements(elementObject).size()) > 0) {
			
			//Validate whether the element is displayed on the page or not
			if (driver.findElement(elementObject).isDisplayed()) {
				
				//Validate whether the object is enabled or disabled
				if (driver.findElement(elementObject).isEnabled()) {
					System.out.println("Object is visible on page and enabled");
					bElementFlag = true;
					driver.findElement(elementObject).click();
				}
					
			}
		
		}
		
		if (bElementFlag == false) {
			System.out.println("Object is either NOT found or NOT enabled or NOT visible on the page");
		}
	
	}
	
	
	public void validateElementOnPage (WebElement elementObject) {
		
		//Retrieving driver
		driver = getChromeDriver();
		
		//Making a wait object (Explicit wait)
		WebDriverWait wait =  new WebDriverWait (driver, 20);
		
		//Initializing bElementFlag to False
		boolean bElementFlag = false;
		
		//Waiting for 20 seconds to check if the element is available inside 20 seconds
		wait.until(ExpectedConditions.visibilityOf(elementObject));
		
		//Validate whether the element is displayed on the page or not
		if (elementObject.isDisplayed()) {
			
			System.out.println("Element " + elementObject + " is displayed on the page");
				
			//Validate whether the object is enabled or disabled
			if (elementObject.isEnabled()) {
				System.out.println("Object " + elementObject + " is enabled here");
				bElementFlag = true;
			}
					
		}
		
		if (bElementFlag == false) {
			System.out.println("Object " + elementObject + "is either NOT found or NOT enabled or NOT visible on the page");
		}
	
	}
	
	public String returnValueFromPropertiesFile (String key) throws IOException {
		Properties prop = new Properties ();
		FileInputStream oFile = new FileInputStream("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9\\Config\\ObjectRepository.Properties");
		prop.load(oFile);
		String value = prop.getProperty(key);
		return value;
	}
	
	public String returnValueFromXMLReader (String key) throws DocumentException {
		File InputFile = new File ("C:\\ashish\\Training\\Selenium\\Web Driver\\SeleniumTraining_AshishThakur\\src\\Module9\\Config\\ObjectRepository.xml");
		SAXReader saxReader = new SAXReader ();
		Document document = saxReader.read(InputFile);
		String sValue = document.selectSingleNode(key).getText();
		System.out.println("Value from xml reader is - "+sValue);
		return sValue;
	}
	
	public WebDriver getChromeDriver () {
		if (driver == null) {
			//Setting the Chrome driver and the Chrome driver path to invoke Chrome browser
			System.setProperty("webdriver.chrome.driver", sChromeDriverPath);
			ChromeOptions options = new ChromeOptions ();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver (options);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public ArrayList <String> InvokeChrome (String sURL) {
		
		//Returning driver through the function
		driver = getChromeDriver ();
		
		//Navigating to sURL as given in the argument
		driver.get(sURL);
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Giving implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Retrieving browser title and current URL in variables and printing the same in console
		String sTitle = driver.getTitle();
		String sCurrentURL = driver.getCurrentUrl();
		System.out.println("Browser title is - "+sTitle);
		System.out.println("Browser current URL is - "+sCurrentURL);
		
		//Initializing browserAttributes ArrayList and adding sTitle and sCurrentURL to the 1st and 2nd position of arraylist
		ArrayList <String> arrayBrowserAttributes = new ArrayList <String> (2);
		arrayBrowserAttributes.add(0, sTitle);
		arrayBrowserAttributes.add(1, sCurrentURL);
		
		//Returning browserAttributes ArrayList through the function
		return arrayBrowserAttributes;
	}
	
	@BeforeClass
	public void InvokeHeroInternetAppInChrome () {
		System.out.println("Entered BeforeClass");
		InvokeChrome (sURL);
	}
	
	@AfterClass
	public void AfterClassInheritanceTest () {
		
		//Printing message to console that method is called
		System.out.println("AfterClassInheritanceTest called");
		
		//Closing and quitting driver
		System.out.println("Entered AfterClass");
		System.out.println("Closing browser");
		driver.close();
		System.out.println("Quitting driver");
		driver.quit();
	
	}
	
	public <Key, Value> Key getKey(HashMap<Key, Value> hashmap, Value value) {
		for (Key key:hashmap.keySet()) {
			if (value.equals(hashmap.get(key))) {
				return key;
			}
		}
		return null;
	}
	
	public String retrieveFrameworkPath () {
		
		String sFullPath = "";
		String sFrameWorkPath = this.getClass().getClassLoader().getResource("").getPath();
		String sPackageName = this.getClass().getPackage().getName();
		System.out.println("Package name is - "+sPackageName);
		System.out.println("path is - "+sFrameWorkPath);
		try {
			sFullPath = URLDecoder.decode(sFrameWorkPath, "UTF-8");
			System.out.println("Full Path is - "+sFullPath);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
//		System.out.println("root path is - "+root);
//		
//		Path main = Paths.get(root.toString(), "src", "main", "resources");
//		System.out.println("main path is - "+main);
		
		Path root1 = Paths.get(".").normalize().toAbsolutePath();
		System.out.println("Path root1 is - "+root1);
		String sRootPath = String.valueOf(root1);
		
//		String envRootDirectory = System.getProperty("user.dir");
//		System.out.println("envRootDirectory - "+envRootDirectory);
//		
//		String className = this.getClass().getSimpleName();
//		System.out.println("className is - "+className);
//		
//		String strClassPath = System.getProperty("java.class.path");
//		System.out.println("strClassPath is - "+strClassPath);
//		
//		String sResource = className+".java";
//		File currentFile = new File(sPackageName + "/" + sResource);
//		String sClassPath = currentFile.getAbsolutePath();
//		System.out.println("classPath is -"+sClassPath);
//		
//		ClassLoader loader = Test.class.getClassLoader();
//		System.out.println(loader.getResource(sPackageName + "/" + sResource));
		
		return sRootPath;
				
	}
	
	public String screenCapture (WebDriver driver, String sCurrentClassName) throws IOException {
		
//		//Retrieving project path
//		String sProjectPath = retrieveFrameworkPath ();
		
		//Retrieving current date and formatting in "yyyyMMdd" format
		Date date = new Date ();
		DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		String sDate = dateFormat.format(date); 
		
		//Capturing the screenshot of the current webdriver instance and storing it in the form of file and doing
		//type casting of webdriver to take the screenshot which is necessary
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Creating a folder named screenshots, date and class name inside Extent Reports and storing the file 
		//name with the current system time
		File destFile = new File (sProjectPath + "\\test-output\\Extent Reports\\" + sDate + "\\Screenshots\\" + 
				sCurrentClassName + "\\" + System.currentTimeMillis() + ".png");
		
		//Retrieving the absolute path of the destination path
		String sScreenshotPath = destFile.getAbsolutePath();
		
		//Copying the file from source to destination
		FileUtils.copyFile(srcFile, destFile);
		
		//Returning the path of screenshot through function
		return sScreenshotPath;
		
	}
	
	public void onMouseHoverOnElement (WebElement oElement) {
		
		Actions actions = new Actions (driver);
		actions.moveToElement(oElement);
		actions.build().perform();
	
	}
	
	public Boolean checkVisibilityOfElement (WebElement element) {
		
		WebDriverWait wait = new WebDriverWait (driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch (Exception e) {
			return false;
			
		}
	}
	
	public void scrollPage (int iXCoordinate, int iYCoordinate) throws IOException {
		
		//Retrieving current class Name
		sCurrentClassName = this.getClass().getName();
		
		//Executing java script statement
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
//		//Executing scrollTo Statement
//		jse.executeScript("window.scrollTo (0, 100)", "");
//		
//		//Reporting results to extent reports
//		test.log(LogStatus.INFO, screenCapture(driver, sCurrentClassName) + "Executing scrollTo statement");
//		
//		//Executing scrollBy statement
//		jse.executeScript("window.scrollBy (0, 100)", "");
//		
//		//Reporting results to extent reports
//		test.log(LogStatus.INFO, screenCapture(driver, sCurrentClassName) + "Executing scrollBy statement");
		
		//Defining java script scroll statement
		String sJavaScriptScollStatement = "window.scrollBy ("+iXCoordinate+ "," + iYCoordinate + ")";
		
		//Executing java script scroll statement
		jse.executeScript(sJavaScriptScollStatement, "");
				
	}
	
}
