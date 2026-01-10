package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.time.LocalDate; 
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.nio.file.Paths;

import entities.*;
import logic.*;

@WebServlet("/controlador")
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private int idCliente;
    private int idLibro;

    private static final int ROL_ADMIN = 1;
    private static final int ROL_CLIENTE = 2;

    protected void procesarRequest(HttpServletRequest request, HttpServletResponse response,
                                   String menu, String accion)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Persona usuario = (session != null) ? (Persona) session.getAttribute("usuario") : null;

        LibroLogic ll = new LibroLogic();
        PersonaLogic pl = new PersonaLogic();
        CategoriaLogic categoriaLogic = new CategoriaLogic();
        EditorialLogic editorialLogic = new EditorialLogic();
        AutorLogic autorLogic = new AutorLogic();


        if ("Principal".equals(menu)) {
            request.getRequestDispatcher("pages/Principal.jsp").forward(request, response);
            return;
        }

        if ("Contacto".equals(menu)) {
            request.getRequestDispatcher("pages/Contacto.jsp").forward(request, response);
            return;
        }

        if ("Local".equals(menu)) {
            request.getRequestDispatcher("pages/Local.jsp").forward(request, response);
            return;
        }

        if ("Ventas".equals(menu)) {
            if (usuario == null || !usuario.hasRol(crearRol(ROL_CLIENTE))) {
                response.sendRedirect("pages/AccesoDenegado.jsp");
                return;
            }
            request.getRequestDispatcher("pages/Ventas.jsp").forward(request, response);
            return;
        }


        if ("Catalogo".equals(menu)) {
            response.sendRedirect("controlador?menu=Categoria&accion=Listar");
            return;
        }

        if ("Persona".equals(menu)) {

            if (!esAdmin(usuario, response)) return;

            if ("Listar".equals(accion)) {
                request.setAttribute("personas", pl.getAll());
                request.getRequestDispatcher("pages/ListarCliente.jsp").forward(request, response);
            }

            if ("Agregar".equals(accion)) {
                Persona p = new Persona();
                p.setDni(request.getParameter("txtDni"));
                p.setNombre(request.getParameter("txtNombre"));
                p.setMail(request.getParameter("txtMail"));
                p.setTelefono(request.getParameter("txtTelefono"));
                p.setDireccion(request.getParameter("txtDireccion"));
                p.setAdicional(request.getParameter("txtAdicional"));
                pl.add(p);
                response.sendRedirect("controlador?menu=Persona&accion=Listar");
            }

            return;
        }

        if ("Libro".equals(menu)) {

            if (!esAdmin(usuario, response)) return;

            if ("Listar".equals(accion)) {
                request.setAttribute("libros", ll.getAll());
                request.getRequestDispatcher("pages/ListarLibro.jsp").forward(request, response);
            }

            if ("Listar2".equals(accion)) {
                request.setAttribute("libros", ll.getAll());
                request.getRequestDispatcher("pages/ListarLibro2.jsp").forward(request, response);
            }
            
            if ("Agregar".equals(accion)) {

                Libro libro = new Libro();

                libro.setTitulo(request.getParameter("txtTitulo"));
                libro.setDescripcion(request.getParameter("txtDescripcion"));
                libro.setIsbn(request.getParameter("txtIsbn"));
                libro.setIdioma(request.getParameter("txtIdioma"));
                libro.setFecha_publicacion(
                        LocalDate.parse(request.getParameter("txtFechaPublicacion"))
                );
                libro.setCantidad_paginas(
                        Integer.parseInt(request.getParameter("txtCantidadPaginas"))
                );
                libro.setStock(
                        Integer.parseInt(request.getParameter("txtStock"))
                );
                libro.setPrecio(
                        Double.parseDouble(request.getParameter("txtPrecio"))
                );

                int idCategoria = Integer.parseInt(request.getParameter("txtCategoria"));
                Categoria c = new Categoria();
                c.setId(idCategoria);
                libro.setCategoria(categoriaLogic.getById(c));

                String descEditorial = request.getParameter("txtEditorial");
                Editorial editorial = editorialLogic.getByDesc(descEditorial);
                if (editorial == null) {
                    editorial = new Editorial();
                    editorial.setDescripcion(descEditorial);
                    editorialLogic.add(editorial);
                    editorial = editorialLogic.getByDesc(descEditorial);
                }
                libro.setEditorial(editorial);

                String descAutor = request.getParameter("txtAutor");
                Autor autor = autorLogic.getByDesc(descAutor);
                if (autor == null) {
                    autor = new Autor();
                    autor.setDescripcion(descAutor);
                    autorLogic.add(autor);
                    autor = autorLogic.getByDesc(descAutor);
                }
                libro.setAutor(autor);

                Part filePart = request.getPart("imagen");
                if (filePart != null && filePart.getSize() > 0) {

                    String fileName = System.currentTimeMillis() + "_" +
                                      Paths.get(filePart.getSubmittedFileName()).getFileName();

                    String uploadPath = getServletContext()
                            .getRealPath("/uploads/libros");

                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    String filePath = uploadPath + File.separator + fileName;
                    filePart.write(filePath);

                    libro.setImagen("uploads/libros/" + fileName);
                }

                ll.add(libro);

                response.sendRedirect("controlador?menu=Libro&accion=Listar2");
                return;
            }

            return;
        }

        if ("Categoria".equals(menu)) {

            if ("Listar".equals(accion)) {
                request.setAttribute("categorias", categoriaLogic.getAll());
                request.getRequestDispatcher("pages/Catalogo.jsp").forward(request, response);
            }

            return;
        }

        response.sendRedirect("index.jsp");
    }

    private boolean esAdmin(Persona usuario, HttpServletResponse response) throws IOException {
        if (usuario == null || !usuario.hasRol(crearRol(ROL_ADMIN))) {
            response.sendRedirect("pages/AccesoDenegado.jsp");
            return false;
        }
        return true;
    }

    private Rol crearRol(int idRol) {
        Rol r = new Rol();
        r.setId(idRol);
        return r;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarRequest(request, response,
                request.getParameter("menu"),
                request.getParameter("accion"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarRequest(request, response,
                request.getParameter("menu"),
                request.getParameter("accion"));
    }
}
