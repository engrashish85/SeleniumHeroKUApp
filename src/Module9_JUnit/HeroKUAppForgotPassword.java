package Module9_JUnit;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HeroKUAppForgotPassword extends Selenium_JUnit_InvokeChromeBrowser {
	
	@FindBy (how = How.LINK_TEXT, using = "Forgot Password")
	public WebElement oForgotPasswordLink;
	
	@FindBy (how = How.ID, using = "email")
	public WebElement oEmailIdInputBox;
	
	@FindBy (how = How.XPATH, using = "//button[@id='form_submit']/i")
	public WebElement oRetrievePasswordButton;
	
	@FindBy (how = How.LINK_TEXT, using = "Form Authentication")
	public WebElement oFormAuthenticationLink;
	
	@FindBy (how = How.XPATH, using = "//input[@type='text'][@id='username']")
	public WebElement oFormAuthenticationUserName;
	
	@FindBy (how = How.XPATH, using = "//input[@type='password'][@id='password']")
	public WebElement oFormAuthenticationPassword;
	
	@FindBy (how = How.XPATH, using = "//button[@type='submit']/i")
	private WebElement oLoginButton;
	
	@BeforeClass
	public static void openBrowserAndInitializeDriver () {
		
		//Returning driver
		driver = getChromeDriver1 ();
		
		//Invoking URL in chrome browser
		InvokeChrome1(sURL);
	
	}
	
	//@Test
	public void forgotPassword () {
		
		//Initializing elements using page factory
		HeroKUAppForgotPassword obHeroKUAppForgotPassword = PageFactory.initElements(driver, HeroKUAppForgotPassword.class);
		
		//Retrieving the heading text
		String sHeadingText = obHeroKUAppForgotPassword.oForgotPasswordLink.getText();
		
		//Printing heading text to console
		System.out.println("Heading text is - "+sHeadingText);
				
		//Clicking on 'Forgot Password' link
		obHeroKUAppForgotPassword.oForgotPasswordLink.click();
		
		//Printing xpath to console
		System.out.println("xpath is - "+"//h2[text()='"+sHeadingText+"']");
		
		//Retrieving the heading text
		List <WebElement> oHeading = driver.findElements(By.xpath("//h2[text()='"+sHeadingText+"']"));
		
		//Validating whether the heading is same as link
		if (oHeading.size() > 0) {
			System.out.println("Heading "+ sHeadingText + " is displayed on the page");
		}
		else {
			System.out.println("Heading "+ sHeadingText + " is NOT displayed on the page");
		}
		
		//Entering email id and clicking on 'Retrieve Password' button
		obHeroKUAppForgotPassword.oEmailIdInputBox.sendKeys("engr.ashish@gmail.com");
		obHeroKUAppForgotPassword.oRetrievePasswordButton.click();
		
		//Validate whether the confirmation text saying email has been sent is displayed or not
		if (driver.getPageSource().contains("Your e-mail's been sent!")) {
			System.out.println("The corresponding text is contained in the page");
		}
	
	}
	
	@Test
	public void formAuthentication () {
		
		//Initializing elements using page factory
		HeroKUAppForgotPassword obHeroKUAppForgotPassword = PageFactory.initElements(driver, HeroKUAppForgotPassword.class);
		
		//Retrieving the heading text
		String sHeadingText = obHeroKUAppForgotPassword.oFormAuthenticationLink.getText();
		System.out.println("Heading text is - "+sHeadingText);
		
		//Printing heading text to console
		System.out.println("Heading text is - "+sHeadingText);
				
		//Clicking on 'Forgot Password' link
		obHeroKUAppForgotPassword.oFormAuthenticationLink.click();
				
		//Retrieving the heading text
		List <WebElement> oHeading = driver.findElements(By.xpath("//h2[text()='"+sHeadingText+"']"));
		
		//Validating whether the heading is same as link
		if (oHeading.size() > 0) {
			System.out.println("Heading "+ sHeadingText + " is displayed on the page");
		}
		else
		{
			System.out.println("Heading "+ sHeadingText + " is NOT displayed on the page");
		}
		
		//Entering user name and password and clicking on Login button
		System.out.println("Entering Login Details");
		obHeroKUAppForgotPassword.oFormAuthenticationUserName.sendKeys("tomsmith");
		obHeroKUAppForgotPassword.oFormAuthenticationPassword.sendKeys("SuperSecretPassword!");
		obHeroKUAppForgotPassword.oLoginButton.click();
	}
	
//	@AfterClass
//	public static void quitDriver1 () {
//		System.out.println("Closing browser");
//		driver.close();
//		driver.quit();
//		System.out.println("Quitting driver");
//	}
	
}
