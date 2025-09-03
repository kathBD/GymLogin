<%-- 
    Document   : Home Cliente
   
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User usuario = (User) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String rol;
    switch (usuario.getRolId()) {
        case 1: rol = "Cliente"; break;
        case 2: rol = "Entrenador"; break;
        case 3: rol = "Administrador"; break;
        default: rol = "Invitado"; break;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Bienvenido</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('https://web-back.perfectgym.com/sites/default/files/styles/460x/public/equipment%20%286%29.jpg?itok=bC0T32-K') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
        }

        .login-card {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 2.5rem;
            border-radius: 15px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.3);
            max-width: 400px;
            width: 100%;
        }

        .logo {
            width: 100px;
            margin: 0 auto 20px;
            display: block;
        }
    </style>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="alert alert-success text-center">
        <h3>¡Hola, <strong><%= usuario.getName() %></strong>!</h3>
        <p>Tu rol es: <strong><%= rol %></strong></p>
    </div>

    <div class="card mt-4">
        <div class="card-body">
            <h5 class="card-title">Acciones disponibles</h5>
            <ul class="list-group">
                <% if (usuario.getRolId() == 3) { %>
                    <li class="list-group-item">⚙️ Gestión de usuarios</li>
                    <li class="list-group-item">📊 Reportes generales</li>
                <% } else if (usuario.getRolId() == 2) { %>
                    <li class="list-group-item">📋 Crear y asignar rutinas</li>
                    <li class="list-group-item">💬 Chatear con clientes</li>
                <% } else if (usuario.getRolId() == 1) { %>
                    <li class="list-group-item">📈 Ver progreso</li>
                    <li class="list-group-item">💬 Contactar al entrenador</li>
                <% } %>
            </ul>
        </div>
    </div>

    <div class="text-center mt-4">
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Cerrar sesión</a>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
