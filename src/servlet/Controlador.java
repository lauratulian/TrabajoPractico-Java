package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import logic.PersonaLogic;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Persona persona= new Persona();
	PersonaLogic pl= new PersonaLogic();
	int idCliente;
	
    public Controlador() {
        super();
    }

	
    private void procesarRequest(HttpServletRequest request, HttpServletResponse response, String menu, String accion) throws ServletException, IOException {
    	if(menu.equals("Principal")){
			request.getRequestDispatcher("Principal.jsp").forward(request, response);		
		}
		if(menu.equals("Libros")){
			request.getRequestDispatcher("pages/Libros.jsp").forward(request, response);		
		}
		if(menu.equals("Contacto")){
			request.getRequestDispatcher("pages/Contacto.jsp").forward(request, response);	
		}
		if(menu.equals("Catalogo")){
			request.getRequestDispatcher("pages/Catalogo.jsp").forward(request, response);
		}
		if(menu.equals("Ventas")){
			request.getRequestDispatcher("pages/Ventas.jsp").forward(request, response);
		}
		if(menu.equals("Local")){
			request.getRequestDispatcher("pages/Local.jsp").forward(request, response);
		}
		if(menu.equals("Persona")){
			switch (accion) {
			case "Listar":
				LinkedList<Persona> ListaPersonas= pl.getAll();
				request.setAttribute("personas", ListaPersonas);
				break;
				
			case "Agregar":
				String dni= request.getParameter("txtDni");
				String nombre= request.getParameter("txtNombre");
				String mail= request.getParameter("txtMail");
				String telefono= request.getParameter("txtTelefono");
				String direccion= request.getParameter("txtDireccion");
				String adicional= request.getParameter("txtAdicional");
				
				persona.setDni(dni);
				persona.setNombre(nombre);
				persona.setMail(mail);
				persona.setTelefono(telefono);
				persona.setDireccion(direccion);
				persona.setAdicional(adicional);
				
				pl.add(persona);
				request.getRequestDispatcher("controlador?menu=Persona&accion=Listar").forward(request, response);
				break;
				
			case "Editar":
				String idParam = request.getParameter("id");
				if (idParam != null && !idParam.isEmpty()) {
					idCliente = Integer.parseInt(idParam);
					Persona per = pl.getById(idCliente);
					if (per != null) {
						request.setAttribute("persona", per);
						request.getRequestDispatcher("pages/EditarCliente.jsp").forward(request, response);
				    }
				} 
				break;
				
			case "Eliminar":
				pl.delete(persona);
				break;
				
			default:
				throw new AssertionError();
			}
			request.getRequestDispatcher("pages/ListarCliente.jsp").forward(request, response);
            }
        }
    
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String menu = request.getParameter("menu");
    	String accion = request.getParameter("accion");

    	procesarRequest(request, response, menu, accion);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String menu = request.getParameter("menu");
	    String accion = request.getParameter("accion");

	    procesarRequest(request, response, menu, accion);
	}

	


    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
