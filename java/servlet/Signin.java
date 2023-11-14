package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import logic.Login;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona persona = new Persona();
		Login ctrl = new Login();
		
		try {
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("Contrasenia");
		
		if (email == null || email.isEmpty() || contrasenia == null || contrasenia.isEmpty()) {
		    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Los parámetros no pueden estar vacíos");
		    return;
		}
		else {
			persona.setMail(email);
			persona.setContrasenia(contrasenia);
		
			ctrl.validate(persona);
		}
		
	 } catch (Exception e) {
	    e.printStackTrace(); 
	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor: " + e.getMessage());
	    response.getWriter().append("Bienvenido: ").append(persona.getNombre());
	}
	}
}
