package logic;

import java.util.LinkedList;

import data.DataCategoria;
import entities.Categoria;

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
    
    public Categoria getByDesc(Categoria categoriaToSearch)
    {
        return this.dataCategoria.getByDesc(categoriaToSearch);
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

}
