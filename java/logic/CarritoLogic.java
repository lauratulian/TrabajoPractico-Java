package logic;

import java.util.LinkedList;

import entities.Libro;
public class CarritoLogic {
	  
	private LinkedList<Libro> librosEnCarrito;

	    public CarritoLogic() {
	        this.librosEnCarrito = new LinkedList<>();
	    }

	    public void addAlCarrito(Libro libro) {
	        librosEnCarrito.add(libro);
	    }

	    public void removeDelCarrito(Libro libro) {
	        librosEnCarrito.remove(libro);
	    }

	    public LinkedList<Libro> getLibrosEnCarrito() {
	        return librosEnCarrito;
	    }

	    public void clearCarrito() {
	        librosEnCarrito.clear();
	    }
}
