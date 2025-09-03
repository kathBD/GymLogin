/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // Evita crear nueva sesión
        if (session != null) {
            session.invalidate(); // Cierra sesión actual
        }

        // Redirige al login
        response.sendRedirect("vista/login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para cerrar sesión y redirigir al login.";
    }
}
