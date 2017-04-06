/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shan
 */
public class GetUserHistory
{
    public static String sqlusername = "remote";
    public static String sqlpassword = "remote_pass";

    public static String getUserHistoryList(String SQLServerIP, String category)
    {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String result = "";
        
        try
        {
            String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/userhistory";
            DBConn = DriverManager.getConnection(sourceURL,sqlusername,sqlpassword);
        }
        catch (Exception e)
        {
            result="error";
            connectError = true;
        }
        
        if ( !connectError )
        {
            try
            {
                s = DBConn.createStatement();             
                res = s.executeQuery( "Select * from loginhistory where category='"+ category +"'");
                
                StringBuilder resultSB = new StringBuilder("");
                String msgString ="";

                // Now we list the loginhistory for the selected table
                resultSB.append("==============================================\n");
                resultSB.append("Category       DateTime                  ");
                resultSB.append("Type        Status       Username");
                while (res.next())
                {
                    msgString = res.getString(1) + "  " + res.getString(5) +
                            "          "+ res.getString(3) + "         " + res.getString(4) + "       " + res.getString(2);
                    resultSB.append("\n"+msgString);

                } // while
                
                result = resultSB.toString();
            }
            catch (Exception e)
            {
                
            System.out.println(e.toString());
                result = "error";
            }
        }
        return result;
    }
    
}
