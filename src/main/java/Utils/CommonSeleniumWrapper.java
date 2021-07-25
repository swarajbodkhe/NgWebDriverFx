package Utils;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonSeleniumWrapper {
    
    public ByAngular.BaseBy getWebElement(Locator locator, String locatorValue){
        ByAngular.BaseBy element=null;
        switch (locator){
            case BUTTONTXT:
                element= ByAngular.buttonText(locatorValue);
                break;
            case MODEL:
                element= ByAngular.model(locatorValue);
                break;
        }
        return element;
    }

    public void SetTextToWebElement(Locator locator, String locatorValue,String TxtValue){
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
        Browser.getBrowser().chosenDriver().findElement(getWebElement(locator,locatorValue)).sendKeys(TxtValue);
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
    }

    public void ClickOnWebElement(Locator locator, String locatorValue){
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
        Browser.getBrowser().chosenDriver().findElement(getWebElement(locator,locatorValue)).click();
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
    }

    public WebElement WaitForWebElement(Locator locator, String locatorValue,int TimeOut){
        WebDriverWait wt=new WebDriverWait(Browser.getBrowser().chosenDriver(),TimeOut);
        return wt.until(ExpectedConditions.visibilityOfElementLocated(getWebElement(locator,locatorValue)));
    }

    public WebElement WaitForWebElementToBeClickable(Locator locator, String locatorValue,int TimeOut){
        WebDriverWait wt=new WebDriverWait(Browser.getBrowser().chosenDriver(),TimeOut);
        return wt.until(ExpectedConditions.elementToBeClickable(getWebElement(locator,locatorValue)));
    }

    public void SelectValueFromWebElement(Locator locator, String locatorValue,String ValueToSelect){
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
        Select select=new Select(Browser.getBrowser().chosenDriver().findElement(getWebElement(locator,locatorValue)));
        select.selectByValue(ValueToSelect);
        Browser.getBrowser().getNgWebDriver().waitForAngularRequestsToFinish();
    }
}
