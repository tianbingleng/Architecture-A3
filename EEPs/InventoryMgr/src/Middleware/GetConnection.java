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
    /* @return true get connected to the database
      * @return false get error while connecting
      * @param databaseIP The IP of database
      * @param databaseName The name of the database
      * @param errorMsg The error message
      **/
     private boolean getConnection(Connection dbConn, String databaseIP, String databaseName, String errorMsg){
         String sourceURL = "jdbc:mysql://" + databaseIP + ":3306/"+databaseName;
         try{
             dbConn = DriverManager.getConnection(sourceURL,"remote","remote_pass");
         }
         catch(Exception e){
             errorMsg = e.getMessage();
             return false;
         }
         
         return true;
     }
}
