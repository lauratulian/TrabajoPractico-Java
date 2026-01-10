<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Libro" %>

<jsp:include page="header.jsp"/>

<div class="container my-5">

    <!-- HERO -->
    <div class="row mb-5">
        <div class="col-md-6">
            <h1 class="fw-bold">Bienvendo a Trama</h1>
            <p class="text-muted">
                Descubrí nuestras últimas novedades y libros destacados.
            </p>
            <a href="controlador?menu=Catalogo" class="btn btn-info text-white">
                Ver catálogo completo
            </a>
        </div>
    </div>

    <!-- LISTADO DE PRODUCTOS -->
    <h3 class="mb-4">Novedades</h3>

    <div class="row g-4">
        <%
            LinkedList<Libro> libros =
                (LinkedList<Libro>) request.getAttribute("libros");

            if (libros != null) {
                for (Libro l : libros) {
        %>
        <div class="col-md-3">
            <div class="card h-100 shadow-sm">
                
                <!-- Imagen placeholder -->
                <img src="img/libro-default.jpg"
                     class="card-img-top"
                     alt="<%= l.getTitulo() %>">

                <div class="card-body d-flex flex-column">
                    <h6 class="card-title"><%= l.getTitulo() %></h6>

                    <p class="small text-muted mb-1">
                        <%= l.getAutor().getDescripcion() %>
                    </p>

                    <p class="fw-bold text-info mb-2">
                        $ <%= l.getPrecio() %>
                    </p>

                    <div class="mt-auto">
                        <a href="controlador?menu=Libro&accion=AgregarCarrito&id=<%= l.getId() %>"
                           class="btn btn-outline-info btn-sm w-100">
                            Agregar al carrito
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</div>

<jsp:include page="footer.jsp"/>