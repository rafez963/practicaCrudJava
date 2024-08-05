package com.riwi.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection connection = null;

    public static Connection openConnection(){
        String url = "jdbc:mysql//localhost:3306/aerolinea";
        String user = "root";
        String password = "Colombia.123";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("La conexion se establecio");
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (connection != null){
                connection.close();
                System.out.println("Conexion cerrada");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
