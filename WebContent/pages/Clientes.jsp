<%@ page import="entities.Persona" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.time.LocalDate" %>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
      <% LinkedList<Persona> lp = (LinkedList<Persona>)request.getAttribute("personas"); %>
  <body>
	<div class="d-flex">
	    <div class="card col-sm-6">
    	<div class card="card-body">
    		<form action="controlador?menu=Personas" method="post">
    			<div>
    				<label>Dni</label>
    				<input type="text" name="txtDni" class="form-control">
    			</div>
    			<div>
    				<label>Nombre</label>
    				<input type="text" name="txtNombre" class="form-control">
    			</div>	
    			<div>
    				<label>Mail</label>
    				<input type="text" name="txtMail" class="form-control">
    			</div>
    			<div>
    				<label>Direccion</label>
    				<input type="text" name="txtDireccion" class="form-control">
    			</div>
    			<div>
    				<label>Contrasenia</label>
    				<input type="text" name="txtContrasenia" class="form-control">
    			</div>
    			<div>
    				<label>Telefono</label>
    				<input type="text" name="txtFechaNacimiento" class="form-control">
    			</div>
    			<div>
    				<label>Adicional</label>
    				<input type="text" name="txtAdicional" class="form-control">
    			</div>
    			<input type="submit" name="accion" value="Agregar" class="btn btn-info">
    		</form>
    	</div>
    </div class="col-sm-8">
    <table class="table table-hover">
    	<thead>
    		<tr>
	    		<th>DNI </th>
	    		<th>NOMBRE</th>
	    		<th>MAIL</th>
	    		<th>DIRECCION </th>
	    		<th>TELEFONO </th>
	    		<th>ADICIONAL</th>
	    		<th>ACCIONES </th>
    		</tr>
    	</thead>
    	<tbody>
    		<% for (Persona per : lp) { %>
    		<tr>
	    		<td> <%=per.getId()%></td>
	    		<td> <%=per.getNombre()%> </td>
	    		<td> <%=per.getMail()%></td>
	    		<td> <%=per.getDireccion()%></td>
	    		<td> <%=per.getTelefono()%></td>
	    		<td> <%=per.getAdicional()%></td>
	    		<td> 
	    			<a class="btn btn-warning" href="controlador?menu=Empleado&accion=Editar&id=<%=per.getId()%>">Editar</a>
	    			<a class="btn btn-danger" href="controlador?menu=Empleado&accion=Eliminar&id=<%=per.getId()%>">Delete</a>
	    		</td>
    		</tr>
    		<% } %>
    	</tbody>
    </table>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>