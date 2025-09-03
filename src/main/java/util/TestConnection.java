/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

public class TestConnection {
    public static void main(String[] args) {
        if (ConnectionBD.getConnection() != null) {
            System.out.println("✅ Conexion OK");
        } else {
            System.out.println("❌ Conexion fallida");
        }
    }
}
