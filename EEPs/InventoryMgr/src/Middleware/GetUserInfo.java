/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;

import static Middleware.GetProductInfo.databaseSelect;
import static Middleware.GetProductInfo.password;
import static Middleware.GetProductInfo.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shan
 */
public class GetUserInfo
{
    public static String sqlusername = "remote";
    public static String sqlpassword = "remote_pass";

    public static String getLoginStatus(String SQLServerIP, String type, 
            String username, String password)
    {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String result="";
        
        try
        {
            String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/users";
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
                res = s.executeQuery( "SELECT * FROM users where category='"+type+"' AND username='"+username+"' AND "
                        + "password='"+password+"';" );
                if(res.next()) result = "success";
                else result = "fail";
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
