<%@ page import="entities.Libro"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.time.LocalDate"%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<%
LinkedList<Libro> listaLibro = (LinkedList<Libro>) request.getAttribute("libros");
%>
<body>
	<div class="d-flex">
		<div class="container mt-2">
        <div class="row">
            <% int count = 0; %>
            <% for (Libro lib :  listaLibro) { %>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <label><%= lib.getTitulo() %></label>
                        </div>
                        <div class="card-body">
                            <img alt="" src="" width="200" height="180">
                        </div>
                        <div class="card-footer text-center">
                            <p>Autor: <%= lib.getAutor().getDescripcion() %></p>
                            <p>Editorial: <%= lib.getEditorial().getDescripcion() %></p>
                            <p><i><%= lib.getPrecio() %></i></p>
                            <div>
                               <a href="controlador?menu=Libro&accion=AgregarCarrito&id=<%=lib.getId()%>" class="btn btn-outline-info">Agregar a Carrito</a>
                            </div>
                        </div>
                    </div>
                </div>
                <% count++; %>
                <% if (count % 3 == 0) { %>
                    </div>
                    <div class="row">
                <% } %>
            <% } %>
        </div>
    </div>
	</div>	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
	</script>
</body>
</html>