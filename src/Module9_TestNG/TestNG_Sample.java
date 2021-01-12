package Module9_TestNG;
import org.testng.annotations.*;

public class TestNG_Sample {
	
	@Test (priority=-1)
	public void openingBrowser () {
		System.out.println("Opening Browser");
	}
	
	@Test (priority=-1, dependsOnMethods="openingBrowser", alwaysRun=true)
	public void clickButton () {
		System.out.println("clicked button");
	}
	
	@Test (enabled=true, priority=2, dependsOnMethods="clickButton", timeOut=3000)
	public void validateObject () throws InterruptedException {
		System.out.println("Validate Object");
		Thread.sleep(5000);
	}
}
