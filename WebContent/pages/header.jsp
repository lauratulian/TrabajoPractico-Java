<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Communitas Librería</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<!-- TOPBAR -->
<div class="bg-dark text-light py-1">
    <div class="container d-flex justify-content-between small">
        <span>Bienvenido a Communitas</span>
        <div>
            <a href="#" class="text-light text-decoration-none me-3">Ingresar</a>
            <a href="#" class="text-light text-decoration-none">Registrarse</a>
        </div>
    </div>
</div>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-info bg-info shadow-sm">
    <div class="container">
        <a class="navbar-brand fw-bold text-white"
           href="controlador?menu=Principal">
            Communitas
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menuPrincipal">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menuPrincipal">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link text-white"
                       href="controlador?menu=Catalogo">Catálogo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white"
                       href="controlador?menu=Local">Locales</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white"
                       href="controlador?menu=Contacto">Contacto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white"
                       href="controlador?menu=Ventas">Ventas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white"
                       href="controlador?menu=Persona&accion=Listar">Clientes</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
