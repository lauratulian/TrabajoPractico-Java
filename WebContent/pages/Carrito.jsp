<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Carrito"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html lang=>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"crossorigin="anonymous">
</head>
<%
LinkedList<Carrito> listaCarrito = (LinkedList<Carrito>) request.getAttribute("listaCarrito");
%>
<body>

 <div class="container mt-4">
 	<div class="row">
 		<div class="col-sm-8">
 		 <h2>Carrito</h2>
 		 <br>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>ITEM</th>
                <th>TITULO</th>
                <th>PRECIO</th>
                <th>CANTIDAD</th>
                <th>SUBTOTAL</th>
                <th>ACCION</th>
            </tr>
        </thead>
        <tbody>
        <% if (listaCarrito != null && !listaCarrito.isEmpty()) { 
    	for (Carrito car : listaCarrito) { %>
        <tr>
            <td><%= car.getItem() %></td>
            <td><%= car.getTitulo() %></td>
            <td><%= car.getPrecio() %></td>
            <td><%= car.getCantidad() %></td>
            <td><%= car.getSubtotal() %></td>
        </tr>
		<%  } } %>
        </tbody>
    </table>
 		</div>
 		<div class="col-sm-4">
 			<div class="card">
 				<div class="card-header">
 					<h3> Generar compra</h3>
 				</div>
 				<div class="card-body">
 				<label> Subtotal: </label>
 				<input type="text" readonly="" class="form-control">
 				<label> Descuento: </label>
 				<input type="text" readonly="" class="form-control">
 				<label> Total: </label>
 				<input type="text" readonly="" class="form-control">
 				</div>
 				<div class="card-footer">
 					<a class="btn btn-info">Realizar Pago</a>
 				</div>
 			</div>
 		</div>
 	</div>
  </div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"crossorigin="anonymous"></script>
</body>
</html>