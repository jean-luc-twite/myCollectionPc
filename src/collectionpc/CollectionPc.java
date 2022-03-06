/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collectionpc;

import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class CollectionPc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        	// write your code here
        ServerSocket server=null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter bw=null;
        String data ;
          String url="jdbc:mysql://localhost:3306/orders_db";
        String userName="root";
        String passwd = "04061998Jlt@";
       // File fileName =new File("./orders.txt");
       OrderDBManager odbm ;
        try{
          // create the  server
            server = new ServerSocket(8080);
           //display server
            System.out.println("server :" + server);
            
            // create the socket
            socket = server.accept();
            
            System.out.println("connected...");
            //create the reader stream
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // create date
            Date date = new Date();
            //create  Timestamp
            Timestamp ts = new Timestamp(date.getTime());
            //create instance for database
            odbm = new OrderDBManager(url,userName,passwd);
            //READ DATA
             data = in.readLine();
            while(true){
            //DISPLAY
            System.out.println("ORDER is " + data + "place on " + ts + "\n" + "thank you!!!");
             //write data INTO DATABASE
             
              odbm.addOrders(data);
              //READ AGAIN
              data = in.readLine();
            }
          
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                System.out.println("close..");
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
