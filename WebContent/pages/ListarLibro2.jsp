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
		<div class="table-responsive" style="overflow-x: auto;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>TITULO</th>
					<th>DESCRIPCION</th>
					<th>ISBN</th>
					<th>PESO</th>
					<th>IDIOMA</th>
					<th>FECHA PUBLICACION</th>
					<th>CANTIDAD PAGINAS</th>
					<th>STOCK</th>
					<th>PRECIO</th>
					<th>CATEGORIA</th>
					<th>EDITORIAL</th>
					<th>AUTOR</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Libro lib : listaLibro) {
				%>
				<tr>
					<td><%=lib.getTitulo()%></td>
					<td class="descripcion-column"><%=lib.getDescripcion()%></td>
					<td><%=lib.getIsbn()%></td>
					<td><%=lib.getPeso()%></td>
					<td><%=lib.getIdioma()%></td>
					<td><%=lib.getFecha_publicacion()%></td>
					<td><%=lib.getCantidad_paginas()%></td>
					<td><%=lib.getStock()%></td>
					<td><%=lib.getPrecio()%></td>
					<td><%=lib.getCategoria().getDescripcion()%></td>
					<td><%=lib.getEditorial().getDescripcion()%></td>
					<td><%=lib.getAutor().getDescripcion()%></td>
					<td>
						<a class="btn btn-warning" href="controlador?menu=Libro&accion=Editar&id=<%=lib.getId()%>">Editar</a>
					</td>
				</tr>
				<%}%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="1"><a class="btn btn-primary"
						href="controlador?menu=Libro&accion=Agregar">Agregar</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
	</script>
</body>
</html>