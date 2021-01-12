package Module9_PageFactoryImplementation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;

public class HeroKUAppWelcomePage extends Selenium_InvokeChromeBrowser {
	
	@FindBy(how=How.LINK_TEXT, using = "Broken Images") 
	public WebElement oLinkBrokenImages;
	
	@FindBy(how=How.XPATH, using = "//img[@src='asdf.jpg']")
	public WebElement oImageASDF;
	
	@FindBy (how = How.TAG_NAME, using = "img")
	public List <WebElement> oImages;
	
	public static void main(String[] args) throws IOException {
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();
		driver = ob.getChromeDriver ();
		
		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
				
		//Instantiating page objects using PageFactory
		HeroKUAppWelcomePage obHeroKUAppWelcomePage = PageFactory.initElements(driver, HeroKUAppWelcomePage.class);
		
		//Clicking on Broken Images Link and validating whether image is displayed
		obHeroKUAppWelcomePage.validateImage(obHeroKUAppWelcomePage.oImageASDF);
		
		//Retrieving broken images on the page
		obHeroKUAppWelcomePage.validateBrokenImages1(obHeroKUAppWelcomePage.oImages);
	
	}
	
	public void validateImage (WebElement imgObject) {
		oLinkBrokenImages.click();
		
		Selenium_WorkingWithDriver obSeleniumWorkingWithDriver = new Selenium_WorkingWithDriver();
		obSeleniumWorkingWithDriver.validateElementOnPage(imgObject);
		
	}
	
	public void validateBrokenImages (List<WebElement> oImages) throws IOException {
		int brokenImagesCount = 0;
		for (WebElement element: oImages) {
			String sImageURL = element.getAttribute("src");
			System.out.println("Image URL is - "+sImageURL);
			
			//Creating an object of URL class
			URL url = new URL (sImageURL);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setConnectTimeout(20000);
			http.setReadTimeout(10000);
			int iStatusCode = http.getResponseCode();
			if (iStatusCode==404||iStatusCode==500) {
				brokenImagesCount = brokenImagesCount + 1;
				System.out.println("Broken Image is - "+sImageURL);
			}
		}
		
		System.out.println("Total broken images count is - "+brokenImagesCount);
	}
	
	
	public void validateBrokenImages1 (List<WebElement> oImages) throws IOException {
		int brokenImagesCount = 0;
		for (WebElement element: oImages) {
			String sImageURL = element.getAttribute("src");
			System.out.println("Image URL is - "+sImageURL);
			
			if (element.getAttribute("naturalWidth").equals("0")) {
				brokenImagesCount = brokenImagesCount + 1;
				System.out.println("Broken image is - "+sImageURL);
			}
		}
		
		System.out.println("Total broken images count is - "+brokenImagesCount);
	}

}
