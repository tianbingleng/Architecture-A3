/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Junyuan
 */
public class SelectOrder {
    private static String username = "remote";
    private static String password = "remote_pass";
    public static ArrayList<String> selectOrderTable(String serverIP,String orderID){
        ArrayList<String> result = new ArrayList<String>();
        Connection dbConn = GetConnection.getConnection(serverIP, "orderinfo");
        
        
        if (dbConn!=null){
            try{
                Statement s = dbConn.createStatement();
                ResultSet res = s.executeQuery( "SELECT * FROM orders WHERE order_id = " + Integer.parseInt(orderID) );
                
                 while (res.next()) {
                  result.clear();
                  
                  result.add(res.getString(9));        // name of table with list of items
                  result.add(res.getString(3)); // first name
                  result.add(res.getString(4)); // last name
                  result.add(res.getString(6)); // phone
                  result.add(res.getString(2)); // order date
                  result.add(res.getString(5));  // address

                } // for each element in the return SQL query
                s.close();
                 
                return result;
            }
            catch(Exception e){
                result.add("\nProblem getting order items:: " + e);
                return result;
            }
        }
        else{
            result.add("\nProblem connecting to orderinfo database");
            return result;
        }
    }
    
    
    public static String selectOrder(String serverIP,String orderTable){
        Connection dbConn = GetConnection.getConnection(serverIP, "orderinfo");
        
        if (dbConn!=null){
            try{
                Statement s = dbConn.createStatement();
                
                ResultSet res = s.executeQuery( "SELECT * FROM " + orderTable);
                String result = "";
                while (res.next())
                {
                    result += res.getString(1) + ":  PRODUCT ID: " + res.getString(2) +
                         "  DESCRIPTION: "+ res.getString(3) + "  PRICE $" + res.getString(4)+"\n";

                } // while
                s.close();
                return result;
            }
            catch(Exception e){
                return "\nProblem getting order items:: " + e;
            }
        }
        else{
            return "\nProblem connecting to orderinfo database";
        }
    }
}
