package Module9;

import Module9_TestNG.Selenium_WorkingWithDriver_TestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;

public class Selenium_SikuliImplementation extends Selenium_WorkingWithDriver {

//	@FindBy(how=How.LINK_TEXT, using = "Basic Auth")
//	public WebElement oLinkBasicAuth;

	@FindBy(how=How.XPATH, using="//p[contains(text(),'Congratulations! You must have the proper credentials.')]")
	public WebElement oBasicAuthConfirmationSuccessMessage;

	public static void main(String[] args) throws FindFailed {

		// TODO Auto-generated method stub

		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();
		driver = obDriver.getChromeDriver();
		obDriver.InvokeChrome(obDriver.sBasicAuthURL);

		Selenium_SikuliImplementation selenium_sikuliImplementation = PageFactory.initElements(driver,
				Selenium_SikuliImplementation.class);

		//Invoking URL in chrome browser
		Selenium_WorkingWithDriver_TestNG selenium_workingWithDriver_testNG = new Selenium_WorkingWithDriver_TestNG();
		selenium_workingWithDriver_testNG.validateElementOnPage(driver,
				selenium_sikuliImplementation.oBasicAuthConfirmationSuccessMessage);

		/*driver = obDriver.getChromeDriver();

		//Initiating pageFactory objects of Selenium_SikuliImplementation class
		Selenium_SikuliImplementation obSikuliImplementation = PageFactory.initElements(driver, Selenium_SikuliImplementation.class);
		obSikuliImplementation.oLinkBasicAuth.click();
		driver.switchTo().window("Sign in");

		System.out.println("Clicking on the link");
		String sImageFilePath = "C:/ashish/Training/Selenium/Sikuli";
		System.out.println("Entering sikuli line 31");
		Screen s = new Screen();
		Pattern userNameTextBox = new Pattern (sImageFilePath + "Username.png");
		System.out.println("Entering sikuli line 34");
		s.wait(userNameTextBox, 4);
		s.type(userNameTextBox, "admin");
		System.out.println("Entering sikuli line 36");
		Pattern PasswordTextBox = new Pattern (sImageFilePath + "Password.png");
		System.out.println("Entering sikuli line 38");
		s.type(PasswordTextBox, "admin");
		Pattern SignInButton = new Pattern (sImageFilePath + "Password.png");
		s.click(SignInButton);
*/
		driver.close();
		driver.quit();
	}

}
