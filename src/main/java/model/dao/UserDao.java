/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.User;
import util.ConnectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

  public User validarUsuario(String correo, String contrasena) {
    User user = null;

    String sql = "SELECT usuario_id, nombre, correo, rol_id, esta_activo FROM usuarios WHERE correo = ? AND contrasena = ?";

    try (Connection con = ConnectionBD.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, correo);
        ps.setString(2, contrasena);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                boolean activo = rs.getBoolean("esta_activo");
                if (activo) {
                    user = new User();
                    user.setUserId(rs.getString("usuario_id"));
                    user.setName(rs.getString("nombre"));
                    user.setEmail(rs.getString("correo"));
                    user.setRolId(rs.getInt("rol_id"));
                    user.setEstaActivo(true);
                }
            }
        }

    } catch (SQLException e) {
        System.err.println("❌ Error validando usuario: " + e.getMessage());
    }

    return user;
}
}