/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Junyuan Zhang
 */
public class DeleteProduct {
    public static String username = "remote";
    public static String password = "remote_pass";
    public static String deleteProduct(String SQLServerIP, String category, 
         String productID){
        
         Connection dbConn = GetConnection.getConnection(SQLServerIP, databaseSelect(category));
         if (dbConn!=null){
             try{
                
                java.sql.Statement s = dbConn.createStatement();
    
                int executeUpdateVal = s.executeUpdate(delete(category,productID));
               
                return "\n\n" + productID + " deleted..."+"\n Number of items deleted: " + executeUpdateVal;
             }
             catch(Exception e){
                 return "\nProblem with delete:: " + e;
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
    
    public static String delete(String category, String productID)
    {
        if(category.equals("trees")||category.equals("shrubs")||category.equals("seeds"))
        {
            return "DELETE FROM "+category+" WHERE product_code = '" + productID + "';";
        }
        else
        {
            return "DELETE FROM "+category+" WHERE productid = '" + productID + "';";
        }
    }
}
