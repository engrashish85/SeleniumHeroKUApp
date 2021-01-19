package Module9_TestNG;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;
import Module9_PageFactoryImplementation.HeroKUAppJavaScriptAlertsPage;
import Module9_PageObjectModel.HeroKUAppMainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class HeroKUAppJavaScriptAlerts_TestNG extends Selenium_InvokeChromeBrowser {

    @Test
    @Parameters("alertsType")
    public void validateJavaScriptAlerts(String alertsType) {
        driver = getChromeDriver();
        driver.get(sURL);
        HeroKUAppMainPage heroKUAppMainPage = PageFactory.initElements(driver, HeroKUAppMainPage.class);
        heroKUAppMainPage.javaScriptAlertsLink.click();
        HeroKUAppJavaScriptAlertsPage heroKUAppJavaScriptAlertsPage = new HeroKUAppJavaScriptAlertsPage(driver);
        heroKUAppJavaScriptAlertsPage.clickAlertsButtonAndValidateAlertsOnPage(alertsType);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
