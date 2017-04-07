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
public class GetOrders {
    public static String[] getShippedOrders(String SQLServerIP) {

        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        int shippedStatus;                  // if 0, order not shipped, if 1 order shipped

        // Clean up the form before we start
        String result4="", result1="";

        // Connect to the order database
        try
        {
            msgString = ">> Establishing Driver...";
            result4 = "\n"+msgString;

            //load JDBC driver class for MySQL
            Class.forName( "com.mysql.jdbc.Driver" );

            msgString = ">> Setting up URL...";
            result4 += ("\n"+msgString);

            //define the data source
            String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/orderinfo";

            msgString = ">> Establishing connection with: " + sourceURL + "...";
            result4 += "\n"+msgString;

            //create a connection to the db - note the default account is "remote"
            //and the password is "remote_pass" - you will have to set this
            //account up in your database
            DBConn = DriverManager.getConnection(sourceURL,"remote","remote_pass");

        } catch (Exception e) {

            errString =  "\nProblem connecting to orderinfo database:: " + e;
            result4 += (errString);
            connectError = true;

        } // end try-catch

        // If we are connected, then we get the list of trees from the
        // inventory database

        if ( !connectError )
        {
            try
            {
                // Create a query to get all the rows from the orders database
                // and execute the query.
                s = DBConn.createStatement();
                res = s.executeQuery( "Select * from orders" );

                //Display the data in the textarea
                result1 = "";

                // For each row returned, we check the shipped status. If it is
                // equal to 0 it means it has not been shipped as of yet, so we
                // display it in TextArea 1. Note that we use an integer because
                // MySQL stores booleans and a TinyInt(1), which we interpret
                // here on the application side as an integer. It works, it just
                // isn't very elegant.

                while (res.next())
                {
                    shippedStatus = Integer.parseInt(res.getString(8));

                    if ( shippedStatus == 1 )
                    {
                        msgString = "SHIPPED ORDER # " + res.getString(1) + " : " + res.getString(2) +
                              " : "+ res.getString(3) + " : " + res.getString(4);
                        result1 += (msgString+"\n");

                    } // shipped status check

                } // while

                msgString =  "\nSHIPPED ORDERS RETRIEVED...";
                result4 = msgString;

            } catch (Exception e) {

                errString =  "\nProblem getting tree inventory:: " + e;
                result4 += errString;

            } // end try-catch

        } // connect check
        String[] results = new String[] {result1, result4};
        return results;
    } // getPendingOrders
    public static String[] getPendingOrders(String SQLServerIP)
    {
        Boolean connectError = false;       // Error flag
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        ResultSet res = null;               // SQL query result set pointer
        Statement s = null;                 // SQL statement pointer
        int shippedStatus;                  // if 0, order not shipped, if 1 order shipped

        String result1="", result4 = "";
        // Connect to the order database
        try
        {
            msgString = ">> Establishing Driver...";
            result4 = "\n"+msgString;

            //load JDBC driver class for MySQL
            Class.forName( "com.mysql.jdbc.Driver" );

            msgString = ">> Setting up URL...";
            result4 += "\n"+msgString;

            //define the data source
            String sourceURL = "jdbc:mysql://" + SQLServerIP + ":3306/orderinfo";

            msgString = ">> Establishing connection with: " + sourceURL + "...";
            result4 += "\n"+msgString;

            //create a connection to the db - note the default account is "remote"
            //and the password is "remote_pass" - you will have to set this
            //account up in your database
            DBConn = DriverManager.getConnection(sourceURL,"remote","remote_pass");

        } catch (Exception e) {

            errString =  "\nProblem connecting to orderinfo database:: " + e;
            result4 += errString;
            connectError = true;

        } // end try-catch

        // If we are connected, then we get the list of trees from the
        // inventory database

        if ( !connectError )
        {
            try
            {
                // Create a query to get all the orders and execute the query
                s = DBConn.createStatement();
                res = s.executeQuery( "Select * from orders" );

                //Display the data in the textarea
                result1 = "";

                // For each row returned, we check the shipped status. If it is
                // equal to 0 it means it has not been shipped as of yet, so we
                // display it in TextArea 1. Note that we use an integer because
                // MySQL stores booleans and a TinyInt(1), which we interpret
                // here on the application side as an integer. It works, it just
                // isn't very elegant.
                while (res.next())
                {
                    shippedStatus = Integer.parseInt(res.getString(8));

                    if ( shippedStatus == 0 )
                    {
                        msgString = "ORDER # " + res.getString(1) + " : " + res.getString(2) +
                              " : "+ res.getString(3) + " : " + res.getString(4);
                        result1 += (msgString+"\n");

                    } // shipped status check

                } // while

                // notify the user all went well and enable the select order
                // button
                msgString =  "\nPENDING ORDERS RETRIEVED...";
                result4 = msgString;

            } catch (Exception e) {

                errString =  "\nProblem getting tree inventory:: " + e;
                result4 += errString;

            } // end try-catch
            
        } // if connect check
        String[] results = new String[] {result1, result4};
        return results;
    }
}
