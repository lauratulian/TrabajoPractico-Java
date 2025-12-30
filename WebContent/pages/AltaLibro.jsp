<%@ page import="entities.Categoria" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar libro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<%
LinkedList<Categoria> lc = (LinkedList<Categoria>) request.getAttribute("categorias");
%>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-lg-8">

            <div class="card shadow-sm border-0">
                <div class="card-body p-4">

                    <h4 class="mb-4">📘 Nuevo libro</h4>

                    <form action="${pageContext.request.contextPath}/controlador?menu=Libro&accion=Agregar"
                          method="post"
                          enctype="multipart/form-data">

                        <h6 class="text-muted mb-3">Información general</h6>

                        <div class="mb-3">
                            <label class="form-label">Título</label>
                            <input type="text" name="txtTitulo" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Descripción</label>
                            <textarea name="txtDescripcion" class="form-control" rows="3"></textarea>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">ISBN</label>
                                <input type="text" name="txtIsbn" class="form-control">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label">Idioma</label>
                                <input type="text" name="txtIdioma" class="form-control">
                            </div>
                        </div>

                        <h6 class="text-muted mt-4 mb-3">Clasificación</h6>

                        <div class="mb-3">
                            <label class="form-label">Categoría</label>
                            <select name="txtCategoria" class="form-select" required>
                                <option disabled selected>Seleccionar categoría</option>
                                <% for (Categoria c : lc) { %>
                                    <option value="<%=c.getId()%>"><%=c.getDescripcion()%></option>
                                <% } %>
                            </select>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">Autor</label>
                                <input type="text" name="txtAutor" class="form-control">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label">Editorial</label>
                                <input type="text" name="txtEditorial" class="form-control">
                            </div>
                        </div>

                        <h6 class="text-muted mt-4 mb-3">Precio y stock</h6>

                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Precio</label>
                                <input type="number" step="0.01" name="txtPrecio" class="form-control">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Stock</label>
                                <input type="number" name="txtStock" class="form-control">
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Cantidad de páginas</label>
                                <input type="number" name="txtCantidadPaginas" class="form-control">
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Fecha de publicación</label>
                            <input type="date" name="txtFechaPublicacion" class="form-control">
                        </div>

                        <h6 class="text-muted mt-4 mb-3">Imagen del libro</h6>

                        <div class="mb-4">
                            <input type="file" name="imagen" class="form-control" accept="image/*">
                        </div>

                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-success px-4">
                                Guardar libro
                            </button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>