package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion= request.getParameter("accion");
		switch (accion) {
		case "Libros":
			request.getRequestDispatcher("pages/Libros.jsp").forward(request, response);
			break;
		case "Contacto":
			request.getRequestDispatcher("pages/Contacto.jsp").forward(request, response);
			break;
		case "Catalogo":
			request.getRequestDispatcher("pages/Catalogo.jsp").forward(request, response);
			break;
		case "Ventas":
			request.getRequestDispatcher("pages/Ventas.jsp").forward(request, response);
			break;
		case "Local":
			request.getRequestDispatcher("pages/Local.jsp").forward(request, response);
			break;
		default:
				throw new AssertionError();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
