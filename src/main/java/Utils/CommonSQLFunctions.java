package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonSQLFunctions {

    public Connection connectToDb(){
        Connection c = null;
        String conString=CommonFunctions.ReadSettings("dbConnectionString");
        String UserName=CommonFunctions.ReadSettings("dbUserName");
        String Password=CommonFunctions.ReadSettings("dbPassword");
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(conString,UserName,Password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public String SelectSingleValueFromQuery(String ValueToSelect){
        Connection c = null;
        Statement stmt = null;
        String val=null;
        try {
            c= connectToDb();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                val = rs.getString(ValueToSelect);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return val;
    }

}
