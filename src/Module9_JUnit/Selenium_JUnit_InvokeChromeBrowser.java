package Module9_JUnit;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_JUnit_InvokeChromeBrowser {
	
	public static WebDriver driver;
	public static String sChromeDriverPath1 = "C:\\ashish\\Training\\Selenium\\Software\\WebDriver\\ChromeDriver\\chromedriver.exe";
	public static String sURL = "http://the-internet.herokuapp.com/";
	public String sBasicAuthURL = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList <String> sBrowserAttributes = Selenium_JUnit_InvokeChromeBrowser.InvokeChrome1(Selenium_JUnit_InvokeChromeBrowser.sURL);
		System.out.println("Title - "+sBrowserAttributes.get(0));
		System.out.println("URL - "+sBrowserAttributes.get(1));
		
		Selenium_JUnit_InvokeChromeBrowser.quitDriver1();
		
	}
	
	public static WebDriver getChromeDriver1 () {
		if (driver == null) {
			//Setting the Chrome driver and the Chrome driver path to invoke Chrome browser
			System.setProperty("webdriver.chrome.driver", sChromeDriverPath1);
			ChromeOptions options = new ChromeOptions ();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver (options);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			return driver;
			}
		else {
			return driver;
		}		
	}
	
	public static ArrayList <String> InvokeChrome1 (String sURL) {
		
		//Returning driver through the function
		driver = getChromeDriver1 ();
		
		//Navigating to sURL as given in the argument
		driver.get(sURL);
		
		//Maximising the window
		driver.manage().window().maximize();
		
		//Giving implicit wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
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
	
	public static void quitDriver1 () {
		
		//Quitting driver
		driver = getChromeDriver1();
		System.out.println("Quit called - "+driver.getCurrentUrl());
		driver.quit();
	}
}
