package logic;

import java.util.LinkedList;

import data.DataAutor;
import entities.Autor;

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
    
    public Autor getByDesc(Autor autorToSearch)
    {
        return this.dataAutor.getByDesc(autorToSearch);
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
}
