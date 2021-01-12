package Module9_PageFactoryImplementation;

import Module9.Selenium_InvokeChromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;

public class HeroKUAppFileUpload extends Selenium_InvokeChromeBrowser {
	
	//Instantiating objects
	By oFileUploadLink = By.linkText("File Upload");
	By oChooseFileButton = By.id("file-upload");
	By oUploadButton = By.cssSelector("input#file-submit");
	By oConfirmationMessage = By.xpath("//h3[text()='File Uploaded!!!!']");
	
	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		
		//Instantiating driver
		Selenium_InvokeChromeBrowser ob = new Selenium_InvokeChromeBrowser ();

		//Invoking URL in chrome browser
		ob.InvokeChrome(ob.sURL);
		
		//Instantiating objects
		HeroKUAppFileUpload obHeroKUAppFileUpload = new HeroKUAppFileUpload ();
		
		//Clicking on File Upload link
		driver.findElement(obHeroKUAppFileUpload.oFileUploadLink).click();
		
		//Clicking on Choose File button
//		driver.findElement(obHeroKUAppFileUpload.oChooseFileButton).click();

		String sImagePath = "C:\\ashish\\Images\\Whats app\\WhatsApp Images\\Random\\Good Morning\\FileUpload.jpg";

		driver.findElement(obHeroKUAppFileUpload.oChooseFileButton).sendKeys(sImagePath);

//		String sFileUploadTextBoxPath = "C:\\ashish\\study material\\Selenium\\HeroKUApp\\File Upload\\TextFile.png";
//		String sOpenButtonPath = "C:\\ashish\\study material\\Selenium\\HeroKUApp\\File Upload\\OpenButton.png";

//		//Waiting for 5000 seconds
//		Thread.sleep(5000);
//
//		//Entering name of file to be downloaded
//		Screen s = new Screen ();
//		Pattern oFileUpload = new Pattern (sFileUploadTextBoxPath);
//		s.wait(oFileUpload, 4000);
//		s.type(oFileUpload, sImagePath);
//		Pattern oOpenButton = new Pattern (sOpenButtonPath);
//		s.wait(oOpenButton, 4000);
//		s.click(oOpenButton);

		driver.findElement(obHeroKUAppFileUpload.oUploadButton).click();

		try {
			driver.findElement(obHeroKUAppFileUpload.oConfirmationMessage).isDisplayed();
			System.out.println("A confirmation message is displayed successfully");
		} catch (NoSuchElementException e) {
			System.out.println("A confirmation message is NOT displayed successfully");
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(obHeroKUAppFileUpload.oConfirmationMessage));
			System.out.println("A confirmation message is displayed successfully");
		} catch (Exception e) {
			System.out.println("A confirmation message is NOT displayed successfully");
		}

		//Quitting driver
		ob.quitDriver();

	}

}
