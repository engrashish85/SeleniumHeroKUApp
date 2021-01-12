package Module9_TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners (Module9_TestNG.Selenium_ITestListenerClass.class)

public class HeroKUAppNestedFrames extends Selenium_WorkingWithDriver_TestNG {
	
	By oFrameLink = By.linkText("Frames");
	By oNestedFramesLink = By.linkText("Nested Frames");
	By oiFrameLink = By.linkText("iFrame");
	By oFrameLeft = By.xpath("//frame[@name='frame-left']");

	@BeforeTest
	public void setPrerequisitesforTestNG () {
		System.out.println("Entered BeforeTest");	
	}
	
	@Test (priority=0)
	public void testFrameNestedFrameLeft () {
		
		System.out.println("Entered Test Priority = 0");
		
		//Clicking on Frames Link
		driver.findElement(oFrameLink).click();
		
		//Clicking on Nested Frames Link
		driver.findElement(oNestedFramesLink).click();
		
		//Switching to top frame
		driver.switchTo().frame(0);
		
		//Switching to left frame
		WebElement oFrameLeft1 = driver.findElement(oFrameLeft);
		driver.switchTo().frame(oFrameLeft1);
		String sText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text - "+sText);
	
	}
	
	@Test (priority = 1, enabled = false, description="Testing middle frame in Nested Frames", expectedExceptions=ArithmeticException.class)
	public void testFrameNestedFrameMiddle () {
		
		System.out.println("Entered Test Priority = 1");
		
		int i = 1/0;
		System.out.println("Value of i is - "+i);
		
		//Returning driver to default content
		driver.switchTo().defaultContent();
		
		//Switching to top frame
		driver.switchTo().frame(0);
		
		//Switching to left frame
		driver.switchTo().frame(1);
		String sText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text - "+sText);
	
	}

	@Test (alwaysRun = true, enabled=true, priority=2)
	public void testFrameRight () {
		
		System.out.println("Entered Test Priority = 2");
		
		//Returning driver to initial state
		driver.switchTo().defaultContent();
		
		//Switching to top frame
		driver.switchTo().frame(0);
		
		//Switching to left frame
		driver.switchTo().frame("frame-right");
		String sText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text - "+sText);
	
	}
	
	@Test (alwaysRun = true, enabled=true, priority=2)
	public void testFrameBottom () {
		
		System.out.println("Entered Test Priority = 2");
		
		//Returning driver to initial state
		driver.switchTo().defaultContent();
		
		//Switching to top frame
		driver.switchTo().frame("frame-bottom");
		
		//Switching to left frame
		String sText = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text - "+sText);
	
	}
	
	@AfterTest
	public void afterTest () {
		System.out.println("Entered AfterTest");
	}
	
}
