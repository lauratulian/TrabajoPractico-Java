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
		String accion= request.getParameter("accion");
		if (accion.equalsIgnoreCase("Ingresar")) {
			
			String mail = request.getParameter("txtmail");
			String pass = request.getParameter("txtpass");
			
			persona.setMail(mail);
			persona.setContrasenia(pass);
			
			ctrl.validate(persona);
			
			if(ctrl.validate(persona)!=null) {
				
				request.getSession().setAttribute("usuario", persona);
				request.getRequestDispatcher("controlador?accion=Principal").forward(request, response);

			}
			
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}			
	 } catch (Exception e) {
	    e.printStackTrace(); 
	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor: " + e.getMessage());
	}
	}
}
