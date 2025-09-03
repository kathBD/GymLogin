
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.User;
import model.dao.UserDao;

import java.io.IOException;

@WebServlet("/login")  // URL amigable para el login
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        UserDao userDao = new UserDao();
        User usuario = userDao.validarUsuario(correo, contrasena);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

        int rol = usuario.getRolId();
            switch (rol) {
                case 1: // Admin
                case 2: // Entrenador
                case 3: // Cliente
                    response.sendRedirect("vista/Home.jsp");
                    break;
                default:
                    response.sendRedirect("vista/Home.jsp");
                    break;
            }

        } else {
            request.setAttribute("error", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("vista/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendRedirect("vista/login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejar el inicio de sesión de usuarios.";
    }
}
