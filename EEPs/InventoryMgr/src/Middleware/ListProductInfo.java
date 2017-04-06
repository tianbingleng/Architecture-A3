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
public class ListProductInfo
{
    public static String username = "remote";
    public static String password = "remote_pass";
    public static String getProductList(String SQLServerIP, String category)
    {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        String result="";
        
        // Connect to the inventory database
        try
        {
            msgString = ">> Establishing Driver...";
            result=msgString;

            //Load J Connector for MySQL - explicit loads are not needed for 
            //connectors that are version 4 and better
            //Class.forName( "com.mysql.jdbc.Driver" );

            msgString = ">> Setting up URL...";
            result=result+("\n"+msgString);

            //define the data source
            String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/"+databaseSelect(category);
            msgString = ">> Establishing connection with: " + sourceURL + "...";
            result=result+("\n"+msgString);

            //create a connection to the db - note the default account is "remote"
            //and the password is "remote_pass" - you will have to set this
            //account up in your database

            DBConn = DriverManager.getConnection(sourceURL,username,password);

        }
        catch (Exception e)
        {

            errString =  "\nProblem connecting to database:: " + e;
            result=result+errString;
            connectError = true;

        } // end try-catch

        // If we are connected, then we get the list of trees from the
        // inventory database
        
        if ( !connectError )
        {
            try
            {
                s = DBConn.createStatement();
                res = s.executeQuery( "Select * from "+category);

                //Display the data in the textarea
                
                result = "";

                while (res.next())
                {
                    msgString = category+">>" + res.getString(1) + "::" + res.getString(2) +
                            " :: "+ res.getString(3) + "::" + res.getString(4);
                    result = result + ("\n"+msgString);

                } 
                                
            } catch (Exception e) {

                errString =  "\nProblem getting tree inventory:: " + e;
                result = result + errString;

            } // end try-catch
        } // if connect check
        return result;
    }
    
    public static String databaseSelect(String category)
    {
        if(category.equals("trees")) return "inventory";
        if(category.equals("shrubs")) return "inventory";
        if(category.equals("seeds")) return "inventory";
        if(category.equals("cultureboxes")) return "leaftech";
        if(category.equals("genomics")) return "leaftech";
        if(category.equals("processing")) return "leaftech";
        if(category.equals("referencematerials")) return "leaftech";
        return "";
        
    }
}
