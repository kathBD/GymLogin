
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión | VibraFit</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
<body class="bg-secondary-color card shadow p-4 d-flex justify-content-center align-items-center vh-100">

   
         <div class="login-card text-center">
        <!-- ✅ Logo -->
        <img src="img/logo.png" width="100px" alt="Logo VibraFit" class="logo">
        
        <h3 class="text-center mb-4">Bienvenidos </h3>

        <!-- Mostrar mensaje de error si existe (solo si usas JSP) -->
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

     <form action="${pageContext.request.contextPath}/login" method="post">


            <div class="mb-3 text-start">
                <label for="correo" class="form-label">Correo electrónico</label>
                <input type="email" class="form-control" id="correo" name="correo" required>
            </div>

            <div class="mb-3 text-start">
                <label for="contrasena" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" required>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>

     
    </div>

    <!-- Bootstrap JS (opcional si necesitas componentes interactivos) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
