package logic;

import java.util.LinkedList;

import data.DataAutor;
import entities.Autor;
import entities.Editorial;
import entities.Libro;

public class AutorLogic {

	private DataAutor dataAutor=new DataAutor();
	
    public LinkedList<Autor> getAll()
    {
        return this.dataAutor.getAll();
    }
	
    public Autor getById(Autor autorToSearch)
    {
        return this.dataAutor.getById(autorToSearch);
    }
    
    public Autor getByDesc(String descripcionToSearch)
    {
        return this.dataAutor.getByDesc(descripcionToSearch);
    }
    
	public void add(Autor autor) {

		this.dataAutor.add(autor);
	}
	
	public void update(Autor autor) 
	{
		this.dataAutor.update(autor);
	}
	
	public void delete(Autor autor)
    {
        this.dataAutor.remove(autor);
    }
	
	public void setAutorLibro (Autor autor, Libro lib) {
		this.dataAutor.setAutorLibro(autor, lib);
	}
}
