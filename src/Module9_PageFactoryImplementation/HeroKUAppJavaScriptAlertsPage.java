package Module9_PageFactoryImplementation;

import Module9.Selenium_InvokeChromeBrowser;
import Module9.Selenium_WorkingWithDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HeroKUAppJavaScriptAlertsPage extends Selenium_InvokeChromeBrowser {

    public HeroKUAppJavaScriptAlertsPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Click for JS Alert']")
    public WebElement clickForJSAlertsButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Click for JS Confirm']")
    public WebElement clickForJSConfirmButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Click for JS Prompt']")
    public WebElement clickForJSPromptButton;

    public void clickAlertsButtonAndValidateAlertsOnPage(String alertsType) {
        Alert jsAlert;
        switch (alertsType) {
            case "JS Alert":
                clickForJSAlertsButton.click();
                jsAlert = driver.switchTo().alert();
                break;
            case "JS Confirm":
            case "JS Dismiss":
                clickForJSConfirmButton.click();
                jsAlert = driver.switchTo().alert();
                break;
            case "JS Prompt":
                clickForJSPromptButton.click();
                jsAlert = driver.switchTo().alert();
                jsAlert.sendKeys("test");
                break;
            default:
                throw new NoSuchElementException("No such Alert -"+ alertsType + " is found");
        }
        if (!(alertsType.equals("JS Dismiss"))) {
            jsAlert.accept();
        } else {
            jsAlert.dismiss();
        }
        validateAlertsOnPage(alertsType);
    }

    void validateAlertsOnPage(String alertsType) {
        Selenium_WorkingWithDriver selenium_workingWithDriver = new Selenium_WorkingWithDriver();
        switch(alertsType.toUpperCase()) {
            case "JS ALERT":
                selenium_workingWithDriver.validateTextOnPage("You successfuly clicked an alert");
                break;
            case "JS CONFIRM":
                selenium_workingWithDriver.validateTextOnPage("You clicked: Ok");
                break;
            case "JS DISMISS":
                selenium_workingWithDriver.validateTextOnPage("You clicked: Cancel");
                break;
            case "JS PROMPT":
                selenium_workingWithDriver.validateTextOnPage("You entered: test");
                break;
            default:
                throw new RuntimeException("The popup clicked is invalid");
        }
    }

}
