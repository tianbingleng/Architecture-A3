/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author socyrus
 */
public class DecrementProduct {
    private static String username = "remote";
    private static String password = "remote_pass";
    public static String decrementProduct(String SQLServerIP, String category, String productID){
        Connection dbConn = GetConnection.getConnection(SQLServerIP, databaseSelect(category));
         if (dbConn!=null){
             try{
                
                java.sql.Statement s = dbConn.createStatement();
                
                int executeUpdateVal = s.executeUpdate(decrement(category,productID));
                ResultSet res = s.executeQuery(select(category,productID));
                
                String result = "";
                result+="\n\n" + productID + " inventory decremented...";
                        
                while (res.next())
                {
                    result += "\n"+ category.toUpperCase() + ">> " + res.getString(1) + " :: " + res.getString(2) +
                     " :: "+ res.getString(3) + " :: " + res.getString(4);
                } 
                        
                result += "\n\n Number of items updated: " + executeUpdateVal;
                return result;
             }
             catch(Exception e){
                 return "\nProblem with decrement:: " + e;
             }
         }
         else return "\nProblem connecting to database";
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
    
    public static String decrement(String category, String productID){
        if (category.equals("trees")||category.equals("shrubs")||category.equals("seeds")){
            return "UPDATE "+category+" set quantity=(quantity-1) where product_code = '" + productID + "';";
        }
        else{
            return "UPDATE "+category+" set productquantity=(productquantity-1) where productid = '" + productID + "';";
        }
        
    }
    
    public static String select(String category, String productID){
        
        if (category.equals("trees")||category.equals("shrubs")||category.equals("seeds")){
            return "SELECT * from "+category+" where product_code = '" + productID + "';";
        }
        else{
            return "SELECT * from "+category+" where productid = '" + productID + "';";
        }
        
    }
}
