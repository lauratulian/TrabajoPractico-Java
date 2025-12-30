<%@ page import="entities.Libro" %>
<%@ page import="entities.Categoria" %>
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
      <% Libro libro = (Libro)request.getAttribute("libro"); %> 
  <body>
	<div class="d-flex">
	    <div class="card col-sm-6">
    	<div class card="card-body">
    		<form action="controlador?menu=Libro&accion=Actualizar" method="post">
    			<div>
    				<label>Titulo</label>
    				<input type="text" value="<%=libro.getTitulo()%>"  name="txtTitulo" class="form-control">
    			</div>
    			<div>
    				<label>Descripcion</label>
    				<input type="text" value="<%=libro.getDescripcion()%>" name="txtDescripcion" class="form-control">
    			</div>	
    			<div>
    				<label>ISBN</label>
    				<input type="text" value="<%=libro.getIsbn()%>" name="txtIsbn" class="form-control">
    			</div>
    			<div>
    				<label>Peso</label>
    				<input type="text" value="<%=libro.getPeso()%>" name="txtPeso" class="form-control">
    			</div>
    			<div>
    				<label>Idioma</label>
    				<input type="text" value="<%=libro.getIdioma()%>" name="txtIdioma" class="form-control">
    			</div>
    			<div>
    				<label>Fecha Publicacion</label>
    				<input type="date" value="<%=libro.getFecha_publicacion()%>" name="txtFechaPublicacion" class="form-control">
    			</div>
    				<div>
    				<label>Cantidad Paginas</label>
    				<input type="text" value="<%=libro.getCantidad_paginas()%>" name="txtCantidadPaginas" class="form-control">
    			</div>
    				<div>
    				<label>Stock</label>
    				<input type="text" value="<%=libro.getStock()%>" name="txtStock" class="form-control">
    			</div>
    				<div>
    				<label>Precio</label>
    				<input type="text" value="<%=libro.getPrecio()%>" name="txtPrecio" class="form-control">
    			</div>
    				<div>
    				<label>Categoria</label>
    				<input type="text" value="<%=libro.getCategoria().getDescripcion()%>" name="txtCategoria" class="form-control">
    			</div>
    				<div>
    				<label>Autor</label>
    				<input type="text" value="<%=libro.getAutor().getDescripcion()%>" name="txtAutor" class="form-control">
    			</div>
    				<div>
    				<label>Editorial</label>
    				<input type="text" value="<%=libro.getEditorial().getDescripcion()%>" name="txtEditorial" class="form-control">
    			</div>
    			<input type="submit" name="accion" value="Actualizar" class="btn btn-success">
    		</form>
    	</div>
    </div>
	</div>	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>