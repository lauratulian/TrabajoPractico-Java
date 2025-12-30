<%@ page import="entities.Categoria"%>
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

<%LinkedList<Categoria> listaCategoria = (LinkedList<Categoria>) request.getAttribute("categorias");%>

<body>
		<div class="table-responsive" style="overflow-x: auto;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DESCRIPCION</th>

				</tr>
			</thead>
			<tbody>
				<%
				for (Categoria cat : listaCategoria) {
				%>
				<tr>
					<td><%=cat.getDescripcion()%></td>
					<td>
							<form action="tu_servlet_o_jsp_destino" method="post">
								<input type="hidden" name="categoriaId" value="<%=cat.getId()%>">
								<button href="controlador?menu=Categoria&accion=ListarCategoria&id=<%=cat.getId()%>" type="submit" class="btn btn-primary">Seleccionar</button>
							</form>
					</td>
				</tr>
				<%}%>
			</tbody>
			<tfoot>
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