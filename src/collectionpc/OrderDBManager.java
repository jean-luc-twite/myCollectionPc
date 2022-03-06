/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collectionpc;

import java.sql.*;
import java.util.Date;
/**
 *
 * @author HP
 */
public class OrderDBManager {
    private Connection connection;
   /**
    * this is constructor method 
    * @param url 
    * @param userName
    * @param password
    * @throws SQLException 
    */
    public OrderDBManager(String url,String userName,String password) throws SQLException {
        this.connection= DriverManager.getConnection(url,userName,password);
    }
    
    public void addOrders(String quiery) throws SQLException{
       
         long millis = System.currentTimeMillis();
         Date date = new Date();
         Timestamp ts = new Timestamp(date.getTime());
         PreparedStatement statement;
         String sql ="INSERT INTO orders_tbl VALUES(?,?)";
         
         statement = connection.prepareStatement(sql);
         statement.setString(1, quiery);
         statement.setString(2, String.valueOf(ts));
        //exceute statement
         statement.execute();
}
}
