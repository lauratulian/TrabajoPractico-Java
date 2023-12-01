<%@ page import="entities.Persona"%>
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
LinkedList<Persona> lp = (LinkedList<Persona>) request.getAttribute("personas");
%>
<body>
	<div class="d-flex">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>MAIL</th>
					<th>DIRECCION</th>
					<th>TELEFONO</th>
					<th>ADICIONAL</th>
					<th>ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Persona per : lp) {
				%>
				<tr>
					<td><%=per.getId()%></td>
					<td><%=per.getNombre()%></td>
					<td><%=per.getMail()%></td>
					<td><%=per.getDireccion()%></td>
					<td><%=per.getTelefono()%></td>
					<td><%=per.getAdicional()%></td>
					<td>
						<a class="btn btn-warning" href="controlador?menu=Persona&accion=Editar&id=<%=per.getId()%>">Editar</a>
					</td>
				</tr>
				<%}%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="1"><a class="btn btn-primary"
						href="pages/AltaCliente.jsp">Agregar</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>