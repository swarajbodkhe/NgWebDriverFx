package Base;

import Utils.Browser;
import Utils.CommonFunctions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeMethod
    public void beforem(){
        Browser.getBrowser().chooseDriver(CommonFunctions.ReadSettings("BrowserName"));
        Browser.getBrowser().goToUrl(CommonFunctions.ReadSettings("URL"));
    }

@AfterMethod
    public void afterem(){
    Browser.getBrowser().quitBrowser();
}


}
