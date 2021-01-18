package Module9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_InvokeChromeBrowser {
	
	public static WebDriver driver;
	public String sChromeDriverPath = "C:\\ashish\\Training\\Selenium\\Software\\WebDriver\\ChromeDriver\\chromedriver.exe";
	public String sURL = "http://the-internet.herokuapp.com/";
	public String sBasicAuthURL = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
	public String sGuru99URL = "http://demo.guru99.com/popup.php";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Creating an object reference of class
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		
		ArrayList <String> sBrowserAttributes = ob.InvokeChrome(ob.sURL);
		System.out.println("Title - "+sBrowserAttributes.get(0));
		System.out.println("URL - "+sBrowserAttributes.get(1));
		
		ob.quitDriver();
		
	}
	
	public WebDriver getChromeDriver () {
		if (driver == null) {

			//Setting the Chrome driver and the Chrome driver path to invoke Chrome browser
			System.setProperty("webdriver.chrome.driver", sChromeDriverPath);
			ChromeOptions options = new ChromeOptions ();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");

			//Setting download preferences in chrome browser
			Map<String, Object> downloadPreferences = new HashMap<>();
			downloadPreferences.put("download.default_directory", "//users//Ashish//downloads");
			downloadPreferences.put("safebrowsing.enabled", "false");
			downloadPreferences.put("profile.default_content_setting_values.automatic_downloads", 1);
			downloadPreferences.put("profile.default_content_settings.popups", 0);
			options.setExperimentalOption("prefs", downloadPreferences);

			//Setting chrome driver options
			driver = new ChromeDriver (options);

			//Implicit wait
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		}
		return driver;
	}
	
	public ArrayList <String> InvokeChrome (String sURL) {
		
		//Returning driver through the function
		driver = getChromeDriver ();
		
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
	
	public void quitDriver () {
		
//		//Quitting driver
//		driver = getChromeDriver();
		System.out.println("Quit called - "+driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}
}
