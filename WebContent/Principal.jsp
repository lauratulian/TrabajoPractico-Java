<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona"%>
<!DOCTYPE html>
<html lang=>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-info">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link active"
						href="">Inicio</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Libros" target="myFrame">Libros</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Catalogo" target="myFrame">Catalogo</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Local" target="myFrame">Locales</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Contacto" target="myFrame">Contacto</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Ventas" target="myFrame">Ventas</a></li>
					<li style="margin-left: 10px; border: none"
						class="btn btn-outline-light"><a class="nav-link" href="controlador?menu=Personas&accion=Listar" target="myFrame">Clientes</a></li>
				</ul>
				<div class="botton">
					<button style="border: none"
						class="btn btn-outline-light e" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
  							<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
						</svg>
					</button>
				</div>
				
				<div class="dropdown">
					<button style="border: none"
						class="btn btn-outline-light dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
 							<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
						</svg>
					</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Mi perfil</a></li>
						<li><a class="dropdown-item" href="#">Mis pedidos</a></li>
						<div class="dropdown-divider"></div>
						
						<form action="signin" method="post">
							<button name="accion" value="Salir" class="dropdown-item" 
							
							href="#">Salir</button>
						</form>
					</ul>
				</div>
			</div>
		</div>
	</nav>
		<div class="m-4" style="height: 550px;">
			<iframe name="myFrame" style="height: 100%; width: 100%; border:none"></iframe>
		</div>		
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"crossorigin="anonymous"></script>
</body>
</html>