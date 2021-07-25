package Pages;

import Utils.Browser;
import Utils.CommonSeleniumWrapper;
import Utils.Locator;

public class CalculationPage {

    private String OperationSelectModel="operator";
    private String Num1TxtModel="first";
    private String Num2TxtModel="second";
    private String GoBtnTxt="Go!";
    CommonSeleniumWrapper csw;

    public CalculationPage(){
        csw=new CommonSeleniumWrapper();
    }

    public void AddCalculateValues(String firstVal,String secondVal){
        csw.SelectValueFromWebElement(Locator.MODEL,OperationSelectModel,"ADDITION");
        csw.SetTextToWebElement(Locator.MODEL,Num1TxtModel,firstVal);
        csw.SetTextToWebElement(Locator.MODEL,Num2TxtModel,secondVal);
        csw.ClickOnWebElement(Locator.BUTTONTXT,GoBtnTxt);
    }

}
