package Utils;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static Browser browser;
    private WebDriver driver=null;
    private NgWebDriver ngWebDriver = null;

    private Browser(){

    }

    public static Browser getBrowser(){
        if (browser==null){
            browser=new Browser();
        }
        return browser;
    }

    public void chooseDriver(String DriverName){
        switch (DriverName.toUpperCase()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
                driver=new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ngWebDriver=new NgWebDriver((JavascriptExecutor) driver);
    }

    public  WebDriver chosenDriver(){
        return driver;
    }

    public NgWebDriver getNgWebDriver(){
        return ngWebDriver;
    }

    public  void closeBrowser(){
        driver.close();
    }

    public void quitBrowser(){
        driver.quit();
    }

    public void goToUrl(String url){
        driver.get(url);
        ngWebDriver.waitForAngularRequestsToFinish();
    }

}
