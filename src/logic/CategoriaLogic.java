package logic;

import java.util.LinkedList;

import data.DataCategoria;
import entities.Categoria;
import entities.Libro;

public class CategoriaLogic {
	
	private DataCategoria dataCategoria=new DataCategoria();
	
    public LinkedList<Categoria> getAll()
    {
        return this.dataCategoria.getAll();
    }
	
    public Categoria getById(Categoria categoriaToSearch)
    {
        return this.dataCategoria.getById(categoriaToSearch);
    }
    
    public Categoria getByDesc(String descripcionToSearch)
    {
        return this.dataCategoria.getByDesc(descripcionToSearch);
    }
    
	public void add(Categoria categoria) {

		this.dataCategoria.add(categoria);
	}
	
	public void update(Categoria categoria) 
	{
		this.dataCategoria.update(categoria);
	}
	
	public void delete(Categoria categoria)
     {
          this.dataCategoria.remove(categoria);
     }
	public void setCategoriaLibro (Categoria cat, Libro lib) {
		this.dataCategoria.setCategoriaLibro(cat, lib);
	}

}
