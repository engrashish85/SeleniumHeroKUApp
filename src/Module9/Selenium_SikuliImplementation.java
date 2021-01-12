package Module9;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Selenium_SikuliImplementation extends Selenium_WorkingWithDriver {
	
	@FindBy(how=How.LINK_TEXT, using = "Basic Auth") 
	public WebElement oLinkBasicAuth;

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		
		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();

		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sBasicAuthURL);
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
*/	}

}
