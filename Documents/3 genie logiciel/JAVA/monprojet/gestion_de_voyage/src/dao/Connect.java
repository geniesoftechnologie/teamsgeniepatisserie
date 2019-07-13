/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bureau
 */
public class Connect {
    private static String url = "jdbc:mysql://localhost/gestion_de_voyage";
    private static String user = "root";
    private static String password = "";
    private static Connection connect;
    
    public Connect(){}
    
    public static Connection getInstance(){
        if(connect == null){
            try{
                connect = (Connection)DriverManager.getConnection(url, user, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return connect;
    }
}
    

