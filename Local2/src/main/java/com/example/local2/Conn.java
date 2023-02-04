package com.example.local2;
import java.sql.*;
public class Conn {
    private static final String NAME="Acheron1232";
    private static final String PASSWORD="root";
    private static final String URL="jdbc:mysql://localhost:3306/mydatabase";
    public static Connection c(){
        try {
            Connection connection =DriverManager.getConnection(URL,NAME,PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

//biba
