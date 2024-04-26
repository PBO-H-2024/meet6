/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan6;

import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    Statement statement;
    
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
    
    void insertData(int nim, String name, int age){
        try{
            String query = "INSERT INTO `student`(`nim`,`name`,`age`) VALUES ('" + nim + "','" + name + "','" + age + "')";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed " + ex.getMessage());
        }
    }
}
