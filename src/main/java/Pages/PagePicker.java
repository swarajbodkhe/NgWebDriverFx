package Pages;

import Utils.Browser;

public class PagePicker {
    static CalculationPage cp=null;

    public static CalculationPage getCalulationPage(){
        if (cp==null){
            return new CalculationPage();
        }
        return cp;
    }


}
