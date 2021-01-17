package Module9_PageFactoryImplementation;

import Module9.Selenium_InvokeChromeBrowser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

public class HeroKUAppMultipleWindows extends Selenium_InvokeChromeBrowser {

    WebDriver driver;
    Selenium_InvokeChromeBrowser selenium_invokeChromeBrowser = new Selenium_InvokeChromeBrowser();

    By multipleWindows = By.linkText("Multiple Windows");
    By newWindowsLink = By.cssSelector("a[href='/windows/new']");

    @BeforeMethod
    public void setUpBeforeClass() {
        driver = selenium_invokeChromeBrowser.getChromeDriver();
        driver.get(selenium_invokeChromeBrowser.sURL);
        driver.findElement(multipleWindows).click();
        driver.findElement(newWindowsLink).click();
    }

    @Test
    public void validateMultipleWindows() {
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[0].toString());
        Assert.assertThat("Validate that title is not - new window", driver.getTitle(), is(not("New Window")));
        driver.switchTo().window(allWindows[1].toString());
        Assert.assertThat("Validate that title is not - new window", driver.getTitle(), is("New Window"));
    }

    @Test
    public void validateMultipleWindowsUsingOtherApproach() {
        for (int i = 0; i < 3; i ++) {
            driver.findElement(newWindowsLink).click();
        }
        int count = 0;
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals("New Window")) {
                count += 1;
            }
        }
        System.out.println("New Window titles are - "+count);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
