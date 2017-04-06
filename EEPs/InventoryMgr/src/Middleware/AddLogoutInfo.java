/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;

import static Middleware.GetUserHistory.sqlpassword;
import static Middleware.GetUserHistory.sqlusername;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Shan
 */
public class AddLogoutInfo
{
    public static String sqlusername = "remote";
    public static String sqlpassword = "remote_pass";
    
    public static String addLogoutInfo(String SQLServerIP, String category, 
            String userid)
    {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        Statement s = null;                 // SQL statement pointer
        String result="";
        
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

        // If we are connected, then we get the list of trees from the
        // inventory database
        
        if ( !connectError )
        {
            try
            {
                s = DBConn.createStatement();
                String loginType = "logout";
                String status = "success";
                
                InetAddress IP = null;
                try {
                    IP = InetAddress.getLocalHost();
                } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                }
                
                String ipAddress = IP.getHostAddress();
                
                String SQLstatement = ("INSERT INTO loginhistory VALUES ('"+ 
                        category +"','"+ userid +"','"+ 
                        loginType +"','"+ status + "','" + ipAddress
                        + "',NOW());");
                                
                s.executeUpdate(SQLstatement);
                System.out.println(SQLstatement);
                System.out.println(s);
                
            }
            catch (Exception e)
            {
                errString =  "\nProblem getting user history:: " + e;
                result = result + e.toString();
            } // end try-catch
        } // if connect check
        return result;
    }        
}
