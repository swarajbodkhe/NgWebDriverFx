package Utils;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonFunctions {


    public static String ReadSettings(String SettingName){
        try{
            FileReader reader=new FileReader("src/main/resources/Property Files/settings.properties");
            Properties p=new Properties();
            p.load(reader);
            return p.getProperty(SettingName);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object[][] ReadfromCSV(String filename)  {
        try{
            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/Data/"+filename), ',');

            List<String[]> csvData=csvReader.readAll();
            Object[][] csvDataObject=new Object[csvData.size()][2];
            for (int i=0;i<csvData.size();i++) {
                csvDataObject[i]=csvData.get(i);
            }
            return  csvDataObject;
        }catch (Exception e){
            return null;
        }

    }
}
