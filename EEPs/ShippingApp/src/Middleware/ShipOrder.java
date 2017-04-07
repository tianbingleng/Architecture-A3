/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Middleware;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Junyuan
 */
public class ShipOrder {
    public static String shipOrder(String SQLServerIP, int updateOrderID){
        Connection dbConn = GetConnection.getConnection(SQLServerIP, "orderinfo");
        if (dbConn!=null){
            try{
                Statement s = dbConn.createStatement();
                int row = s.executeUpdate("UPDATE orders SET shipped=" + true + " WHERE order_id=" + updateOrderID);  
                return String.valueOf(row);
            }
            catch(Exception e){
                return "\nProblem updating status:: " + e;
            }
        }
        else{
            return "\nProblem connecting to orderinfo database";
        }
        
    }
}
