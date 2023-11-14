package logic;

import java.util.LinkedList;

import data.DataLibro;

import entities.Libro;
import entities.Categoria;
import entities.Autor;
import entities.Editorial;

public class LibroLogic {
	
	private DataLibro dataLibro=new DataLibro();
	
    public LinkedList<Libro> getAll()
    {
        return this.dataLibro.getAll();
    }
	
    public Libro getById(Libro libroToSearch)
    {
        return this.dataLibro.getById(libroToSearch);
    }
    
    public Libro getByTitulo(Libro libroToSearch)
    {
        return this.dataLibro.getByTitulo(libroToSearch);
    }
    
    public LinkedList<Libro> getByCategoria(Categoria categoria)
    {
        return this.dataLibro.getByCategoria(categoria);
    }
    
    public LinkedList<Libro> getByEditorial(Editorial editorial)
    {
        return this.dataLibro.getByEditorial(editorial);
    }
    
    public LinkedList<Libro> getByAutor(Autor autor)
    {
        return this.dataLibro.getByAutor(autor);
    }
     
	public void add(Libro libro) 
	{
		this.dataLibro.add(libro);
	}
	
	public void update(Libro libro) 
	{
		this.dataLibro.update(libro);
	}
	
	public void delete(Libro libro)
     {
          this.dataLibro.remove(libro);
     }
}
