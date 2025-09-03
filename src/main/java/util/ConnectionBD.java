/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/vibrafitapp?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Tsuki28ñ(1518)";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar driver (opcional en Java 11+)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("🚀 Conexión exitosa!!!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return null;
    }
}
