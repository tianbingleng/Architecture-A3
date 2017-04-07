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
 * @author socyrus
 */
public class GetConnection {
    static String  username = "remote";
    static String  password = "remote_pass";
    /* @return true get connected to the database
      * @return false get error while connecting
      * @param databaseIP The IP of database
      * @param databaseName The name of the database
      * @param errorMsg The error message
      **/
     public static Connection getConnection(String databaseIP, String databaseName){
         
         String sourceURL = "jdbc:mysql://" + databaseIP + ":3306/"+databaseName;
         
         try{
            return DriverManager.getConnection(sourceURL,username, password);
         }
         catch(Exception e){
             return null;
         }
     }
}
