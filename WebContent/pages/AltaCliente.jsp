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
  <body>
	<div class="d-flex">
	    <div class="card col-sm-6">
    	<div class card="card-body">
    		<form action="${pageContext.request.contextPath}/controlador?menu=Persona&accion=Agregar" method="post">
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
    				<label>Telefono</label>
    				<input type="text" name="txtFechaNacimiento" class="form-control">
    			</div>
    			<div>
    				<label>Adicional</label>
    				<input type="text" name="txtAdicional" class="form-control">
    			</div>
    			<div class="d-flex justify-content-center">
    				<input type="submit" name="accion" value="Agregar" class="btn btn-info">
    			</div>
    		</form>
    	</div>
    </div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>