package MyTests;

import Base.BaseTest;
import Pages.PagePicker;
import Utils.CommonFunctions;
import Utils.CommonSeleniumWrapper;
import Utils.Locator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyTest1 extends BaseTest {

    @Test(dataProvider = "data-provider")
    public void mytest1(String val1,String val2){
        PagePicker.getCalulationPage().AddCalculateValues(val1,val2);
    }


    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return CommonFunctions.ReadfromCSV("myFirstData.csv");
    }
}
